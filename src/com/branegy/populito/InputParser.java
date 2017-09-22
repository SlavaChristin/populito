package com.branegy.populito;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.branegy.populito.functions.*;
import com.branegy.populito.functions.exp.AndExpression;
import com.branegy.populito.functions.exp.BooleanExpression;
import com.branegy.populito.functions.exp.ConditionalExpression;
import com.branegy.populito.parser.*;
import com.branegy.populito.parser.PopulitoParser.Conditional_andContext;
import com.branegy.populito.parser.PopulitoParser.Conditional_orContext;
import com.branegy.populito.parser.PopulitoParser.ConstantContext;
import com.branegy.populito.parser.PopulitoParser.ExpressionContext;
import com.branegy.populito.parser.PopulitoParser.FieldContext;
import com.branegy.populito.parser.PopulitoParser.FunctionContext;
import com.branegy.populito.parser.PopulitoParser.If_then_elseContext;
import com.branegy.populito.parser.PopulitoParser.ListContext;
import com.branegy.populito.parser.PopulitoParser.ParametersContext;
import com.branegy.populito.parser.PopulitoParser.TermContext;


public class InputParser {
	
	private Set<String> dependencies;
	
	 static class ThrowingErrorListener extends BaseErrorListener {

		 	static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();

		   @Override
		   public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
		      throws ParseCancellationException {
		         throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
		      }
		}
	public Set<String> getDependencies() {
		return dependencies;
	}
	
	public Function parseExpression(String expression) throws Exception {
		dependencies = new HashSet<String>();
		PopulitoLexer lexer = new PopulitoLexer(CharStreams.fromString(expression));
		lexer.removeErrorListeners();
		lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
				

		CommonTokenStream tokens = new CommonTokenStream( lexer );
		PopulitoParser parser = new PopulitoParser( tokens );

		parser.removeErrorListeners();
		parser.addErrorListener(ThrowingErrorListener.INSTANCE);
		   
		ExpressionContext value = parser.expression();
		return visitExpression(value);
	}

	public static void main(String[] args) throws Exception {
    	// String input = "[1,2,-76, null, $var, $parent.var, Guid()]";
    	// String input = "Time(format=\"MM/dd/yyyy HH:mm:ss.000\", min=$CreatedOn, max=\"12/10/2016 12:00:00.000\")";
		// String input = "if $x = 5 then Guid() else null end";
		String input = "if $x = 5 then Guid() else null end";

		new InputParser().parseExpression(input);
	}
	
	public static final void log(String log) {
		if (Populito.DEBUG) {
			System.out.println(log);
		}
	}
	
	private Function visitExpression(ExpressionContext ctx) throws Exception {
		log("Expression: "+ctx.getText());
		
		 Function result = null;
		 if (ctx.v_constant!=null) {
			 result = visitConstant(ctx.v_constant);
		 } else if (ctx.v_field!=null) {
			 result = visitField(ctx.v_field);
		 } else if (ctx.v_function!=null) {
			 result = visitFunction(ctx.v_function);
		 } else if (ctx.v_ifthenelse!=null){
			 result = visitIfThenElse(ctx.v_ifthenelse);
		 } else if (ctx.v_list!=null) {
			 result = visitList(ctx.v_list);
		 } else if (ctx.v_null!=null) {
			 result = new Constant(null);
		 } else {
			 throw new RuntimeException("Expected an expression");
		 }
		 return result;
	}

	private Function visitIfThenElse(If_then_elseContext ctx) throws Exception {
		log("IfThenElse: "+ctx.getText());
		Function c = visitConditionOr( ctx.v_codition.conditional_or() );
		
		Function t = visitExpression(ctx.v_then);
		Function f = visitExpression(ctx.v_else);
		
		return new ConditionalExpression(c, t, f);
	}

	private Function visitConditionOr(Conditional_orContext ctx) throws Exception {
		log("Condition[OR]: "+ctx.getText());
		List<Conditional_andContext> childs = ctx.conditional_and();
		Function result = null;
		if (childs.size()==1) {
			result = visitConditionAnd(childs.get(0));
		} else {
			List<Function> list = new ArrayList<Function>(childs.size());
			for (Conditional_andContext child : childs) {
				list.add(visitConditionAnd(child));
			}
			result = new AndExpression(list);;
		}
		return result;
	}

	private Function visitConditionAnd(Conditional_andContext ctx) throws Exception {
		log("Condition[AND]: "+ctx.getText());
		List<TermContext> childs = ctx.term();
		Function result = null;
		if (childs.size()==1) {
			result = visitTerm(childs.get(0));
		} else {
			List<Function> list = new ArrayList<Function>(childs.size());
			for (TermContext child : childs) {
				list.add(visitTerm(child));
			}
			result = new AndExpression(list);
		}
		return result;
	}

	private Function visitTerm(TermContext ctx) throws Exception {
		log("Term: "+ctx.getText());
		Function result;
		if (ctx.v_left!=null) {
			Function left = visitExpression(ctx.v_left);
			String operator = null;
			Function right = null;
			if (ctx.v_operator!=null) {
				operator = ctx.v_operator.getText();
				right = visitExpression(ctx.v_right);
			}
			result = new BooleanExpression(left, operator, right);
		} else {
			throw new Exception("Parentheses are not implemented");
			// List<ExpressionContext> expression = ctx.expression();
		}
		return result;
	}

	private Function visitFunction(FunctionContext ctx) throws Exception {
		log("Function: "+ctx.getText());

		Function result = null;

		String functionName = ctx.name.getText();
		Class<?> cls;
		try {
			cls = Class.forName("com.branegy.populito.functions." + functionName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot create function " + functionName + " (class functions."
					+ functionName + " not found)", e);
		}
		result = (Function) cls.newInstance();

		ParametersContext parameters = ctx.parameters();
		if (parameters!=null) {
			List<TerminalNode> paramNames = parameters.ID();
			List<ExpressionContext> paramValues = parameters.expression();

			for (int i = 0; i < paramNames.size(); i++) {
				String param = paramNames.get(i).getText();
				String setMethod = "set" + Character.toUpperCase(param.charAt(0));
				if (param.length() > 1) {
					setMethod += param.substring(1);
				}
				Function paramValue = visitExpression( paramValues.get(i) );
				try {
					Method method = cls.getMethod(setMethod, Function.class);
					method.invoke(result, paramValue);
				} catch (NoSuchMethodException e) {
					if (paramValue instanceof Constant) {
						Object staticValue = paramValue.nextValue();
						if (staticValue!=null) {
							try {
								Method method = cls.getMethod(setMethod, staticValue.getClass());
								method.invoke(result, staticValue);
							} catch (NoSuchMethodException ee) {
								throw new RuntimeException("Property '" + param + "' doesn't exist for function "
										+ functionName, e);
							}
						} else {
							throw new RuntimeException("Property '" + param + "' doesn't exist for function "
									+ functionName, e);
						}
					}
					log("Value is "+paramValue.getClass());
				}
			}
		}
		return result;
	}

	private Function visitField(FieldContext ctx) {
		log("Field: "+ctx.getText());
		String name = ctx.v_name.getText();
		String parent = null;
		if (ctx.v_parent!=null) {
			parent = ctx.v_parent.getText();
		} else {
			dependencies.add(name);
		}
		Field result = new Field(name, parent);
		return result;
	}

	private Function visitConstant(ConstantContext ctx) {
		log("Constant: "+ctx.getText());
		Constant result;
		if (ctx.v_number!=null) {
			try {
				result = new Constant(new Long(ctx.getText()));
			} catch (NumberFormatException e) {
				result = new Constant(new Double(ctx.getText()));
			}			
		} else if (ctx.v_string!=null) {
			String trim = ctx.getText().trim();
			result = new Constant(trim.substring(1, trim.length() - 1));
		} else {
			throw new RuntimeException("Expected a number or a string");
		}
		return result;
	}

	private Function visitList(ListContext ctx) throws Exception {
		log("List: "+ctx.getText());

		ListFunction result = new ListFunction();
		List<ExpressionContext> expression = ctx.expression();
		List<Function> values = new ArrayList<Function>(expression.size());
		for (ExpressionContext exp : expression ) {
			values.add(visitExpression(exp));
		}
		result.setValues(values);
		return result;
	}

}

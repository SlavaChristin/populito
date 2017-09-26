package com.branegy.populito.parser;

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

import com.branegy.populito.Function;
import com.branegy.populito.Populito;
import com.branegy.populito.functions.*;
import com.branegy.populito.functions.exp.BooleanExpression;
import com.branegy.populito.functions.exp.ConditionalExpression;
import com.branegy.populito.functions.exp.LogicalExpression;
import com.branegy.populito.functions.exp.MathExpression;
import com.branegy.populito.functions.exp.LogicalExpression.LogicalOperator;
import com.branegy.populito.functions.exp.MathExpression.MathOperator;
import com.branegy.populito.parser.PopulitoParser.*;


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

		MathExpressionContext ctx = parser.mathExpression();
		return visitMathExpression(ctx);
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
	
	private Function visitMathExpression(MathExpressionContext ctx) throws Exception {
		Function result = null;
		if (ctx.plusOrMinus()!=null) {
			result = visitPlusOrMinus(ctx.plusOrMinus());
		} else { 
			result = visitExpression(ctx.expression());
		}
		return result;
	}
	
	private Function visitPlusOrMinus(PlusOrMinusContext ctx) throws Exception {
		Function result = null;
		if (ctx.v_left==null) {
			result = visitMultOrDiv(ctx.v_right);
		} else {
			log("PlusOrMinus: "+ctx.getText());
			String op = ctx.v_operation.getText();
			Function left = visitPlusOrMinus(ctx.v_left);
			Function right = visitMultOrDiv(ctx.v_right);
			if (op.equals("+")) {
				result = new MathExpression(left, MathOperator.PLUS , right);
			} else if (op.equals("-")) {
				result = new MathExpression(left, MathOperator.MINUS, right);
			} else {
				throw new RuntimeException("Unexpected operator " + op);			
			}
		}
		return result;		
	}
	
	private Function visitMultOrDiv(MultOrDivContext ctx) throws Exception {
		Function result = null;
		if (ctx.v_left==null) {			
			result = visitPow(ctx.v_right);
		} else {
			log("MultOrDiv: "+ctx.getText());

			String op = ctx.v_operation.getText();
			Function left = visitMultOrDiv(ctx.v_left);
			Function right = visitPow(ctx.v_right);
			if (op.equals("*")) {
				result = new MathExpression(left, MathOperator.MULTIPLY , right);
			} else if (op.equals("/")) {
				result = new MathExpression(left, MathOperator.DIV, right);
			} else {
				throw new RuntimeException("Unexpected operator " + op);			
			}
		}	
		return result;		
	}

	private Function visitPow(PowContext ctx) throws Exception {
		Function result = null;
		if (ctx.pow()==null) {
			result = visitUnaryMinus(ctx.unaryMinus());
		} else {
			log("Pow: "+ctx.getText());
			throw new RuntimeException("Power is not implemented");
		}
		return result;
	}

	private Function visitUnaryMinus(UnaryMinusContext ctx) throws Exception {
		Function result = null;
		if (ctx.v_operation==null) {
			result = visitExpression(ctx.expression());
		} else {
			log("Unary Minus: "+ctx.getText());
			throw new RuntimeException("'Unary minus' is not implemented");	
		}		
		return result;
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
		
		Function t = visitMathExpression(ctx.v_then);
		Function f = visitMathExpression(ctx.v_else);
		
		return new ConditionalExpression(c, t, f);
	}

	private Function visitConditionOr(Conditional_orContext ctx) throws Exception {
		List<Conditional_andContext> childs = ctx.conditional_and();
		Function result = null;
		if (childs.size()==1) {
			result = visitConditionAnd(childs.get(0));
		} else {
			log("Condition[OR]: "+ctx.getText());
			List<Function> list = new ArrayList<Function>(childs.size());
			for (Conditional_andContext child : childs) {
				list.add(visitConditionAnd(child));
			}
			result = new LogicalExpression(list, LogicalOperator.OR);
		}
		return result;
	}

	private Function visitConditionAnd(Conditional_andContext ctx) throws Exception {
		List<TermContext> childs = ctx.term();
		Function result = null;
		if (childs.size()==1) {
			result = visitTerm(childs.get(0));
		} else {
			log("Condition[AND]: "+ctx.getText());
			List<Function> list = new ArrayList<Function>(childs.size());
			for (TermContext child : childs) {
				list.add(visitTerm(child));
			}
			result = new LogicalExpression(list, LogicalOperator.AND);
		}
		return result;
	}

	private Function visitTerm(TermContext ctx) throws Exception {
		Function result;
		if (ctx.v_left!=null) {
			log("Term: "+ctx.getText());
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
			cls = Populito.getFunction(functionName);
			if (cls==null) {
				cls = Class.forName("com.branegy.populito.functions." + functionName);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot create function " + functionName + " (class functions."
					+ functionName + " not found)", e);
		}
		result = (Function) cls.newInstance();

		ParametersContext parameters = ctx.parameters();
		if (parameters!=null) {
			List<TerminalNode> paramNames = parameters.ID();
			List<MathExpressionContext> paramValues = parameters.mathExpression();

			for (int i = 0; i < paramNames.size(); i++) {
				String param = paramNames.get(i).getText();
				String setMethod = "set" + Character.toUpperCase(param.charAt(0));
				if (param.length() > 1) {
					setMethod += param.substring(1);
				}
				Function paramValue = visitMathExpression( paramValues.get(i) );
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
		List<MathExpressionContext> expressions = ctx.mathExpression();
		List<Function> values = new ArrayList<Function>(expressions.size());
		for (MathExpressionContext exp : expressions ) {
			values.add(visitMathExpression(exp));
		}
		result.setValues(values);
		return result;
	}

}

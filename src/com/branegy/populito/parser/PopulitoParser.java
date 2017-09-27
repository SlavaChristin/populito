// Generated from src\com\branegy\populito\parser\Populito.g4 by ANTLR 4.7

   package com.branegy.populito.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PopulitoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, THEN=2, ELSE=3, END=4, OPEN_SB=5, CLOSE_SB=6, EQ=7, COMMA=8, DOLLAR=9, 
		DOT=10, GT=11, GE=12, LT=13, LE=14, AND=15, OR=16, NOT=17, TRUE=18, FALSE=19, 
		LPAREN=20, RPAREN=21, NULL=22, PLUS=23, MINUS=24, MULT=25, DIV=26, POWER=27, 
		ID=28, WS=29, NUMBER=30, STRING=31, ESC=32;
	public static final int
		RULE_mathExpression = 0, RULE_plusOrMinus = 1, RULE_multOrDiv = 2, RULE_pow = 3, 
		RULE_unaryMinus = 4, RULE_expression = 5, RULE_conditional_expression = 6, 
		RULE_conditional_or = 7, RULE_conditional_and = 8, RULE_term = 9, RULE_if_then_else = 10, 
		RULE_list = 11, RULE_parameters = 12, RULE_function = 13, RULE_constant = 14, 
		RULE_field = 15, RULE_operator = 16, RULE_binary = 17;
	public static final String[] ruleNames = {
		"mathExpression", "plusOrMinus", "multOrDiv", "pow", "unaryMinus", "expression", 
		"conditional_expression", "conditional_or", "conditional_and", "term", 
		"if_then_else", "list", "parameters", "function", "constant", "field", 
		"operator", "binary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'then'", "'else'", "'end'", "'['", "']'", "'='", "','", 
		"'$'", "'.'", "'>'", "'>='", "'<'", "'<='", "'and'", "'or'", "'not'", 
		"'true'", "'false'", "'('", "')'", "'null'", "'+'", "'-'", "'*'", "'/'", 
		"'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "THEN", "ELSE", "END", "OPEN_SB", "CLOSE_SB", "EQ", "COMMA", 
		"DOLLAR", "DOT", "GT", "GE", "LT", "LE", "AND", "OR", "NOT", "TRUE", "FALSE", 
		"LPAREN", "RPAREN", "NULL", "PLUS", "MINUS", "MULT", "DIV", "POWER", "ID", 
		"WS", "NUMBER", "STRING", "ESC"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Populito.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PopulitoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MathExpressionContext extends ParserRuleContext {
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MathExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExpression; }
	}

	public final MathExpressionContext mathExpression() throws RecognitionException {
		MathExpressionContext _localctx = new MathExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mathExpression);
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				plusOrMinus(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusOrMinusContext extends ParserRuleContext {
		public PlusOrMinusContext v_left;
		public MultOrDivContext v_right;
		public Token v_operation;
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PopulitoParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PopulitoParser.MINUS, 0); }
		public PlusOrMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusOrMinus; }
	}

	public final PlusOrMinusContext plusOrMinus() throws RecognitionException {
		return plusOrMinus(0);
	}

	private PlusOrMinusContext plusOrMinus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PlusOrMinusContext _localctx = new PlusOrMinusContext(_ctx, _parentState);
		PlusOrMinusContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_plusOrMinus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(41);
			((PlusOrMinusContext)_localctx).v_right = multOrDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(49);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new PlusOrMinusContext(_parentctx, _parentState);
						_localctx.v_left = _prevctx;
						_localctx.v_left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(43);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(44);
						((PlusOrMinusContext)_localctx).v_operation = match(PLUS);
						setState(45);
						((PlusOrMinusContext)_localctx).v_right = multOrDiv(0);
						}
						break;
					case 2:
						{
						_localctx = new PlusOrMinusContext(_parentctx, _parentState);
						_localctx.v_left = _prevctx;
						_localctx.v_left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(46);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(47);
						((PlusOrMinusContext)_localctx).v_operation = match(MINUS);
						setState(48);
						((PlusOrMinusContext)_localctx).v_right = multOrDiv(0);
						}
						break;
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultOrDivContext extends ParserRuleContext {
		public MultOrDivContext v_left;
		public PowContext v_right;
		public Token v_operation;
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public TerminalNode MULT() { return getToken(PopulitoParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(PopulitoParser.DIV, 0); }
		public MultOrDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOrDiv; }
	}

	public final MultOrDivContext multOrDiv() throws RecognitionException {
		return multOrDiv(0);
	}

	private MultOrDivContext multOrDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultOrDivContext _localctx = new MultOrDivContext(_ctx, _parentState);
		MultOrDivContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_multOrDiv, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(55);
			((MultOrDivContext)_localctx).v_right = pow();
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(63);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new MultOrDivContext(_parentctx, _parentState);
						_localctx.v_left = _prevctx;
						_localctx.v_left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(57);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(58);
						((MultOrDivContext)_localctx).v_operation = match(MULT);
						setState(59);
						((MultOrDivContext)_localctx).v_right = pow();
						}
						break;
					case 2:
						{
						_localctx = new MultOrDivContext(_parentctx, _parentState);
						_localctx.v_left = _prevctx;
						_localctx.v_left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(60);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(61);
						((MultOrDivContext)_localctx).v_operation = match(DIV);
						setState(62);
						((MultOrDivContext)_localctx).v_right = pow();
						}
						break;
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PowContext extends ParserRuleContext {
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public TerminalNode POWER() { return getToken(PopulitoParser.POWER, 0); }
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public PowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow; }
	}

	public final PowContext pow() throws RecognitionException {
		PowContext _localctx = new PowContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			unaryMinus();
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(69);
				match(POWER);
				setState(70);
				pow();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryMinusContext extends ParserRuleContext {
		public Token v_operation;
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PopulitoParser.MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMinus; }
	}

	public final UnaryMinusContext unaryMinus() throws RecognitionException {
		UnaryMinusContext _localctx = new UnaryMinusContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unaryMinus);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				((UnaryMinusContext)_localctx).v_operation = match(MINUS);
				setState(74);
				unaryMinus();
				}
				break;
			case IF:
			case OPEN_SB:
			case DOLLAR:
			case NULL:
			case ID:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ListContext v_list;
		public FieldContext v_field;
		public ConstantContext v_constant;
		public FunctionContext v_function;
		public If_then_elseContext v_ifthenelse;
		public Token v_null;
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public If_then_elseContext if_then_else() {
			return getRuleContext(If_then_elseContext.class,0);
		}
		public TerminalNode NULL() { return getToken(PopulitoParser.NULL, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_SB:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				((ExpressionContext)_localctx).v_list = list();
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				((ExpressionContext)_localctx).v_field = field();
				}
				break;
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				((ExpressionContext)_localctx).v_constant = constant();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				((ExpressionContext)_localctx).v_function = function();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				((ExpressionContext)_localctx).v_ifthenelse = if_then_else();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				((ExpressionContext)_localctx).v_null = match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conditional_expressionContext extends ParserRuleContext {
		public Conditional_orContext conditional_or() {
			return getRuleContext(Conditional_orContext.class,0);
		}
		public Conditional_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression; }
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_conditional_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			conditional_or();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conditional_orContext extends ParserRuleContext {
		public List<Conditional_andContext> conditional_and() {
			return getRuleContexts(Conditional_andContext.class);
		}
		public Conditional_andContext conditional_and(int i) {
			return getRuleContext(Conditional_andContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(PopulitoParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(PopulitoParser.OR, i);
		}
		public Conditional_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_or; }
	}

	public final Conditional_orContext conditional_or() throws RecognitionException {
		Conditional_orContext _localctx = new Conditional_orContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditional_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			conditional_and();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(89);
				match(OR);
				setState(90);
				conditional_and();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conditional_andContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(PopulitoParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(PopulitoParser.AND, i);
		}
		public Conditional_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_and; }
	}

	public final Conditional_andContext conditional_and() throws RecognitionException {
		Conditional_andContext _localctx = new Conditional_andContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_conditional_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			term();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(97);
				match(AND);
				setState(98);
				term();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public ExpressionContext v_left;
		public OperatorContext v_operator;
		public ExpressionContext v_right;
		public Conditional_expressionContext v_center;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PopulitoParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PopulitoParser.RPAREN, 0); }
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_term);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
			case OPEN_SB:
			case DOLLAR:
			case NULL:
			case ID:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				((TermContext)_localctx).v_left = expression();
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE))) != 0)) {
					{
					setState(105);
					((TermContext)_localctx).v_operator = operator();
					setState(106);
					((TermContext)_localctx).v_right = expression();
					}
				}

				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(LPAREN);
				setState(111);
				((TermContext)_localctx).v_center = conditional_expression();
				setState(112);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_then_elseContext extends ParserRuleContext {
		public Conditional_expressionContext v_codition;
		public MathExpressionContext v_then;
		public MathExpressionContext v_else;
		public TerminalNode IF() { return getToken(PopulitoParser.IF, 0); }
		public TerminalNode THEN() { return getToken(PopulitoParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(PopulitoParser.ELSE, 0); }
		public TerminalNode END() { return getToken(PopulitoParser.END, 0); }
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public If_then_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_then_else; }
	}

	public final If_then_elseContext if_then_else() throws RecognitionException {
		If_then_elseContext _localctx = new If_then_elseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_if_then_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(IF);
			setState(117);
			((If_then_elseContext)_localctx).v_codition = conditional_expression();
			setState(118);
			match(THEN);
			setState(119);
			((If_then_elseContext)_localctx).v_then = mathExpression();
			setState(120);
			match(ELSE);
			setState(121);
			((If_then_elseContext)_localctx).v_else = mathExpression();
			setState(122);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public TerminalNode OPEN_SB() { return getToken(PopulitoParser.OPEN_SB, 0); }
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode CLOSE_SB() { return getToken(PopulitoParser.CLOSE_SB, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PopulitoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PopulitoParser.COMMA, i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(OPEN_SB);
			setState(125);
			mathExpression();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(126);
				match(COMMA);
				setState(127);
				mathExpression();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(CLOSE_SB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PopulitoParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PopulitoParser.ID, i);
		}
		public List<TerminalNode> EQ() { return getTokens(PopulitoParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(PopulitoParser.EQ, i);
		}
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PopulitoParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PopulitoParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(ID);
			setState(136);
			match(EQ);
			setState(137);
			mathExpression();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(138);
				match(COMMA);
				setState(139);
				match(ID);
				setState(140);
				match(EQ);
				setState(141);
				mathExpression();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public Token name;
		public TerminalNode ID() { return getToken(PopulitoParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			((FunctionContext)_localctx).name = match(ID);
			setState(148);
			match(LPAREN);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(149);
				parameters();
				}
			}

			setState(152);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public Token v_number;
		public Token v_string;
		public TerminalNode NUMBER() { return getToken(PopulitoParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(PopulitoParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constant);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				((ConstantContext)_localctx).v_number = match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				((ConstantContext)_localctx).v_string = match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public Token v_parent;
		public Token v_name;
		public TerminalNode DOLLAR() { return getToken(PopulitoParser.DOLLAR, 0); }
		public List<TerminalNode> ID() { return getTokens(PopulitoParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PopulitoParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(PopulitoParser.DOT, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(DOLLAR);
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(159);
				((FieldContext)_localctx).v_parent = match(ID);
				setState(160);
				match(DOT);
				}
				break;
			}
			setState(163);
			((FieldContext)_localctx).v_name = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(PopulitoParser.GT, 0); }
		public TerminalNode GE() { return getToken(PopulitoParser.GE, 0); }
		public TerminalNode LT() { return getToken(PopulitoParser.LT, 0); }
		public TerminalNode LE() { return getToken(PopulitoParser.LE, 0); }
		public TerminalNode EQ() { return getToken(PopulitoParser.EQ, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(PopulitoParser.AND, 0); }
		public TerminalNode OR() { return getToken(PopulitoParser.OR, 0); }
		public BinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary; }
	}

	public final BinaryContext binary() throws RecognitionException {
		BinaryContext _localctx = new BinaryContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_binary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return plusOrMinus_sempred((PlusOrMinusContext)_localctx, predIndex);
		case 2:
			return multOrDiv_sempred((MultOrDivContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean plusOrMinus_sempred(PlusOrMinusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multOrDiv_sempred(MultOrDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00ac\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\5\2)\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\64"+
		"\n\3\f\3\16\3\67\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4B\n\4\f\4"+
		"\16\4E\13\4\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\5\6O\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7W\n\7\3\b\3\b\3\t\3\t\3\t\7\t^\n\t\f\t\16\ta\13\t\3\n\3\n"+
		"\3\n\7\nf\n\n\f\n\16\ni\13\n\3\13\3\13\3\13\3\13\5\13o\n\13\3\13\3\13"+
		"\3\13\3\13\5\13u\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\7\r\u0083\n\r\f\r\16\r\u0086\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\7\16\u0091\n\16\f\16\16\16\u0094\13\16\3\17\3\17\3\17\5\17\u0099"+
		"\n\17\3\17\3\17\3\20\3\20\5\20\u009f\n\20\3\21\3\21\3\21\5\21\u00a4\n"+
		"\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\2\4\4\6\24\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$\2\4\4\2\t\t\r\20\3\2\21\22\2\u00ae\2(\3\2\2\2\4"+
		"*\3\2\2\2\68\3\2\2\2\bF\3\2\2\2\nN\3\2\2\2\fV\3\2\2\2\16X\3\2\2\2\20Z"+
		"\3\2\2\2\22b\3\2\2\2\24t\3\2\2\2\26v\3\2\2\2\30~\3\2\2\2\32\u0089\3\2"+
		"\2\2\34\u0095\3\2\2\2\36\u009e\3\2\2\2 \u00a0\3\2\2\2\"\u00a7\3\2\2\2"+
		"$\u00a9\3\2\2\2&)\5\4\3\2\')\5\f\7\2(&\3\2\2\2(\'\3\2\2\2)\3\3\2\2\2*"+
		"+\b\3\1\2+,\5\6\4\2,\65\3\2\2\2-.\f\5\2\2./\7\31\2\2/\64\5\6\4\2\60\61"+
		"\f\4\2\2\61\62\7\32\2\2\62\64\5\6\4\2\63-\3\2\2\2\63\60\3\2\2\2\64\67"+
		"\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\5\3\2\2\2\67\65\3\2\2\289\b\4"+
		"\1\29:\5\b\5\2:C\3\2\2\2;<\f\5\2\2<=\7\33\2\2=B\5\b\5\2>?\f\4\2\2?@\7"+
		"\34\2\2@B\5\b\5\2A;\3\2\2\2A>\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\7"+
		"\3\2\2\2EC\3\2\2\2FI\5\n\6\2GH\7\35\2\2HJ\5\b\5\2IG\3\2\2\2IJ\3\2\2\2"+
		"J\t\3\2\2\2KL\7\32\2\2LO\5\n\6\2MO\5\f\7\2NK\3\2\2\2NM\3\2\2\2O\13\3\2"+
		"\2\2PW\5\30\r\2QW\5 \21\2RW\5\36\20\2SW\5\34\17\2TW\5\26\f\2UW\7\30\2"+
		"\2VP\3\2\2\2VQ\3\2\2\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\r\3\2"+
		"\2\2XY\5\20\t\2Y\17\3\2\2\2Z_\5\22\n\2[\\\7\22\2\2\\^\5\22\n\2][\3\2\2"+
		"\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\21\3\2\2\2a_\3\2\2\2bg\5\24\13\2cd\7"+
		"\21\2\2df\5\24\13\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\23\3\2\2"+
		"\2ig\3\2\2\2jn\5\f\7\2kl\5\"\22\2lm\5\f\7\2mo\3\2\2\2nk\3\2\2\2no\3\2"+
		"\2\2ou\3\2\2\2pq\7\26\2\2qr\5\16\b\2rs\7\27\2\2su\3\2\2\2tj\3\2\2\2tp"+
		"\3\2\2\2u\25\3\2\2\2vw\7\3\2\2wx\5\16\b\2xy\7\4\2\2yz\5\2\2\2z{\7\5\2"+
		"\2{|\5\2\2\2|}\7\6\2\2}\27\3\2\2\2~\177\7\7\2\2\177\u0084\5\2\2\2\u0080"+
		"\u0081\7\n\2\2\u0081\u0083\5\2\2\2\u0082\u0080\3\2\2\2\u0083\u0086\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u0088\7\b\2\2\u0088\31\3\2\2\2\u0089\u008a\7\36\2"+
		"\2\u008a\u008b\7\t\2\2\u008b\u0092\5\2\2\2\u008c\u008d\7\n\2\2\u008d\u008e"+
		"\7\36\2\2\u008e\u008f\7\t\2\2\u008f\u0091\5\2\2\2\u0090\u008c\3\2\2\2"+
		"\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\33"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7\36\2\2\u0096\u0098\7\26\2\2"+
		"\u0097\u0099\5\32\16\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u009b\7\27\2\2\u009b\35\3\2\2\2\u009c\u009f\7 \2\2\u009d"+
		"\u009f\7!\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\37\3\2\2\2"+
		"\u00a0\u00a3\7\13\2\2\u00a1\u00a2\7\36\2\2\u00a2\u00a4\7\f\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7\36\2\2"+
		"\u00a6!\3\2\2\2\u00a7\u00a8\t\2\2\2\u00a8#\3\2\2\2\u00a9\u00aa\t\3\2\2"+
		"\u00aa%\3\2\2\2\23(\63\65ACINV_gnt\u0084\u0092\u0098\u009e\u00a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
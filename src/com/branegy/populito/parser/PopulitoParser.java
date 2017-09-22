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
		LPAREN=20, RPAREN=21, NULL=22, ID=23, WS=24, NUMBER=25, STRING=26, ESC=27;
	public static final int
		RULE_expression = 0, RULE_conditional_expression = 1, RULE_conditional_or = 2, 
		RULE_conditional_and = 3, RULE_term = 4, RULE_if_then_else = 5, RULE_list = 6, 
		RULE_parameters = 7, RULE_function = 8, RULE_constant = 9, RULE_field = 10, 
		RULE_operator = 11, RULE_binary = 12;
	public static final String[] ruleNames = {
		"expression", "conditional_expression", "conditional_or", "conditional_and", 
		"term", "if_then_else", "list", "parameters", "function", "constant", 
		"field", "operator", "binary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'then'", "'else'", "'end'", "'['", "']'", "'='", "','", 
		"'$'", "'.'", "'>'", "'>='", "'<'", "'<='", "'and'", "'or'", "'not'", 
		"'true'", "'false'", "'('", "')'", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "THEN", "ELSE", "END", "OPEN_SB", "CLOSE_SB", "EQ", "COMMA", 
		"DOLLAR", "DOT", "GT", "GE", "LT", "LE", "AND", "OR", "NOT", "TRUE", "FALSE", 
		"LPAREN", "RPAREN", "NULL", "ID", "WS", "NUMBER", "STRING", "ESC"
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
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_SB:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				((ExpressionContext)_localctx).v_list = list();
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				((ExpressionContext)_localctx).v_field = field();
				}
				break;
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(28);
				((ExpressionContext)_localctx).v_constant = constant();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(29);
				((ExpressionContext)_localctx).v_function = function();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(30);
				((ExpressionContext)_localctx).v_ifthenelse = if_then_else();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(31);
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
		enterRule(_localctx, 2, RULE_conditional_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
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
		enterRule(_localctx, 4, RULE_conditional_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			conditional_and();
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(37);
				match(OR);
				setState(38);
				conditional_and();
				}
				}
				setState(43);
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
		enterRule(_localctx, 6, RULE_conditional_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			term();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(45);
				match(AND);
				setState(46);
				term();
				}
				}
				setState(51);
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
		enterRule(_localctx, 8, RULE_term);
		int _la;
		try {
			setState(62);
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
				setState(52);
				((TermContext)_localctx).v_left = expression();
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE))) != 0)) {
					{
					setState(53);
					((TermContext)_localctx).v_operator = operator();
					setState(54);
					((TermContext)_localctx).v_right = expression();
					}
				}

				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(LPAREN);
				setState(59);
				((TermContext)_localctx).v_center = conditional_expression();
				setState(60);
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
		public ExpressionContext v_then;
		public ExpressionContext v_else;
		public TerminalNode IF() { return getToken(PopulitoParser.IF, 0); }
		public TerminalNode THEN() { return getToken(PopulitoParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(PopulitoParser.ELSE, 0); }
		public TerminalNode END() { return getToken(PopulitoParser.END, 0); }
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public If_then_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_then_else; }
	}

	public final If_then_elseContext if_then_else() throws RecognitionException {
		If_then_elseContext _localctx = new If_then_elseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_if_then_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(IF);
			setState(65);
			((If_then_elseContext)_localctx).v_codition = conditional_expression();
			setState(66);
			match(THEN);
			setState(67);
			((If_then_elseContext)_localctx).v_then = expression();
			setState(68);
			match(ELSE);
			setState(69);
			((If_then_elseContext)_localctx).v_else = expression();
			setState(70);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 12, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(OPEN_SB);
			setState(73);
			expression();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(74);
				match(COMMA);
				setState(75);
				expression();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 14, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(ID);
			setState(84);
			match(EQ);
			setState(85);
			expression();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(86);
				match(COMMA);
				setState(87);
				match(ID);
				setState(88);
				match(EQ);
				setState(89);
				expression();
				}
				}
				setState(94);
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
		enterRule(_localctx, 16, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			((FunctionContext)_localctx).name = match(ID);
			setState(96);
			match(LPAREN);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(97);
				parameters();
				}
			}

			setState(100);
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
		enterRule(_localctx, 18, RULE_constant);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((ConstantContext)_localctx).v_number = match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
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
		enterRule(_localctx, 20, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(DOLLAR);
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(107);
				((FieldContext)_localctx).v_parent = match(ID);
				setState(108);
				match(DOT);
				}
				break;
			}
			setState(111);
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
		enterRule(_localctx, 22, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
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
		enterRule(_localctx, 24, RULE_binary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35x\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\5\2#\n\2\3\3\3\3\3\4"+
		"\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\5\3\5\3\5\7\5\62\n\5\f\5\16\5\65\13"+
		"\5\3\6\3\6\3\6\3\6\5\6;\n\6\3\6\3\6\3\6\3\6\5\6A\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bO\n\b\f\b\16\bR\13\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\7\t]\n\t\f\t\16\t`\13\t\3\n\3\n\3\n\5\ne\n\n\3\n"+
		"\3\n\3\13\3\13\5\13k\n\13\3\f\3\f\3\f\5\fp\n\f\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\4\2\t\t\r\20\3\2"+
		"\21\22\2x\2\"\3\2\2\2\4$\3\2\2\2\6&\3\2\2\2\b.\3\2\2\2\n@\3\2\2\2\fB\3"+
		"\2\2\2\16J\3\2\2\2\20U\3\2\2\2\22a\3\2\2\2\24j\3\2\2\2\26l\3\2\2\2\30"+
		"s\3\2\2\2\32u\3\2\2\2\34#\5\16\b\2\35#\5\26\f\2\36#\5\24\13\2\37#\5\22"+
		"\n\2 #\5\f\7\2!#\7\30\2\2\"\34\3\2\2\2\"\35\3\2\2\2\"\36\3\2\2\2\"\37"+
		"\3\2\2\2\" \3\2\2\2\"!\3\2\2\2#\3\3\2\2\2$%\5\6\4\2%\5\3\2\2\2&+\5\b\5"+
		"\2\'(\7\22\2\2(*\5\b\5\2)\'\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\7\3"+
		"\2\2\2-+\3\2\2\2.\63\5\n\6\2/\60\7\21\2\2\60\62\5\n\6\2\61/\3\2\2\2\62"+
		"\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\t\3\2\2\2\65\63\3\2\2\2\66"+
		":\5\2\2\2\678\5\30\r\289\5\2\2\29;\3\2\2\2:\67\3\2\2\2:;\3\2\2\2;A\3\2"+
		"\2\2<=\7\26\2\2=>\5\4\3\2>?\7\27\2\2?A\3\2\2\2@\66\3\2\2\2@<\3\2\2\2A"+
		"\13\3\2\2\2BC\7\3\2\2CD\5\4\3\2DE\7\4\2\2EF\5\2\2\2FG\7\5\2\2GH\5\2\2"+
		"\2HI\7\6\2\2I\r\3\2\2\2JK\7\7\2\2KP\5\2\2\2LM\7\n\2\2MO\5\2\2\2NL\3\2"+
		"\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\7\b\2\2T\17\3"+
		"\2\2\2UV\7\31\2\2VW\7\t\2\2W^\5\2\2\2XY\7\n\2\2YZ\7\31\2\2Z[\7\t\2\2["+
		"]\5\2\2\2\\X\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\21\3\2\2\2`^\3\2"+
		"\2\2ab\7\31\2\2bd\7\26\2\2ce\5\20\t\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fg"+
		"\7\27\2\2g\23\3\2\2\2hk\7\33\2\2ik\7\34\2\2jh\3\2\2\2ji\3\2\2\2k\25\3"+
		"\2\2\2lo\7\13\2\2mn\7\31\2\2np\7\f\2\2om\3\2\2\2op\3\2\2\2pq\3\2\2\2q"+
		"r\7\31\2\2r\27\3\2\2\2st\t\2\2\2t\31\3\2\2\2uv\t\3\2\2v\33\3\2\2\2\f\""+
		"+\63:@P^djo";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
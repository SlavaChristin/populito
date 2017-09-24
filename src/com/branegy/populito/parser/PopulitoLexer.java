// Generated from src\com\branegy\populito\parser\Populito.g4 by ANTLR 4.7

   package com.branegy.populito.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PopulitoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, THEN=2, ELSE=3, END=4, OPEN_SB=5, CLOSE_SB=6, EQ=7, COMMA=8, DOLLAR=9, 
		DOT=10, GT=11, GE=12, LT=13, LE=14, AND=15, OR=16, NOT=17, TRUE=18, FALSE=19, 
		LPAREN=20, RPAREN=21, NULL=22, PLUS=23, MINUS=24, MULT=25, DIV=26, POWER=27, 
		ID=28, WS=29, NUMBER=30, STRING=31, ESC=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IF", "THEN", "ELSE", "END", "OPEN_SB", "CLOSE_SB", "EQ", "COMMA", "DOLLAR", 
		"DOT", "GT", "GE", "LT", "LE", "AND", "OR", "NOT", "TRUE", "FALSE", "LPAREN", 
		"RPAREN", "NULL", "PLUS", "MINUS", "MULT", "DIV", "POWER", "ID", "WS", 
		"NUMBER", "STRING", "ESC"
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


	public PopulitoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Populito.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 28:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00be\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\7\35\u0096\n\35\f\35\16\35\u0099\13"+
		"\35\3\36\6\36\u009c\n\36\r\36\16\36\u009d\3\36\3\36\3\37\5\37\u00a3\n"+
		"\37\3\37\6\37\u00a6\n\37\r\37\16\37\u00a7\3\37\3\37\6\37\u00ac\n\37\r"+
		"\37\16\37\u00ad\5\37\u00b0\n\37\3 \3 \3 \7 \u00b5\n \f \16 \u00b8\13 "+
		"\3 \3 \3!\3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"\3\2\7\4\2C\\c|\5\2\62;C\\c|\4\2\13\13\"\""+
		"\6\2\f\f\17\17$$^^\n\2$$))^^ddhhppttvv\2\u00c5\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\3C\3\2\2\2\5F\3\2\2\2\7K\3\2\2\2\tP\3\2\2\2\13T\3\2\2"+
		"\2\rV\3\2\2\2\17X\3\2\2\2\21Z\3\2\2\2\23\\\3\2\2\2\25^\3\2\2\2\27`\3\2"+
		"\2\2\31b\3\2\2\2\33e\3\2\2\2\35g\3\2\2\2\37j\3\2\2\2!n\3\2\2\2#q\3\2\2"+
		"\2%u\3\2\2\2\'z\3\2\2\2)\u0080\3\2\2\2+\u0082\3\2\2\2-\u0084\3\2\2\2/"+
		"\u0089\3\2\2\2\61\u008b\3\2\2\2\63\u008d\3\2\2\2\65\u008f\3\2\2\2\67\u0091"+
		"\3\2\2\29\u0093\3\2\2\2;\u009b\3\2\2\2=\u00a2\3\2\2\2?\u00b1\3\2\2\2A"+
		"\u00bb\3\2\2\2CD\7k\2\2DE\7h\2\2E\4\3\2\2\2FG\7v\2\2GH\7j\2\2HI\7g\2\2"+
		"IJ\7p\2\2J\6\3\2\2\2KL\7g\2\2LM\7n\2\2MN\7u\2\2NO\7g\2\2O\b\3\2\2\2PQ"+
		"\7g\2\2QR\7p\2\2RS\7f\2\2S\n\3\2\2\2TU\7]\2\2U\f\3\2\2\2VW\7_\2\2W\16"+
		"\3\2\2\2XY\7?\2\2Y\20\3\2\2\2Z[\7.\2\2[\22\3\2\2\2\\]\7&\2\2]\24\3\2\2"+
		"\2^_\7\60\2\2_\26\3\2\2\2`a\7@\2\2a\30\3\2\2\2bc\7@\2\2cd\7?\2\2d\32\3"+
		"\2\2\2ef\7>\2\2f\34\3\2\2\2gh\7>\2\2hi\7?\2\2i\36\3\2\2\2jk\7c\2\2kl\7"+
		"p\2\2lm\7f\2\2m \3\2\2\2no\7q\2\2op\7t\2\2p\"\3\2\2\2qr\7p\2\2rs\7q\2"+
		"\2st\7v\2\2t$\3\2\2\2uv\7v\2\2vw\7t\2\2wx\7w\2\2xy\7g\2\2y&\3\2\2\2z{"+
		"\7h\2\2{|\7c\2\2|}\7n\2\2}~\7u\2\2~\177\7g\2\2\177(\3\2\2\2\u0080\u0081"+
		"\7*\2\2\u0081*\3\2\2\2\u0082\u0083\7+\2\2\u0083,\3\2\2\2\u0084\u0085\7"+
		"p\2\2\u0085\u0086\7w\2\2\u0086\u0087\7n\2\2\u0087\u0088\7n\2\2\u0088."+
		"\3\2\2\2\u0089\u008a\7-\2\2\u008a\60\3\2\2\2\u008b\u008c\7/\2\2\u008c"+
		"\62\3\2\2\2\u008d\u008e\7,\2\2\u008e\64\3\2\2\2\u008f\u0090\7\61\2\2\u0090"+
		"\66\3\2\2\2\u0091\u0092\7`\2\2\u00928\3\2\2\2\u0093\u0097\t\2\2\2\u0094"+
		"\u0096\t\3\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0097\u0098\3\2\2\2\u0098:\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c"+
		"\t\4\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\b\36\2\2\u00a0<\3\2\2\2"+
		"\u00a1\u00a3\7/\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5"+
		"\3\2\2\2\u00a4\u00a6\4\62;\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00af\3\2\2\2\u00a9\u00ab\7\60"+
		"\2\2\u00aa\u00ac\4\62;\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00a9\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0>\3\2\2\2\u00b1\u00b6\7$\2\2\u00b2\u00b5"+
		"\5A!\2\u00b3\u00b5\n\5\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7$\2\2\u00ba@\3\2\2\2\u00bb\u00bc"+
		"\7^\2\2\u00bc\u00bd\t\6\2\2\u00bdB\3\2\2\2\13\2\u0097\u009d\u00a2\u00a7"+
		"\u00ad\u00af\u00b4\u00b6\3\3\36\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from Micro.g4 by ANTLR 4.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PROGRAM=2, BEGIN=3, STRING=4, FUNCTION=5, INT=6, FLOAT=7, IF=8, 
		ELSIF=9, ENDIF=10, END=11, VOID=12, DO=13, WHILE=14, WRITE=15, RETURN=16, 
		READ=17, TRUE=18, BREAK=19, IDENTIFIER=20, INTLITERAL=21, FLOATLITERAL=22, 
		STRINGLITERAL=23, PLUS=24, MINUS=25, MUL=26, DIV=27, LPAREN=28, RPAREN=29, 
		LBRACE=30, RBRACE=31, LABRACKET=32, RABRACKET=33, COMMA=34, EXCLAMATION=35, 
		SEMICOLON=36, EQUAL=37, DOT=38, ASSIGN=39, NEQUAL=40, LEQUAL=41, GEQUAL=42, 
		COMMENT=43, WS=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'a'", "'PROGRAM'", "'BEGIN'", "'STRING'", "'FUNCTION'", "'INT'", "'FLOAT'", 
		"'IF'", "'ELSIF'", "'ENDIF'", "'END'", "'VOID'", "'DO'", "'WHILE'", "'WRITE'", 
		"'RETURN'", "'READ'", "'TRUE'", "'BREAK'", "IDENTIFIER", "INTLITERAL", 
		"FLOATLITERAL", "STRINGLITERAL", "'+'", "'-'", "'*'", "'/'", "'('", "')'", 
		"'{'", "'}'", "'<'", "'>'", "','", "'!'", "';'", "'='", "'.'", "':='", 
		"'!='", "'<='", "'>='", "COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__0", "PROGRAM", "BEGIN", "STRING", "FUNCTION", "INT", "FLOAT", "IF", 
		"ELSIF", "ENDIF", "END", "VOID", "DO", "WHILE", "WRITE", "RETURN", "READ", 
		"TRUE", "BREAK", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
		"PLUS", "MINUS", "MUL", "DIV", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"LABRACKET", "RABRACKET", "COMMA", "EXCLAMATION", "SEMICOLON", "EQUAL", 
		"DOT", "ASSIGN", "NEQUAL", "LEQUAL", "GEQUAL", "COMMENT", "WS"
	};


	public MicroLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 42: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 43: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2.\u0129\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\6\25\u00c5\n\25"+
		"\r\25\16\25\u00c6\3\25\7\25\u00ca\n\25\f\25\16\25\u00cd\13\25\3\26\6\26"+
		"\u00d0\n\26\r\26\16\26\u00d1\3\27\7\27\u00d5\n\27\f\27\16\27\u00d8\13"+
		"\27\3\27\7\27\u00db\n\27\f\27\16\27\u00de\13\27\3\27\3\27\6\27\u00e2\n"+
		"\27\r\27\16\27\u00e3\3\30\3\30\7\30\u00e8\n\30\f\30\16\30\u00eb\13\30"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3"+
		"(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\7,\u011c\n,\f,\16,\u011f\13,\3,"+
		"\3,\3-\6-\u0124\n-\r-\16-\u0125\3-\3-\2.\3\3\1\5\4\1\7\5\1\t\6\1\13\7"+
		"\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37"+
		"\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1"+
		"\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1"+
		"Q*\1S+\1U,\1W-\2Y.\3\3\2\t\5\2C\\aac|\3\2\62;\3\2//\3\2\60\60\3\2$$\3"+
		"\2\f\f\5\2\13\f\17\17\"\"\u0131\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2"+
		"\2\2\5]\3\2\2\2\7e\3\2\2\2\tk\3\2\2\2\13r\3\2\2\2\r{\3\2\2\2\17\177\3"+
		"\2\2\2\21\u0085\3\2\2\2\23\u0088\3\2\2\2\25\u008e\3\2\2\2\27\u0094\3\2"+
		"\2\2\31\u0098\3\2\2\2\33\u009d\3\2\2\2\35\u00a0\3\2\2\2\37\u00a6\3\2\2"+
		"\2!\u00ac\3\2\2\2#\u00b3\3\2\2\2%\u00b8\3\2\2\2\'\u00bd\3\2\2\2)\u00c4"+
		"\3\2\2\2+\u00cf\3\2\2\2-\u00d6\3\2\2\2/\u00e5\3\2\2\2\61\u00ee\3\2\2\2"+
		"\63\u00f0\3\2\2\2\65\u00f2\3\2\2\2\67\u00f4\3\2\2\29\u00f6\3\2\2\2;\u00f8"+
		"\3\2\2\2=\u00fa\3\2\2\2?\u00fc\3\2\2\2A\u00fe\3\2\2\2C\u0100\3\2\2\2E"+
		"\u0102\3\2\2\2G\u0104\3\2\2\2I\u0106\3\2\2\2K\u0108\3\2\2\2M\u010a\3\2"+
		"\2\2O\u010c\3\2\2\2Q\u010f\3\2\2\2S\u0112\3\2\2\2U\u0115\3\2\2\2W\u0118"+
		"\3\2\2\2Y\u0123\3\2\2\2[\\\7c\2\2\\\4\3\2\2\2]^\7R\2\2^_\7T\2\2_`\7Q\2"+
		"\2`a\7I\2\2ab\7T\2\2bc\7C\2\2cd\7O\2\2d\6\3\2\2\2ef\7D\2\2fg\7G\2\2gh"+
		"\7I\2\2hi\7K\2\2ij\7P\2\2j\b\3\2\2\2kl\7U\2\2lm\7V\2\2mn\7T\2\2no\7K\2"+
		"\2op\7P\2\2pq\7I\2\2q\n\3\2\2\2rs\7H\2\2st\7W\2\2tu\7P\2\2uv\7E\2\2vw"+
		"\7V\2\2wx\7K\2\2xy\7Q\2\2yz\7P\2\2z\f\3\2\2\2{|\7K\2\2|}\7P\2\2}~\7V\2"+
		"\2~\16\3\2\2\2\177\u0080\7H\2\2\u0080\u0081\7N\2\2\u0081\u0082\7Q\2\2"+
		"\u0082\u0083\7C\2\2\u0083\u0084\7V\2\2\u0084\20\3\2\2\2\u0085\u0086\7"+
		"K\2\2\u0086\u0087\7H\2\2\u0087\22\3\2\2\2\u0088\u0089\7G\2\2\u0089\u008a"+
		"\7N\2\2\u008a\u008b\7U\2\2\u008b\u008c\7K\2\2\u008c\u008d\7H\2\2\u008d"+
		"\24\3\2\2\2\u008e\u008f\7G\2\2\u008f\u0090\7P\2\2\u0090\u0091\7F\2\2\u0091"+
		"\u0092\7K\2\2\u0092\u0093\7H\2\2\u0093\26\3\2\2\2\u0094\u0095\7G\2\2\u0095"+
		"\u0096\7P\2\2\u0096\u0097\7F\2\2\u0097\30\3\2\2\2\u0098\u0099\7X\2\2\u0099"+
		"\u009a\7Q\2\2\u009a\u009b\7K\2\2\u009b\u009c\7F\2\2\u009c\32\3\2\2\2\u009d"+
		"\u009e\7F\2\2\u009e\u009f\7Q\2\2\u009f\34\3\2\2\2\u00a0\u00a1\7Y\2\2\u00a1"+
		"\u00a2\7J\2\2\u00a2\u00a3\7K\2\2\u00a3\u00a4\7N\2\2\u00a4\u00a5\7G\2\2"+
		"\u00a5\36\3\2\2\2\u00a6\u00a7\7Y\2\2\u00a7\u00a8\7T\2\2\u00a8\u00a9\7"+
		"K\2\2\u00a9\u00aa\7V\2\2\u00aa\u00ab\7G\2\2\u00ab \3\2\2\2\u00ac\u00ad"+
		"\7T\2\2\u00ad\u00ae\7G\2\2\u00ae\u00af\7V\2\2\u00af\u00b0\7W\2\2\u00b0"+
		"\u00b1\7T\2\2\u00b1\u00b2\7P\2\2\u00b2\"\3\2\2\2\u00b3\u00b4\7T\2\2\u00b4"+
		"\u00b5\7G\2\2\u00b5\u00b6\7C\2\2\u00b6\u00b7\7F\2\2\u00b7$\3\2\2\2\u00b8"+
		"\u00b9\7V\2\2\u00b9\u00ba\7T\2\2\u00ba\u00bb\7W\2\2\u00bb\u00bc\7G\2\2"+
		"\u00bc&\3\2\2\2\u00bd\u00be\7D\2\2\u00be\u00bf\7T\2\2\u00bf\u00c0\7G\2"+
		"\2\u00c0\u00c1\7C\2\2\u00c1\u00c2\7M\2\2\u00c2(\3\2\2\2\u00c3\u00c5\t"+
		"\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00cb\3\2\2\2\u00c8\u00ca\t\3\2\2\u00c9\u00c8\3\2"+
		"\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"*\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\t\3\2\2\u00cf\u00ce\3\2\2\2"+
		"\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2,\3"+
		"\2\2\2\u00d3\u00d5\t\4\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00dc\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d9\u00db\t\3\2\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00dc\3\2"+
		"\2\2\u00df\u00e1\t\5\2\2\u00e0\u00e2\t\3\2\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4.\3\2\2\2"+
		"\u00e5\u00e9\7$\2\2\u00e6\u00e8\n\6\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ed\7$\2\2\u00ed\60\3\2\2\2\u00ee\u00ef\7-\2\2"+
		"\u00ef\62\3\2\2\2\u00f0\u00f1\7/\2\2\u00f1\64\3\2\2\2\u00f2\u00f3\7,\2"+
		"\2\u00f3\66\3\2\2\2\u00f4\u00f5\7\61\2\2\u00f58\3\2\2\2\u00f6\u00f7\7"+
		"*\2\2\u00f7:\3\2\2\2\u00f8\u00f9\7+\2\2\u00f9<\3\2\2\2\u00fa\u00fb\7}"+
		"\2\2\u00fb>\3\2\2\2\u00fc\u00fd\7\177\2\2\u00fd@\3\2\2\2\u00fe\u00ff\7"+
		">\2\2\u00ffB\3\2\2\2\u0100\u0101\7@\2\2\u0101D\3\2\2\2\u0102\u0103\7."+
		"\2\2\u0103F\3\2\2\2\u0104\u0105\7#\2\2\u0105H\3\2\2\2\u0106\u0107\7=\2"+
		"\2\u0107J\3\2\2\2\u0108\u0109\7?\2\2\u0109L\3\2\2\2\u010a\u010b\7\60\2"+
		"\2\u010bN\3\2\2\2\u010c\u010d\7<\2\2\u010d\u010e\7?\2\2\u010eP\3\2\2\2"+
		"\u010f\u0110\7#\2\2\u0110\u0111\7?\2\2\u0111R\3\2\2\2\u0112\u0113\7>\2"+
		"\2\u0113\u0114\7?\2\2\u0114T\3\2\2\2\u0115\u0116\7@\2\2\u0116\u0117\7"+
		"?\2\2\u0117V\3\2\2\2\u0118\u0119\7/\2\2\u0119\u011d\7/\2\2\u011a\u011c"+
		"\n\7\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\b,"+
		"\2\2\u0121X\3\2\2\2\u0122\u0124\t\b\2\2\u0123\u0122\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0128\b-\3\2\u0128Z\3\2\2\2\f\2\u00c6\u00cb\u00d1\u00d6\u00dc\u00e3\u00e9"+
		"\u011d\u0125";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
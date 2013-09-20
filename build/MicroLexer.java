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
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, PROGRAM=20, BEGIN=21, STRING=22, FUNCTION=23, 
		INT=24, FLOAT=25, IF=26, ELSIF=27, ENDIF=28, END=29, VOID=30, DO=31, WHILE=32, 
		WRITE=33, RETURN=34, READ=35, TRUE=36, FALSE=37, BREAK=38, IDENTIFIER=39, 
		INTLITERAL=40, FLOATLITERAL=41, STRINGLITERAL=42, COMMENT=43, WS=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'*'", "'-'", "'('", "'<'", "'!='", "'<='", "'CONTINUE'", "'ELSE'", 
		"'FOR'", "')'", "'+'", "'='", "';'", "'>'", "'ENDFOR'", "':='", "'/'", 
		"'>='", "'PROGRAM'", "'BEGIN'", "'STRING'", "'FUNCTION'", "'INT'", "'FLOAT'", 
		"'IF'", "'ELSIF'", "'ENDIF'", "'END'", "'VOID'", "'DO'", "'WHILE'", "'WRITE'", 
		"'RETURN'", "'READ'", "'TRUE'", "'FALSE'", "'BREAK'", "IDENTIFIER", "INTLITERAL", 
		"FLOATLITERAL", "STRINGLITERAL", "COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "PROGRAM", "BEGIN", "STRING", "FUNCTION", "INT", "FLOAT", 
		"IF", "ELSIF", "ENDIF", "END", "VOID", "DO", "WHILE", "WRITE", "RETURN", 
		"READ", "TRUE", "FALSE", "BREAK", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", 
		"STRINGLITERAL", "COMMENT", "WS"
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2.\u013e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&"+
		"\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\6(\u0104\n(\r(\16(\u0105\3(\7"+
		"(\u0109\n(\f(\16(\u010c\13(\3)\6)\u010f\n)\r)\16)\u0110\3*\7*\u0114\n"+
		"*\f*\16*\u0117\13*\3*\7*\u011a\n*\f*\16*\u011d\13*\3*\3*\6*\u0121\n*\r"+
		"*\16*\u0122\3+\3+\7+\u0127\n+\f+\16+\u012a\13+\3+\3+\3,\3,\3,\7,\u0131"+
		"\n,\f,\16,\u0134\13,\3,\3,\3-\6-\u0139\n-\r-\16-\u013a\3-\3-\2.\3\3\1"+
		"\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31"+
		"\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30"+
		"\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1"+
		"E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\2Y.\3\3\2\t\5\2C\\aac|\3\2\62"+
		";\3\2//\3\2\60\60\3\2$$\3\2\f\f\5\2\13\f\17\17\"\"\u0146\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3\2"+
		"\2\2\re\3\2\2\2\17h\3\2\2\2\21k\3\2\2\2\23t\3\2\2\2\25y\3\2\2\2\27}\3"+
		"\2\2\2\31\177\3\2\2\2\33\u0081\3\2\2\2\35\u0083\3\2\2\2\37\u0085\3\2\2"+
		"\2!\u0087\3\2\2\2#\u008e\3\2\2\2%\u0091\3\2\2\2\'\u0093\3\2\2\2)\u0096"+
		"\3\2\2\2+\u009e\3\2\2\2-\u00a4\3\2\2\2/\u00ab\3\2\2\2\61\u00b4\3\2\2\2"+
		"\63\u00b8\3\2\2\2\65\u00be\3\2\2\2\67\u00c1\3\2\2\29\u00c7\3\2\2\2;\u00cd"+
		"\3\2\2\2=\u00d1\3\2\2\2?\u00d6\3\2\2\2A\u00d9\3\2\2\2C\u00df\3\2\2\2E"+
		"\u00e5\3\2\2\2G\u00ec\3\2\2\2I\u00f1\3\2\2\2K\u00f6\3\2\2\2M\u00fc\3\2"+
		"\2\2O\u0103\3\2\2\2Q\u010e\3\2\2\2S\u0115\3\2\2\2U\u0124\3\2\2\2W\u012d"+
		"\3\2\2\2Y\u0138\3\2\2\2[\\\7.\2\2\\\4\3\2\2\2]^\7,\2\2^\6\3\2\2\2_`\7"+
		"/\2\2`\b\3\2\2\2ab\7*\2\2b\n\3\2\2\2cd\7>\2\2d\f\3\2\2\2ef\7#\2\2fg\7"+
		"?\2\2g\16\3\2\2\2hi\7>\2\2ij\7?\2\2j\20\3\2\2\2kl\7E\2\2lm\7Q\2\2mn\7"+
		"P\2\2no\7V\2\2op\7K\2\2pq\7P\2\2qr\7W\2\2rs\7G\2\2s\22\3\2\2\2tu\7G\2"+
		"\2uv\7N\2\2vw\7U\2\2wx\7G\2\2x\24\3\2\2\2yz\7H\2\2z{\7Q\2\2{|\7T\2\2|"+
		"\26\3\2\2\2}~\7+\2\2~\30\3\2\2\2\177\u0080\7-\2\2\u0080\32\3\2\2\2\u0081"+
		"\u0082\7?\2\2\u0082\34\3\2\2\2\u0083\u0084\7=\2\2\u0084\36\3\2\2\2\u0085"+
		"\u0086\7@\2\2\u0086 \3\2\2\2\u0087\u0088\7G\2\2\u0088\u0089\7P\2\2\u0089"+
		"\u008a\7F\2\2\u008a\u008b\7H\2\2\u008b\u008c\7Q\2\2\u008c\u008d\7T\2\2"+
		"\u008d\"\3\2\2\2\u008e\u008f\7<\2\2\u008f\u0090\7?\2\2\u0090$\3\2\2\2"+
		"\u0091\u0092\7\61\2\2\u0092&\3\2\2\2\u0093\u0094\7@\2\2\u0094\u0095\7"+
		"?\2\2\u0095(\3\2\2\2\u0096\u0097\7R\2\2\u0097\u0098\7T\2\2\u0098\u0099"+
		"\7Q\2\2\u0099\u009a\7I\2\2\u009a\u009b\7T\2\2\u009b\u009c\7C\2\2\u009c"+
		"\u009d\7O\2\2\u009d*\3\2\2\2\u009e\u009f\7D\2\2\u009f\u00a0\7G\2\2\u00a0"+
		"\u00a1\7I\2\2\u00a1\u00a2\7K\2\2\u00a2\u00a3\7P\2\2\u00a3,\3\2\2\2\u00a4"+
		"\u00a5\7U\2\2\u00a5\u00a6\7V\2\2\u00a6\u00a7\7T\2\2\u00a7\u00a8\7K\2\2"+
		"\u00a8\u00a9\7P\2\2\u00a9\u00aa\7I\2\2\u00aa.\3\2\2\2\u00ab\u00ac\7H\2"+
		"\2\u00ac\u00ad\7W\2\2\u00ad\u00ae\7P\2\2\u00ae\u00af\7E\2\2\u00af\u00b0"+
		"\7V\2\2\u00b0\u00b1\7K\2\2\u00b1\u00b2\7Q\2\2\u00b2\u00b3\7P\2\2\u00b3"+
		"\60\3\2\2\2\u00b4\u00b5\7K\2\2\u00b5\u00b6\7P\2\2\u00b6\u00b7\7V\2\2\u00b7"+
		"\62\3\2\2\2\u00b8\u00b9\7H\2\2\u00b9\u00ba\7N\2\2\u00ba\u00bb\7Q\2\2\u00bb"+
		"\u00bc\7C\2\2\u00bc\u00bd\7V\2\2\u00bd\64\3\2\2\2\u00be\u00bf\7K\2\2\u00bf"+
		"\u00c0\7H\2\2\u00c0\66\3\2\2\2\u00c1\u00c2\7G\2\2\u00c2\u00c3\7N\2\2\u00c3"+
		"\u00c4\7U\2\2\u00c4\u00c5\7K\2\2\u00c5\u00c6\7H\2\2\u00c68\3\2\2\2\u00c7"+
		"\u00c8\7G\2\2\u00c8\u00c9\7P\2\2\u00c9\u00ca\7F\2\2\u00ca\u00cb\7K\2\2"+
		"\u00cb\u00cc\7H\2\2\u00cc:\3\2\2\2\u00cd\u00ce\7G\2\2\u00ce\u00cf\7P\2"+
		"\2\u00cf\u00d0\7F\2\2\u00d0<\3\2\2\2\u00d1\u00d2\7X\2\2\u00d2\u00d3\7"+
		"Q\2\2\u00d3\u00d4\7K\2\2\u00d4\u00d5\7F\2\2\u00d5>\3\2\2\2\u00d6\u00d7"+
		"\7F\2\2\u00d7\u00d8\7Q\2\2\u00d8@\3\2\2\2\u00d9\u00da\7Y\2\2\u00da\u00db"+
		"\7J\2\2\u00db\u00dc\7K\2\2\u00dc\u00dd\7N\2\2\u00dd\u00de\7G\2\2\u00de"+
		"B\3\2\2\2\u00df\u00e0\7Y\2\2\u00e0\u00e1\7T\2\2\u00e1\u00e2\7K\2\2\u00e2"+
		"\u00e3\7V\2\2\u00e3\u00e4\7G\2\2\u00e4D\3\2\2\2\u00e5\u00e6\7T\2\2\u00e6"+
		"\u00e7\7G\2\2\u00e7\u00e8\7V\2\2\u00e8\u00e9\7W\2\2\u00e9\u00ea\7T\2\2"+
		"\u00ea\u00eb\7P\2\2\u00ebF\3\2\2\2\u00ec\u00ed\7T\2\2\u00ed\u00ee\7G\2"+
		"\2\u00ee\u00ef\7C\2\2\u00ef\u00f0\7F\2\2\u00f0H\3\2\2\2\u00f1\u00f2\7"+
		"V\2\2\u00f2\u00f3\7T\2\2\u00f3\u00f4\7W\2\2\u00f4\u00f5\7G\2\2\u00f5J"+
		"\3\2\2\2\u00f6\u00f7\7H\2\2\u00f7\u00f8\7C\2\2\u00f8\u00f9\7N\2\2\u00f9"+
		"\u00fa\7U\2\2\u00fa\u00fb\7G\2\2\u00fbL\3\2\2\2\u00fc\u00fd\7D\2\2\u00fd"+
		"\u00fe\7T\2\2\u00fe\u00ff\7G\2\2\u00ff\u0100\7C\2\2\u0100\u0101\7M\2\2"+
		"\u0101N\3\2\2\2\u0102\u0104\t\2\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3"+
		"\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u010a\3\2\2\2\u0107"+
		"\u0109\t\3\2\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010bP\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f"+
		"\t\3\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111R\3\2\2\2\u0112\u0114\t\4\2\2\u0113\u0112\3\2\2\2"+
		"\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u011b"+
		"\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011a\t\3\2\2\u0119\u0118\3\2\2\2\u011a"+
		"\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011e\u0120\t\5\2\2\u011f\u0121\t\3\2\2\u0120"+
		"\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123T\3\2\2\2\u0124\u0128\7$\2\2\u0125\u0127\n\6\2\2\u0126\u0125"+
		"\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c\7$\2\2\u012cV\3\2\2\2\u012d"+
		"\u012e\7/\2\2\u012e\u0132\7/\2\2\u012f\u0131\n\7\2\2\u0130\u012f\3\2\2"+
		"\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135"+
		"\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\b,\2\2\u0136X\3\2\2\2\u0137\u0139"+
		"\t\b\2\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a"+
		"\u013b\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\b-\3\2\u013dZ\3\2\2\2\f"+
		"\2\u0105\u010a\u0110\u0115\u011b\u0122\u0128\u0132\u013a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
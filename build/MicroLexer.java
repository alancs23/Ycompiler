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
		T__0=1, KEYWORD=2, IDENTIFIER=3, INTLITERAL=4, FLOATLITERAL=5, OPEARTOR=6, 
		STRINGLITERAL=7, COMMENT=8, WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'a'", "KEYWORD", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", "OPEARTOR", 
		"STRINGLITERAL", "COMMENT", "WS"
	};
	public static final String[] ruleNames = {
		"T__0", "KEYWORD", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", "OPEARTOR", 
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
		case 7: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 8: WS_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\13\u00b2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3l\n"+
		"\3\3\4\6\4o\n\4\r\4\16\4p\3\4\7\4t\n\4\f\4\16\4w\13\4\3\5\6\5z\n\5\r\5"+
		"\16\5{\3\6\7\6\177\n\6\f\6\16\6\u0082\13\6\3\6\7\6\u0085\n\6\f\6\16\6"+
		"\u0088\13\6\3\6\3\6\6\6\u008c\n\6\r\6\16\6\u008d\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u0097\n\7\3\b\3\b\7\b\u009b\n\b\f\b\16\b\u009e\13\b\3\b\3\b"+
		"\3\t\3\t\3\t\7\t\u00a5\n\t\f\t\16\t\u00a8\13\t\3\t\3\t\3\n\6\n\u00ad\n"+
		"\n\r\n\16\n\u00ae\3\n\3\n\2\13\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17"+
		"\t\1\21\n\2\23\13\3\3\2\n\5\2C\\aac|\3\2\62;\3\2//\3\2\60\60\b\2##*\61"+
		"=@^^}}\177\177\3\2$$\3\2\f\f\5\2\13\f\17\17\"\"\u00ce\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5k\3\2\2\2\7n\3\2\2\2\ty\3\2\2"+
		"\2\13\u0080\3\2\2\2\r\u0096\3\2\2\2\17\u0098\3\2\2\2\21\u00a1\3\2\2\2"+
		"\23\u00ac\3\2\2\2\25\26\7c\2\2\26\4\3\2\2\2\27\30\7R\2\2\30\31\7T\2\2"+
		"\31\32\7Q\2\2\32\33\7I\2\2\33\34\7T\2\2\34\35\7C\2\2\35l\7O\2\2\36\37"+
		"\7D\2\2\37 \7G\2\2 !\7I\2\2!\"\7K\2\2\"l\7P\2\2#$\7U\2\2$%\7V\2\2%&\7"+
		"T\2\2&\'\7K\2\2\'(\7P\2\2(l\7I\2\2)*\7H\2\2*+\7W\2\2+,\7P\2\2,-\7E\2\2"+
		"-.\7V\2\2./\7K\2\2/\60\7Q\2\2\60l\7P\2\2\61\62\7K\2\2\62\63\7P\2\2\63"+
		"l\7V\2\2\64\65\7H\2\2\65\66\7N\2\2\66\67\7Q\2\2\678\7C\2\28l\7V\2\29:"+
		"\7K\2\2:l\7H\2\2;<\7G\2\2<=\7N\2\2=>\7U\2\2>?\7K\2\2?l\7H\2\2@A\7G\2\2"+
		"AB\7P\2\2BC\7F\2\2CD\7K\2\2Dl\7H\2\2EF\7G\2\2FG\7P\2\2Gl\7F\2\2HI\7X\2"+
		"\2IJ\7Q\2\2JK\7K\2\2Kl\7F\2\2LM\7F\2\2Ml\7Q\2\2NO\7Y\2\2OP\7J\2\2PQ\7"+
		"K\2\2QR\7N\2\2Rl\7G\2\2ST\7Y\2\2TU\7T\2\2UV\7K\2\2VW\7V\2\2Wl\7G\2\2X"+
		"Y\7T\2\2YZ\7G\2\2Z[\7V\2\2[\\\7W\2\2\\]\7T\2\2]l\7P\2\2^_\7T\2\2_`\7G"+
		"\2\2`a\7C\2\2al\7F\2\2bc\7V\2\2cd\7T\2\2de\7W\2\2el\7G\2\2fg\7D\2\2gh"+
		"\7T\2\2hi\7G\2\2ij\7C\2\2jl\7M\2\2k\27\3\2\2\2k\36\3\2\2\2k#\3\2\2\2k"+
		")\3\2\2\2k\61\3\2\2\2k\64\3\2\2\2k9\3\2\2\2k;\3\2\2\2k@\3\2\2\2kE\3\2"+
		"\2\2kH\3\2\2\2kL\3\2\2\2kN\3\2\2\2kS\3\2\2\2kX\3\2\2\2k^\3\2\2\2kb\3\2"+
		"\2\2kf\3\2\2\2l\6\3\2\2\2mo\t\2\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3"+
		"\2\2\2qu\3\2\2\2rt\t\3\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\b"+
		"\3\2\2\2wu\3\2\2\2xz\t\3\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|"+
		"\n\3\2\2\2}\177\t\4\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0086\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\t\3"+
		"\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\t\5"+
		"\2\2\u008a\u008c\t\3\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\f\3\2\2\2\u008f\u0097\t\6\2\2"+
		"\u0090\u0091\7<\2\2\u0091\u0097\7?\2\2\u0092\u0093\7#\2\2\u0093\u0097"+
		"\7?\2\2\u0094\u0095\7>\2\2\u0095\u0097\7?\2\2\u0096\u008f\3\2\2\2\u0096"+
		"\u0090\3\2\2\2\u0096\u0092\3\2\2\2\u0096\u0094\3\2\2\2\u0097\16\3\2\2"+
		"\2\u0098\u009c\7$\2\2\u0099\u009b\n\7\2\2\u009a\u0099\3\2\2\2\u009b\u009e"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a0\7$\2\2\u00a0\20\3\2\2\2\u00a1\u00a2\7/\2\2"+
		"\u00a2\u00a6\7/\2\2\u00a3\u00a5\n\b\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00aa\b\t\2\2\u00aa\22\3\2\2\2\u00ab\u00ad\t\t\2"+
		"\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\b\n\3\2\u00b1\24\3\2\2\2\16\2"+
		"kpu{\u0080\u0086\u008d\u0096\u009c\u00a6\u00ae";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
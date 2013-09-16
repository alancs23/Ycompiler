// Generated from Micro.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "'a'", "'PROGRAM'", "'BEGIN'", "'STRING'", "'FUNCTION'", 
		"'INT'", "'FLOAT'", "'IF'", "'ELSIF'", "'ENDIF'", "'END'", "'VOID'", "'DO'", 
		"'WHILE'", "'WRITE'", "'RETURN'", "'READ'", "'TRUE'", "'BREAK'", "IDENTIFIER", 
		"INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "'+'", "'-'", "'*'", "'/'", 
		"'('", "')'", "'{'", "'}'", "'<'", "'>'", "','", "'!'", "';'", "'='", 
		"'.'", "':='", "'!='", "'<='", "'>='", "COMMENT", "WS"
	};
	public static final int
		RULE_a = 0;
	public static final String[] ruleNames = {
		"a"
	};

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public MicroParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AContext extends ParserRuleContext {
		public AContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitA(this);
		}
	}

	public final AContext a() throws RecognitionException {
		AContext _localctx = new AContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_a);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2); match(1);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3.\7\4\2\t\2\3\2\3"+
		"\2\3\2\2\3\2\2\2\5\2\4\3\2\2\2\4\5\7\3\2\2\5\3\3\2\2\2\2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// $ANTLR 3.3 Nov 30, 2010 12:50:56 Micro.g 2013-11-30 18:38:46

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MicroLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ID_LIST=4;
    public static final int CALL_EXPR=5;
    public static final int STMT_LIST=6;
    public static final int FUNC_DECL_LIST=7;
    public static final int FUNC_BODY=8;
    public static final int EXPR_LIST=9;
    public static final int PARAM_DECL_LIST=10;
    public static final int VAR_DECL=11;
    public static final int DECL=12;
    public static final int STRING_DECL=13;
    public static final int PGM_BODY=14;
    public static final int PROGRAM=15;
    public static final int BEGIN=16;
    public static final int END=17;
    public static final int IDENTIFIER=18;
    public static final int STRING=19;
    public static final int ASSIGN=20;
    public static final int SEMICOLON=21;
    public static final int STRINGLITERAL=22;
    public static final int FLOAT=23;
    public static final int INT=24;
    public static final int VOID=25;
    public static final int COMMA=26;
    public static final int FUNCTION=27;
    public static final int READ=28;
    public static final int LP=29;
    public static final int RP=30;
    public static final int WRITE=31;
    public static final int RETURN=32;
    public static final int INTLITERAL=33;
    public static final int FLOATLITERAL=34;
    public static final int ADD=35;
    public static final int SUB=36;
    public static final int MULT=37;
    public static final int DIV=38;
    public static final int IF=39;
    public static final int ENDIF=40;
    public static final int ELSIF=41;
    public static final int TRUE=42;
    public static final int FALSE=43;
    public static final int L=44;
    public static final int G=45;
    public static final int EQ=46;
    public static final int LE=47;
    public static final int GE=48;
    public static final int NE=49;
    public static final int DO=50;
    public static final int WHILE=51;
    public static final int FOR=52;
    public static final int ENDFOR=53;
    public static final int BREAK=54;
    public static final int CONTINUE=55;
    public static final int COMMENT=56;
    public static final int WS=57;

    // delegates
    // delegators

    public MicroLexer() {;} 
    public MicroLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MicroLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Micro.g"; }

    // $ANTLR start "PROGRAM"
    public final void mPROGRAM() throws RecognitionException {
        try {
            int _type = PROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:202:9: ( 'PROGRAM' )
            // Micro.g:202:11: 'PROGRAM'
            {
            match("PROGRAM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROGRAM"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:203:9: ( 'BEGIN' )
            // Micro.g:203:11: 'BEGIN'
            {
            match("BEGIN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:204:9: ( 'STRING' )
            // Micro.g:204:11: 'STRING'
            {
            match("STRING"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:205:10: ( 'FUNCTION' )
            // Micro.g:205:13: 'FUNCTION'
            {
            match("FUNCTION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:206:9: ( 'INT' )
            // Micro.g:206:12: 'INT'
            {
            match("INT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:207:9: ( 'FLOAT' )
            // Micro.g:207:12: 'FLOAT'
            {
            match("FLOAT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:208:9: ( 'IF' )
            // Micro.g:208:12: 'IF'
            {
            match("IF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSIF"
    public final void mELSIF() throws RecognitionException {
        try {
            int _type = ELSIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:209:9: ( 'ELSIF' )
            // Micro.g:209:12: 'ELSIF'
            {
            match("ELSIF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSIF"

    // $ANTLR start "ENDIF"
    public final void mENDIF() throws RecognitionException {
        try {
            int _type = ENDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:210:9: ( 'ENDIF' )
            // Micro.g:210:12: 'ENDIF'
            {
            match("ENDIF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDIF"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:211:9: ( 'END' )
            // Micro.g:211:12: 'END'
            {
            match("END"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "VOID"
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:212:9: ( 'VOID' )
            // Micro.g:212:12: 'VOID'
            {
            match("VOID"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VOID"

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:213:9: ( 'DO' )
            // Micro.g:213:12: 'DO'
            {
            match("DO"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:214:9: ( 'WHILE' )
            // Micro.g:214:12: 'WHILE'
            {
            match("WHILE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:215:9: ( 'FOR' )
            // Micro.g:215:12: 'FOR'
            {
            match("FOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "ENDFOR"
    public final void mENDFOR() throws RecognitionException {
        try {
            int _type = ENDFOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:216:9: ( 'ENDFOR' )
            // Micro.g:216:12: 'ENDFOR'
            {
            match("ENDFOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDFOR"

    // $ANTLR start "WRITE"
    public final void mWRITE() throws RecognitionException {
        try {
            int _type = WRITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:217:9: ( 'WRITE' )
            // Micro.g:217:12: 'WRITE'
            {
            match("WRITE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WRITE"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:218:9: ( 'RETURN' )
            // Micro.g:218:12: 'RETURN'
            {
            match("RETURN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "READ"
    public final void mREAD() throws RecognitionException {
        try {
            int _type = READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:219:9: ( 'READ' )
            // Micro.g:219:12: 'READ'
            {
            match("READ"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "READ"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:220:9: ( 'TRUE' )
            // Micro.g:220:12: 'TRUE'
            {
            match("TRUE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:221:9: ( 'FALSE' )
            // Micro.g:221:12: 'FALSE'
            {
            match("FALSE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "BREAK"
    public final void mBREAK() throws RecognitionException {
        try {
            int _type = BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:222:9: ( 'BREAK' )
            // Micro.g:222:12: 'BREAK'
            {
            match("BREAK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BREAK"

    // $ANTLR start "CONTINUE"
    public final void mCONTINUE() throws RecognitionException {
        try {
            int _type = CONTINUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:223:9: ( 'CONTINUE' )
            // Micro.g:223:12: 'CONTINUE'
            {
            match("CONTINUE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTINUE"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:224:9: ( ':=' )
            // Micro.g:224:12: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:225:11: ( ';' )
            // Micro.g:225:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:226:9: ( ',' )
            // Micro.g:226:11: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "LP"
    public final void mLP() throws RecognitionException {
        try {
            int _type = LP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:227:9: ( '(' )
            // Micro.g:227:11: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LP"

    // $ANTLR start "RP"
    public final void mRP() throws RecognitionException {
        try {
            int _type = RP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:228:9: ( ')' )
            // Micro.g:228:11: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RP"

    // $ANTLR start "G"
    public final void mG() throws RecognitionException {
        try {
            int _type = G;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:229:9: ( '>' )
            // Micro.g:229:11: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "G"

    // $ANTLR start "L"
    public final void mL() throws RecognitionException {
        try {
            int _type = L;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:230:9: ( '<' )
            // Micro.g:230:12: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "L"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:231:9: ( '>=' )
            // Micro.g:231:11: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:232:9: ( '<=' )
            // Micro.g:232:11: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:233:9: ( '=' )
            // Micro.g:233:12: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:234:9: ( '!=' )
            // Micro.g:234:11: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NE"

    // $ANTLR start "ADD"
    public final void mADD() throws RecognitionException {
        try {
            int _type = ADD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:235:9: ( '+' )
            // Micro.g:235:11: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ADD"

    // $ANTLR start "SUB"
    public final void mSUB() throws RecognitionException {
        try {
            int _type = SUB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:236:9: ( '-' )
            // Micro.g:236:11: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUB"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:237:9: ( '*' )
            // Micro.g:237:11: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:238:9: ( '/' )
            // Micro.g:238:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:240:12: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // Micro.g:240:14: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // Micro.g:240:38: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Micro.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "INTLITERAL"
    public final void mINTLITERAL() throws RecognitionException {
        try {
            int _type = INTLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:241:12: ( ( '0' .. '9' )+ )
            // Micro.g:241:14: ( '0' .. '9' )+
            {
            // Micro.g:241:14: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Micro.g:241:15: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTLITERAL"

    // $ANTLR start "FLOATLITERAL"
    public final void mFLOATLITERAL() throws RecognitionException {
        try {
            int _type = FLOATLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:242:13: ( ( '0' .. '9' )* '.' ( '0' .. '9' )+ )
            // Micro.g:242:15: ( '0' .. '9' )* '.' ( '0' .. '9' )+
            {
            // Micro.g:242:15: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Micro.g:242:16: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('.'); 
            // Micro.g:242:29: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Micro.g:242:30: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOATLITERAL"

    // $ANTLR start "STRINGLITERAL"
    public final void mSTRINGLITERAL() throws RecognitionException {
        try {
            int _type = STRINGLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:243:14: ( '\"' (~ ( '\"' ) )* '\"' )
            // Micro.g:243:16: '\"' (~ ( '\"' ) )* '\"'
            {
            match('\"'); 
            // Micro.g:243:19: (~ ( '\"' ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Micro.g:243:19: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRINGLITERAL"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:245:9: ( '--' (~ '\\n' )* '\\n' )
            // Micro.g:245:11: '--' (~ '\\n' )* '\\n'
            {
            match("--"); 

            // Micro.g:245:16: (~ '\\n' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Micro.g:245:16: ~ '\\n'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\n'); 
            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Micro.g:246:4: ( ( ' ' | '\\r' | '\\n' | '\\t' | '\\f' )+ )
            // Micro.g:246:6: ( ' ' | '\\r' | '\\n' | '\\t' | '\\f' )+
            {
            // Micro.g:246:6: ( ' ' | '\\r' | '\\n' | '\\t' | '\\f' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||(LA7_0>='\f' && LA7_0<='\r')||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Micro.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // Micro.g:1:8: ( PROGRAM | BEGIN | STRING | FUNCTION | INT | FLOAT | IF | ELSIF | ENDIF | END | VOID | DO | WHILE | FOR | ENDFOR | WRITE | RETURN | READ | TRUE | FALSE | BREAK | CONTINUE | ASSIGN | SEMICOLON | COMMA | LP | RP | G | L | GE | LE | EQ | NE | ADD | SUB | MULT | DIV | IDENTIFIER | INTLITERAL | FLOATLITERAL | STRINGLITERAL | COMMENT | WS )
        int alt8=43;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // Micro.g:1:10: PROGRAM
                {
                mPROGRAM(); 

                }
                break;
            case 2 :
                // Micro.g:1:18: BEGIN
                {
                mBEGIN(); 

                }
                break;
            case 3 :
                // Micro.g:1:24: STRING
                {
                mSTRING(); 

                }
                break;
            case 4 :
                // Micro.g:1:31: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 5 :
                // Micro.g:1:40: INT
                {
                mINT(); 

                }
                break;
            case 6 :
                // Micro.g:1:44: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 7 :
                // Micro.g:1:50: IF
                {
                mIF(); 

                }
                break;
            case 8 :
                // Micro.g:1:53: ELSIF
                {
                mELSIF(); 

                }
                break;
            case 9 :
                // Micro.g:1:59: ENDIF
                {
                mENDIF(); 

                }
                break;
            case 10 :
                // Micro.g:1:65: END
                {
                mEND(); 

                }
                break;
            case 11 :
                // Micro.g:1:69: VOID
                {
                mVOID(); 

                }
                break;
            case 12 :
                // Micro.g:1:74: DO
                {
                mDO(); 

                }
                break;
            case 13 :
                // Micro.g:1:77: WHILE
                {
                mWHILE(); 

                }
                break;
            case 14 :
                // Micro.g:1:83: FOR
                {
                mFOR(); 

                }
                break;
            case 15 :
                // Micro.g:1:87: ENDFOR
                {
                mENDFOR(); 

                }
                break;
            case 16 :
                // Micro.g:1:94: WRITE
                {
                mWRITE(); 

                }
                break;
            case 17 :
                // Micro.g:1:100: RETURN
                {
                mRETURN(); 

                }
                break;
            case 18 :
                // Micro.g:1:107: READ
                {
                mREAD(); 

                }
                break;
            case 19 :
                // Micro.g:1:112: TRUE
                {
                mTRUE(); 

                }
                break;
            case 20 :
                // Micro.g:1:117: FALSE
                {
                mFALSE(); 

                }
                break;
            case 21 :
                // Micro.g:1:123: BREAK
                {
                mBREAK(); 

                }
                break;
            case 22 :
                // Micro.g:1:129: CONTINUE
                {
                mCONTINUE(); 

                }
                break;
            case 23 :
                // Micro.g:1:138: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 24 :
                // Micro.g:1:145: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 25 :
                // Micro.g:1:155: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 26 :
                // Micro.g:1:161: LP
                {
                mLP(); 

                }
                break;
            case 27 :
                // Micro.g:1:164: RP
                {
                mRP(); 

                }
                break;
            case 28 :
                // Micro.g:1:167: G
                {
                mG(); 

                }
                break;
            case 29 :
                // Micro.g:1:169: L
                {
                mL(); 

                }
                break;
            case 30 :
                // Micro.g:1:171: GE
                {
                mGE(); 

                }
                break;
            case 31 :
                // Micro.g:1:174: LE
                {
                mLE(); 

                }
                break;
            case 32 :
                // Micro.g:1:177: EQ
                {
                mEQ(); 

                }
                break;
            case 33 :
                // Micro.g:1:180: NE
                {
                mNE(); 

                }
                break;
            case 34 :
                // Micro.g:1:183: ADD
                {
                mADD(); 

                }
                break;
            case 35 :
                // Micro.g:1:187: SUB
                {
                mSUB(); 

                }
                break;
            case 36 :
                // Micro.g:1:191: MULT
                {
                mMULT(); 

                }
                break;
            case 37 :
                // Micro.g:1:196: DIV
                {
                mDIV(); 

                }
                break;
            case 38 :
                // Micro.g:1:200: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 39 :
                // Micro.g:1:211: INTLITERAL
                {
                mINTLITERAL(); 

                }
                break;
            case 40 :
                // Micro.g:1:222: FLOATLITERAL
                {
                mFLOATLITERAL(); 

                }
                break;
            case 41 :
                // Micro.g:1:235: STRINGLITERAL
                {
                mSTRINGLITERAL(); 

                }
                break;
            case 42 :
                // Micro.g:1:249: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 43 :
                // Micro.g:1:257: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\14\32\5\uffff\1\63\1\65\3\uffff\1\67\3\uffff\1\70\3\uffff"+
        "\11\32\1\102\3\32\1\106\5\32\7\uffff\6\32\1\123\1\32\1\125\1\uffff"+
        "\1\32\1\131\1\32\1\uffff\14\32\1\uffff\1\32\1\uffff\3\32\1\uffff"+
        "\1\153\3\32\1\157\1\160\2\32\1\163\1\164\2\32\1\167\1\170\1\171"+
        "\1\172\1\32\1\uffff\1\174\1\175\1\32\2\uffff\2\32\2\uffff\1\u0081"+
        "\1\32\4\uffff\1\u0083\2\uffff\1\u0084\1\32\1\u0086\1\uffff\1\32"+
        "\2\uffff\1\32\1\uffff\1\u0089\1\u008a\2\uffff";
    static final String DFA8_eofS =
        "\u008b\uffff";
    static final String DFA8_minS =
        "\1\11\1\122\1\105\1\124\1\101\1\106\1\114\2\117\1\110\1\105\1\122"+
        "\1\117\5\uffff\2\75\3\uffff\1\55\3\uffff\1\56\3\uffff\1\117\1\107"+
        "\1\105\1\122\1\116\1\117\1\122\1\114\1\124\1\60\1\123\1\104\1\111"+
        "\1\60\2\111\1\101\1\125\1\116\7\uffff\1\107\1\111\1\101\1\111\1"+
        "\103\1\101\1\60\1\123\1\60\1\uffff\1\111\1\60\1\104\1\uffff\1\114"+
        "\1\124\1\125\1\104\1\105\1\124\1\122\1\116\1\113\1\116\2\124\1\uffff"+
        "\1\105\1\uffff\2\106\1\117\1\uffff\1\60\2\105\1\122\2\60\1\111\1"+
        "\101\2\60\1\107\1\111\4\60\1\122\1\uffff\2\60\1\116\2\uffff\1\116"+
        "\1\115\2\uffff\1\60\1\117\4\uffff\1\60\2\uffff\1\60\1\125\1\60\1"+
        "\uffff\1\116\2\uffff\1\105\1\uffff\2\60\2\uffff";
    static final String DFA8_maxS =
        "\1\172\2\122\1\124\1\125\2\116\2\117\1\122\1\105\1\122\1\117\5\uffff"+
        "\2\75\3\uffff\1\55\3\uffff\1\71\3\uffff\1\117\1\107\1\105\1\122"+
        "\1\116\1\117\1\122\1\114\1\124\1\172\1\123\1\104\1\111\1\172\2\111"+
        "\1\124\1\125\1\116\7\uffff\1\107\1\111\1\101\1\111\1\103\1\101\1"+
        "\172\1\123\1\172\1\uffff\1\111\1\172\1\104\1\uffff\1\114\1\124\1"+
        "\125\1\104\1\105\1\124\1\122\1\116\1\113\1\116\2\124\1\uffff\1\105"+
        "\1\uffff\2\106\1\117\1\uffff\1\172\2\105\1\122\2\172\1\111\1\101"+
        "\2\172\1\107\1\111\4\172\1\122\1\uffff\2\172\1\116\2\uffff\1\116"+
        "\1\115\2\uffff\1\172\1\117\4\uffff\1\172\2\uffff\1\172\1\125\1\172"+
        "\1\uffff\1\116\2\uffff\1\105\1\uffff\2\172\2\uffff";
    static final String DFA8_acceptS =
        "\15\uffff\1\27\1\30\1\31\1\32\1\33\2\uffff\1\40\1\41\1\42\1\uffff"+
        "\1\44\1\45\1\46\1\uffff\1\50\1\51\1\53\23\uffff\1\36\1\34\1\37\1"+
        "\35\1\52\1\43\1\47\11\uffff\1\7\3\uffff\1\14\14\uffff\1\16\1\uffff"+
        "\1\5\3\uffff\1\12\21\uffff\1\13\3\uffff\1\22\1\23\2\uffff\1\2\1"+
        "\25\2\uffff\1\6\1\24\1\10\1\11\1\uffff\1\15\1\20\3\uffff\1\3\1\uffff"+
        "\1\17\1\21\1\uffff\1\1\2\uffff\1\4\1\26";
    static final String DFA8_specialS =
        "\u008b\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\36\1\uffff\2\36\22\uffff\1\36\1\25\1\35\5\uffff\1\20\1\21"+
            "\1\30\1\26\1\17\1\27\1\34\1\31\12\33\1\15\1\16\1\23\1\24\1\22"+
            "\2\uffff\1\32\1\2\1\14\1\10\1\6\1\4\2\32\1\5\6\32\1\1\1\32\1"+
            "\12\1\3\1\13\1\32\1\7\1\11\3\32\4\uffff\1\32\1\uffff\32\32",
            "\1\37",
            "\1\40\14\uffff\1\41",
            "\1\42",
            "\1\46\12\uffff\1\44\2\uffff\1\45\5\uffff\1\43",
            "\1\50\7\uffff\1\47",
            "\1\51\1\uffff\1\52",
            "\1\53",
            "\1\54",
            "\1\55\11\uffff\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "",
            "",
            "",
            "",
            "",
            "\1\62",
            "\1\64",
            "",
            "",
            "",
            "\1\66",
            "",
            "",
            "",
            "\1\34\1\uffff\12\33",
            "",
            "",
            "",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\103",
            "\1\104",
            "\1\105",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\107",
            "\1\110",
            "\1\112\22\uffff\1\111",
            "\1\113",
            "\1\114",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\124",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\126",
            "\12\32\7\uffff\5\32\1\130\2\32\1\127\21\32\4\uffff\1\32\1\uffff"+
            "\32\32",
            "\1\132",
            "",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "",
            "\1\147",
            "",
            "\1\150",
            "\1\151",
            "\1\152",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\154",
            "\1\155",
            "\1\156",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\161",
            "\1\162",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\165",
            "\1\166",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\173",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\176",
            "",
            "",
            "\1\177",
            "\1\u0080",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\u0082",
            "",
            "",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\u0085",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\u0087",
            "",
            "",
            "\1\u0088",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( PROGRAM | BEGIN | STRING | FUNCTION | INT | FLOAT | IF | ELSIF | ENDIF | END | VOID | DO | WHILE | FOR | ENDFOR | WRITE | RETURN | READ | TRUE | FALSE | BREAK | CONTINUE | ASSIGN | SEMICOLON | COMMA | LP | RP | G | L | GE | LE | EQ | NE | ADD | SUB | MULT | DIV | IDENTIFIER | INTLITERAL | FLOATLITERAL | STRINGLITERAL | COMMENT | WS );";
        }
    }
 

}
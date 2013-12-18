// $ANTLR 3.3 Nov 30, 2010 12:50:56 Micro.g 2013-12-08 16:41:58

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class MicroParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID_LIST", "CALL_EXPR", "STMT_LIST", "FUNC_DECL_LIST", "FUNC_BODY", "EXPR_LIST", "PARAM_DECL_LIST", "VAR_DECL", "DECL", "STRING_DECL", "PGM_BODY", "PROGRAM", "BEGIN", "END", "IDENTIFIER", "STRING", "ASSIGN", "SEMICOLON", "STRINGLITERAL", "FLOAT", "INT", "VOID", "COMMA", "FUNCTION", "READ", "LP", "RP", "WRITE", "RETURN", "INTLITERAL", "FLOATLITERAL", "ADD", "SUB", "MULT", "DIV", "IF", "ENDIF", "ELSIF", "TRUE", "FALSE", "L", "G", "EQ", "LE", "GE", "NE", "DO", "WHILE", "FOR", "ENDFOR", "BREAK", "CONTINUE", "COMMENT", "WS"
    };
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


        public MicroParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MicroParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return MicroParser.tokenNames; }
    public String getGrammarFileName() { return "Micro.g"; }


    	 Integer blockCnt = 0;
    	 boolean errFlag = true;
    	 SymbolTable globalTab;
    	 SymbolTable curTab;
    	 String output = "";


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // Micro.g:31:1: program : PROGRAM id BEGIN pgm_body END ;
    public final MicroParser.program_return program() throws RecognitionException {
        MicroParser.program_return retval = new MicroParser.program_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PROGRAM1=null;
        Token BEGIN3=null;
        Token END5=null;
        MicroParser.id_return id2 = null;

        MicroParser.pgm_body_return pgm_body4 = null;


        CommonTree PROGRAM1_tree=null;
        CommonTree BEGIN3_tree=null;
        CommonTree END5_tree=null;

        try {
            // Micro.g:32:5: ( PROGRAM id BEGIN pgm_body END )
            // Micro.g:32:8: PROGRAM id BEGIN pgm_body END
            {
            root_0 = (CommonTree)adaptor.nil();

            PROGRAM1=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program139); 
            PROGRAM1_tree = (CommonTree)adaptor.create(PROGRAM1);
            root_0 = (CommonTree)adaptor.becomeRoot(PROGRAM1_tree, root_0);

            pushFollow(FOLLOW_id_in_program142);
            id2=id();

            state._fsp--;

            BEGIN3=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_program145); 
            pushFollow(FOLLOW_pgm_body_in_program148);
            pgm_body4=pgm_body();

            state._fsp--;

            adaptor.addChild(root_0, pgm_body4.getTree());
            END5=(Token)match(input,END,FOLLOW_END_in_program150); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class id_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "id"
    // Micro.g:35:1: id : IDENTIFIER ;
    public final MicroParser.id_return id() throws RecognitionException {
        MicroParser.id_return retval = new MicroParser.id_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENTIFIER6=null;

        CommonTree IDENTIFIER6_tree=null;

        try {
            // Micro.g:35:12: ( IDENTIFIER )
            // Micro.g:35:14: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENTIFIER6=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_id171); 
            IDENTIFIER6_tree = (CommonTree)adaptor.create(IDENTIFIER6);
            adaptor.addChild(root_0, IDENTIFIER6_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "id"

    public static class pgm_body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pgm_body"
    // Micro.g:37:1: pgm_body : decl func_declarations -> ^( PGM_BODY decl func_declarations ) ;
    public final MicroParser.pgm_body_return pgm_body() throws RecognitionException {
        MicroParser.pgm_body_return retval = new MicroParser.pgm_body_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.decl_return decl7 = null;

        MicroParser.func_declarations_return func_declarations8 = null;


        RewriteRuleSubtreeStream stream_func_declarations=new RewriteRuleSubtreeStream(adaptor,"rule func_declarations");
        RewriteRuleSubtreeStream stream_decl=new RewriteRuleSubtreeStream(adaptor,"rule decl");
        try {
            // Micro.g:37:10: ( decl func_declarations -> ^( PGM_BODY decl func_declarations ) )
            // Micro.g:37:12: decl func_declarations
            {
            pushFollow(FOLLOW_decl_in_pgm_body180);
            decl7=decl();

            state._fsp--;

            stream_decl.add(decl7.getTree());
            pushFollow(FOLLOW_func_declarations_in_pgm_body182);
            func_declarations8=func_declarations();

            state._fsp--;

            stream_func_declarations.add(func_declarations8.getTree());


            // AST REWRITE
            // elements: func_declarations, decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 37:35: -> ^( PGM_BODY decl func_declarations )
            {
                // Micro.g:37:38: ^( PGM_BODY decl func_declarations )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PGM_BODY, "PGM_BODY"), root_1);

                adaptor.addChild(root_1, stream_decl.nextTree());
                adaptor.addChild(root_1, stream_func_declarations.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pgm_body"

    public static class decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "decl"
    // Micro.g:40:1: decl : ( decl_list )* -> ^( DECL ( decl_list )* ) ;
    public final MicroParser.decl_return decl() throws RecognitionException {
        MicroParser.decl_return retval = new MicroParser.decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.decl_list_return decl_list9 = null;


        RewriteRuleSubtreeStream stream_decl_list=new RewriteRuleSubtreeStream(adaptor,"rule decl_list");
        try {
            // Micro.g:40:7: ( ( decl_list )* -> ^( DECL ( decl_list )* ) )
            // Micro.g:40:9: ( decl_list )*
            {
            // Micro.g:40:9: ( decl_list )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==STRING||(LA1_0>=FLOAT && LA1_0<=INT)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Micro.g:40:9: decl_list
            	    {
            	    pushFollow(FOLLOW_decl_list_in_decl206);
            	    decl_list9=decl_list();

            	    state._fsp--;

            	    stream_decl_list.add(decl_list9.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: decl_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 40:20: -> ^( DECL ( decl_list )* )
            {
                // Micro.g:40:23: ^( DECL ( decl_list )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECL, "DECL"), root_1);

                // Micro.g:40:30: ( decl_list )*
                while ( stream_decl_list.hasNext() ) {
                    adaptor.addChild(root_1, stream_decl_list.nextTree());

                }
                stream_decl_list.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decl"

    public static class decl_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "decl_list"
    // Micro.g:42:1: decl_list : ( string_decl_list | var_decl_list );
    public final MicroParser.decl_list_return decl_list() throws RecognitionException {
        MicroParser.decl_list_return retval = new MicroParser.decl_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.string_decl_list_return string_decl_list10 = null;

        MicroParser.var_decl_list_return var_decl_list11 = null;



        try {
            // Micro.g:42:17: ( string_decl_list | var_decl_list )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==STRING) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=FLOAT && LA2_0<=INT)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // Micro.g:42:19: string_decl_list
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_string_decl_list_in_decl_list230);
                    string_decl_list10=string_decl_list();

                    state._fsp--;

                    adaptor.addChild(root_0, string_decl_list10.getTree());

                    }
                    break;
                case 2 :
                    // Micro.g:42:38: var_decl_list
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_var_decl_list_in_decl_list234);
                    var_decl_list11=var_decl_list();

                    state._fsp--;

                    adaptor.addChild(root_0, var_decl_list11.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decl_list"

    public static class string_decl_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string_decl_list"
    // Micro.g:45:1: string_decl_list : ( string_decl )+ ;
    public final MicroParser.string_decl_list_return string_decl_list() throws RecognitionException {
        MicroParser.string_decl_list_return retval = new MicroParser.string_decl_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.string_decl_return string_decl12 = null;



        try {
            // Micro.g:45:19: ( ( string_decl )+ )
            // Micro.g:45:21: ( string_decl )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // Micro.g:45:21: ( string_decl )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==STRING) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Micro.g:45:21: string_decl
            	    {
            	    pushFollow(FOLLOW_string_decl_in_string_decl_list246);
            	    string_decl12=string_decl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, string_decl12.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "string_decl_list"

    public static class string_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string_decl"
    // Micro.g:47:1: string_decl : STRING id ASSIGN str SEMICOLON ;
    public final MicroParser.string_decl_return string_decl() throws RecognitionException {
        MicroParser.string_decl_return retval = new MicroParser.string_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING13=null;
        Token ASSIGN15=null;
        Token SEMICOLON17=null;
        MicroParser.id_return id14 = null;

        MicroParser.str_return str16 = null;


        CommonTree STRING13_tree=null;
        CommonTree ASSIGN15_tree=null;
        CommonTree SEMICOLON17_tree=null;

        try {
            // Micro.g:47:13: ( STRING id ASSIGN str SEMICOLON )
            // Micro.g:47:15: STRING id ASSIGN str SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING13=(Token)match(input,STRING,FOLLOW_STRING_in_string_decl256); 
            STRING13_tree = (CommonTree)adaptor.create(STRING13);
            root_0 = (CommonTree)adaptor.becomeRoot(STRING13_tree, root_0);

            pushFollow(FOLLOW_id_in_string_decl259);
            id14=id();

            state._fsp--;

            adaptor.addChild(root_0, id14.getTree());
            ASSIGN15=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_string_decl261); 
            pushFollow(FOLLOW_str_in_string_decl264);
            str16=str();

            state._fsp--;

            adaptor.addChild(root_0, str16.getTree());
            SEMICOLON17=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_string_decl266); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "string_decl"

    public static class str_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "str"
    // Micro.g:49:1: str : STRINGLITERAL ;
    public final MicroParser.str_return str() throws RecognitionException {
        MicroParser.str_return retval = new MicroParser.str_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRINGLITERAL18=null;

        CommonTree STRINGLITERAL18_tree=null;

        try {
            // Micro.g:49:6: ( STRINGLITERAL )
            // Micro.g:49:8: STRINGLITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            STRINGLITERAL18=(Token)match(input,STRINGLITERAL,FOLLOW_STRINGLITERAL_in_str277); 
            STRINGLITERAL18_tree = (CommonTree)adaptor.create(STRINGLITERAL18);
            adaptor.addChild(root_0, STRINGLITERAL18_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "str"

    public static class var_decl_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_decl_list"
    // Micro.g:53:1: var_decl_list : ( var_decl )+ ;
    public final MicroParser.var_decl_list_return var_decl_list() throws RecognitionException {
        MicroParser.var_decl_list_return retval = new MicroParser.var_decl_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.var_decl_return var_decl19 = null;



        try {
            // Micro.g:53:15: ( ( var_decl )+ )
            // Micro.g:53:17: ( var_decl )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // Micro.g:53:17: ( var_decl )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=FLOAT && LA4_0<=INT)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Micro.g:53:17: var_decl
            	    {
            	    pushFollow(FOLLOW_var_decl_in_var_decl_list289);
            	    var_decl19=var_decl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, var_decl19.getTree());

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

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var_decl_list"

    public static class var_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_decl"
    // Micro.g:55:1: var_decl : var_type var_id_list ';' -> ^( VAR_DECL var_type var_id_list ) ;
    public final MicroParser.var_decl_return var_decl() throws RecognitionException {
        MicroParser.var_decl_return retval = new MicroParser.var_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal22=null;
        MicroParser.var_type_return var_type20 = null;

        MicroParser.var_id_list_return var_id_list21 = null;


        CommonTree char_literal22_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleSubtreeStream stream_var_type=new RewriteRuleSubtreeStream(adaptor,"rule var_type");
        RewriteRuleSubtreeStream stream_var_id_list=new RewriteRuleSubtreeStream(adaptor,"rule var_id_list");
        try {
            // Micro.g:55:17: ( var_type var_id_list ';' -> ^( VAR_DECL var_type var_id_list ) )
            // Micro.g:55:19: var_type var_id_list ';'
            {
            pushFollow(FOLLOW_var_type_in_var_decl306);
            var_type20=var_type();

            state._fsp--;

            stream_var_type.add(var_type20.getTree());
            pushFollow(FOLLOW_var_id_list_in_var_decl308);
            var_id_list21=var_id_list();

            state._fsp--;

            stream_var_id_list.add(var_id_list21.getTree());
            char_literal22=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_var_decl310);  
            stream_SEMICOLON.add(char_literal22);



            // AST REWRITE
            // elements: var_type, var_id_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 55:44: -> ^( VAR_DECL var_type var_id_list )
            {
                // Micro.g:55:47: ^( VAR_DECL var_type var_id_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_DECL, "VAR_DECL"), root_1);

                adaptor.addChild(root_1, stream_var_type.nextTree());
                adaptor.addChild(root_1, stream_var_id_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var_decl"

    public static class var_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_type"
    // Micro.g:57:1: var_type : ( FLOAT | INT );
    public final MicroParser.var_type_return var_type() throws RecognitionException {
        MicroParser.var_type_return retval = new MicroParser.var_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set23=null;

        CommonTree set23_tree=null;

        try {
            // Micro.g:57:10: ( FLOAT | INT )
            // Micro.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set23=(Token)input.LT(1);
            if ( (input.LA(1)>=FLOAT && input.LA(1)<=INT) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set23));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var_type"

    public static class any_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "any_type"
    // Micro.g:61:1: any_type : ( var_type | VOID );
    public final MicroParser.any_type_return any_type() throws RecognitionException {
        MicroParser.any_type_return retval = new MicroParser.any_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VOID25=null;
        MicroParser.var_type_return var_type24 = null;


        CommonTree VOID25_tree=null;

        try {
            // Micro.g:61:17: ( var_type | VOID )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=FLOAT && LA5_0<=INT)) ) {
                alt5=1;
            }
            else if ( (LA5_0==VOID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // Micro.g:61:19: var_type
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_var_type_in_any_type389);
                    var_type24=var_type();

                    state._fsp--;

                    adaptor.addChild(root_0, var_type24.getTree());

                    }
                    break;
                case 2 :
                    // Micro.g:62:19: VOID
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    VOID25=(Token)match(input,VOID,FOLLOW_VOID_in_any_type409); 
                    VOID25_tree = (CommonTree)adaptor.create(VOID25);
                    adaptor.addChild(root_0, VOID25_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "any_type"

    public static class var_id_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_id_list"
    // Micro.g:64:1: var_id_list : var_id ( COMMA var_id )* ;
    public final MicroParser.var_id_list_return var_id_list() throws RecognitionException {
        MicroParser.var_id_list_return retval = new MicroParser.var_id_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA27=null;
        MicroParser.var_id_return var_id26 = null;

        MicroParser.var_id_return var_id28 = null;


        CommonTree COMMA27_tree=null;

        try {
            // Micro.g:64:13: ( var_id ( COMMA var_id )* )
            // Micro.g:64:15: var_id ( COMMA var_id )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_var_id_in_var_id_list433);
            var_id26=var_id();

            state._fsp--;

            adaptor.addChild(root_0, var_id26.getTree());
            // Micro.g:64:22: ( COMMA var_id )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Micro.g:64:24: COMMA var_id
            	    {
            	    COMMA27=(Token)match(input,COMMA,FOLLOW_COMMA_in_var_id_list437); 
            	    pushFollow(FOLLOW_var_id_in_var_id_list440);
            	    var_id28=var_id();

            	    state._fsp--;

            	    adaptor.addChild(root_0, var_id28.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var_id_list"

    public static class var_id_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_id"
    // Micro.g:66:1: var_id : id ;
    public final MicroParser.var_id_return var_id() throws RecognitionException {
        MicroParser.var_id_return retval = new MicroParser.var_id_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.id_return id29 = null;



        try {
            // Micro.g:66:9: ( id )
            // Micro.g:66:11: id
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_id_in_var_id454);
            id29=id();

            state._fsp--;

            adaptor.addChild(root_0, id29.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "var_id"

    public static class id_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "id_list"
    // Micro.g:81:1: id_list : id ( ',' id )* -> ^( ID_LIST ( id )+ ) ;
    public final MicroParser.id_list_return id_list() throws RecognitionException {
        MicroParser.id_list_return retval = new MicroParser.id_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal31=null;
        MicroParser.id_return id30 = null;

        MicroParser.id_return id32 = null;


        CommonTree char_literal31_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // Micro.g:82:5: ( id ( ',' id )* -> ^( ID_LIST ( id )+ ) )
            // Micro.g:82:7: id ( ',' id )*
            {
            pushFollow(FOLLOW_id_in_id_list506);
            id30=id();

            state._fsp--;

            stream_id.add(id30.getTree());
            // Micro.g:82:10: ( ',' id )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==COMMA) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Micro.g:82:12: ',' id
            	    {
            	    char_literal31=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list510);  
            	    stream_COMMA.add(char_literal31);

            	    pushFollow(FOLLOW_id_in_id_list512);
            	    id32=id();

            	    state._fsp--;

            	    stream_id.add(id32.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);



            // AST REWRITE
            // elements: id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 82:23: -> ^( ID_LIST ( id )+ )
            {
                // Micro.g:82:26: ^( ID_LIST ( id )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ID_LIST, "ID_LIST"), root_1);

                if ( !(stream_id.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_id.hasNext() ) {
                    adaptor.addChild(root_1, stream_id.nextTree());

                }
                stream_id.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "id_list"

    public static class param_decl_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "param_decl_list"
    // Micro.g:87:1: param_decl_list : param_decl ( COMMA param_decl )* -> ^( PARAM_DECL_LIST ( param_decl )* ) ;
    public final MicroParser.param_decl_list_return param_decl_list() throws RecognitionException {
        MicroParser.param_decl_list_return retval = new MicroParser.param_decl_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA34=null;
        MicroParser.param_decl_return param_decl33 = null;

        MicroParser.param_decl_return param_decl35 = null;


        CommonTree COMMA34_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_param_decl=new RewriteRuleSubtreeStream(adaptor,"rule param_decl");
        try {
            // Micro.g:87:17: ( param_decl ( COMMA param_decl )* -> ^( PARAM_DECL_LIST ( param_decl )* ) )
            // Micro.g:87:19: param_decl ( COMMA param_decl )*
            {
            pushFollow(FOLLOW_param_decl_in_param_decl_list541);
            param_decl33=param_decl();

            state._fsp--;

            stream_param_decl.add(param_decl33.getTree());
            // Micro.g:87:30: ( COMMA param_decl )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Micro.g:87:31: COMMA param_decl
            	    {
            	    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_decl_list544);  
            	    stream_COMMA.add(COMMA34);

            	    pushFollow(FOLLOW_param_decl_in_param_decl_list546);
            	    param_decl35=param_decl();

            	    state._fsp--;

            	    stream_param_decl.add(param_decl35.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);



            // AST REWRITE
            // elements: param_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 87:50: -> ^( PARAM_DECL_LIST ( param_decl )* )
            {
                // Micro.g:87:53: ^( PARAM_DECL_LIST ( param_decl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM_DECL_LIST, "PARAM_DECL_LIST"), root_1);

                // Micro.g:87:71: ( param_decl )*
                while ( stream_param_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_param_decl.nextTree());

                }
                stream_param_decl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "param_decl_list"

    public static class param_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "param_decl"
    // Micro.g:89:1: param_decl : var_type id ;
    public final MicroParser.param_decl_return param_decl() throws RecognitionException {
        MicroParser.param_decl_return retval = new MicroParser.param_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.var_type_return var_type36 = null;

        MicroParser.id_return id37 = null;



        try {
            // Micro.g:89:17: ( var_type id )
            // Micro.g:89:19: var_type id
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_var_type_in_param_decl571);
            var_type36=var_type();

            state._fsp--;

            adaptor.addChild(root_0, var_type36.getTree());
            pushFollow(FOLLOW_id_in_param_decl573);
            id37=id();

            state._fsp--;

            adaptor.addChild(root_0, id37.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "param_decl"

    public static class func_declarations_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "func_declarations"
    // Micro.g:107:1: func_declarations : ( func_decl )* -> ^( FUNC_DECL_LIST ( func_decl )* ) ;
    public final MicroParser.func_declarations_return func_declarations() throws RecognitionException {
        MicroParser.func_declarations_return retval = new MicroParser.func_declarations_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.func_decl_return func_decl38 = null;


        RewriteRuleSubtreeStream stream_func_decl=new RewriteRuleSubtreeStream(adaptor,"rule func_decl");
        try {
            // Micro.g:107:19: ( ( func_decl )* -> ^( FUNC_DECL_LIST ( func_decl )* ) )
            // Micro.g:107:21: ( func_decl )*
            {
            // Micro.g:107:21: ( func_decl )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==FUNCTION) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Micro.g:107:21: func_decl
            	    {
            	    pushFollow(FOLLOW_func_decl_in_func_declarations625);
            	    func_decl38=func_decl();

            	    state._fsp--;

            	    stream_func_decl.add(func_decl38.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);



            // AST REWRITE
            // elements: func_decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 107:32: -> ^( FUNC_DECL_LIST ( func_decl )* )
            {
                // Micro.g:107:35: ^( FUNC_DECL_LIST ( func_decl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_DECL_LIST, "FUNC_DECL_LIST"), root_1);

                // Micro.g:107:52: ( func_decl )*
                while ( stream_func_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_func_decl.nextTree());

                }
                stream_func_decl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "func_declarations"

    public static class func_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "func_decl"
    // Micro.g:109:1: func_decl : FUNCTION any_type id '(' ( param_decl_list )? ')' BEGIN func_body END ;
    public final MicroParser.func_decl_return func_decl() throws RecognitionException {
        MicroParser.func_decl_return retval = new MicroParser.func_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNCTION39=null;
        Token char_literal42=null;
        Token char_literal44=null;
        Token BEGIN45=null;
        Token END47=null;
        MicroParser.any_type_return any_type40 = null;

        MicroParser.id_return id41 = null;

        MicroParser.param_decl_list_return param_decl_list43 = null;

        MicroParser.func_body_return func_body46 = null;


        CommonTree FUNCTION39_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree char_literal44_tree=null;
        CommonTree BEGIN45_tree=null;
        CommonTree END47_tree=null;

        try {
            // Micro.g:109:17: ( FUNCTION any_type id '(' ( param_decl_list )? ')' BEGIN func_body END )
            // Micro.g:109:19: FUNCTION any_type id '(' ( param_decl_list )? ')' BEGIN func_body END
            {
            root_0 = (CommonTree)adaptor.nil();

            FUNCTION39=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_func_decl650); 
            FUNCTION39_tree = (CommonTree)adaptor.create(FUNCTION39);
            root_0 = (CommonTree)adaptor.becomeRoot(FUNCTION39_tree, root_0);

            pushFollow(FOLLOW_any_type_in_func_decl653);
            any_type40=any_type();

            state._fsp--;

            adaptor.addChild(root_0, any_type40.getTree());
            pushFollow(FOLLOW_id_in_func_decl655);
            id41=id();

            state._fsp--;

            adaptor.addChild(root_0, id41.getTree());
            char_literal42=(Token)match(input,LP,FOLLOW_LP_in_func_decl680); 
            // Micro.g:115:8: ( param_decl_list )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=FLOAT && LA10_0<=INT)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Micro.g:115:8: param_decl_list
                    {
                    pushFollow(FOLLOW_param_decl_list_in_func_decl683);
                    param_decl_list43=param_decl_list();

                    state._fsp--;

                    adaptor.addChild(root_0, param_decl_list43.getTree());

                    }
                    break;

            }

            char_literal44=(Token)match(input,RP,FOLLOW_RP_in_func_decl686); 
            BEGIN45=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_func_decl689); 
            pushFollow(FOLLOW_func_body_in_func_decl692);
            func_body46=func_body();

            state._fsp--;

            adaptor.addChild(root_0, func_body46.getTree());
            END47=(Token)match(input,END,FOLLOW_END_in_func_decl694); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "func_decl"

    public static class func_body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "func_body"
    // Micro.g:119:1: func_body : decl stmt_list -> ^( FUNC_BODY decl stmt_list ) ;
    public final MicroParser.func_body_return func_body() throws RecognitionException {
        MicroParser.func_body_return retval = new MicroParser.func_body_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.decl_return decl48 = null;

        MicroParser.stmt_list_return stmt_list49 = null;


        RewriteRuleSubtreeStream stream_stmt_list=new RewriteRuleSubtreeStream(adaptor,"rule stmt_list");
        RewriteRuleSubtreeStream stream_decl=new RewriteRuleSubtreeStream(adaptor,"rule decl");
        try {
            // Micro.g:119:17: ( decl stmt_list -> ^( FUNC_BODY decl stmt_list ) )
            // Micro.g:119:19: decl stmt_list
            {
            pushFollow(FOLLOW_decl_in_func_body715);
            decl48=decl();

            state._fsp--;

            stream_decl.add(decl48.getTree());
            pushFollow(FOLLOW_stmt_list_in_func_body717);
            stmt_list49=stmt_list();

            state._fsp--;

            stream_stmt_list.add(stmt_list49.getTree());


            // AST REWRITE
            // elements: stmt_list, decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 119:34: -> ^( FUNC_BODY decl stmt_list )
            {
                // Micro.g:119:37: ^( FUNC_BODY decl stmt_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNC_BODY, "FUNC_BODY"), root_1);

                adaptor.addChild(root_1, stream_decl.nextTree());
                adaptor.addChild(root_1, stream_stmt_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "func_body"

    public static class stmt_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stmt_list"
    // Micro.g:122:1: stmt_list : ( stmt )* -> ^( STMT_LIST ( stmt )* ) ;
    public final MicroParser.stmt_list_return stmt_list() throws RecognitionException {
        MicroParser.stmt_list_return retval = new MicroParser.stmt_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.stmt_return stmt50 = null;


        RewriteRuleSubtreeStream stream_stmt=new RewriteRuleSubtreeStream(adaptor,"rule stmt");
        try {
            // Micro.g:122:17: ( ( stmt )* -> ^( STMT_LIST ( stmt )* ) )
            // Micro.g:122:19: ( stmt )*
            {
            // Micro.g:122:19: ( stmt )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==IDENTIFIER||LA11_0==READ||(LA11_0>=WRITE && LA11_0<=RETURN)||LA11_0==IF||LA11_0==DO||(LA11_0>=BREAK && LA11_0<=CONTINUE)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Micro.g:122:19: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_stmt_list744);
            	    stmt50=stmt();

            	    state._fsp--;

            	    stream_stmt.add(stmt50.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);



            // AST REWRITE
            // elements: stmt
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 122:25: -> ^( STMT_LIST ( stmt )* )
            {
                // Micro.g:122:28: ^( STMT_LIST ( stmt )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STMT_LIST, "STMT_LIST"), root_1);

                // Micro.g:122:40: ( stmt )*
                while ( stream_stmt.hasNext() ) {
                    adaptor.addChild(root_1, stream_stmt.nextTree());

                }
                stream_stmt.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stmt_list"

    public static class stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stmt"
    // Micro.g:125:1: stmt : ( assign_stmt | read_stmt | write_stmt | if_stmt | do_while_stmt | continue_stmt | break_stmt | return_stmt );
    public final MicroParser.stmt_return stmt() throws RecognitionException {
        MicroParser.stmt_return retval = new MicroParser.stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.assign_stmt_return assign_stmt51 = null;

        MicroParser.read_stmt_return read_stmt52 = null;

        MicroParser.write_stmt_return write_stmt53 = null;

        MicroParser.if_stmt_return if_stmt54 = null;

        MicroParser.do_while_stmt_return do_while_stmt55 = null;

        MicroParser.continue_stmt_return continue_stmt56 = null;

        MicroParser.break_stmt_return break_stmt57 = null;

        MicroParser.return_stmt_return return_stmt58 = null;



        try {
            // Micro.g:125:7: ( assign_stmt | read_stmt | write_stmt | if_stmt | do_while_stmt | continue_stmt | break_stmt | return_stmt )
            int alt12=8;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt12=1;
                }
                break;
            case READ:
                {
                alt12=2;
                }
                break;
            case WRITE:
                {
                alt12=3;
                }
                break;
            case IF:
                {
                alt12=4;
                }
                break;
            case DO:
                {
                alt12=5;
                }
                break;
            case CONTINUE:
                {
                alt12=6;
                }
                break;
            case BREAK:
                {
                alt12=7;
                }
                break;
            case RETURN:
                {
                alt12=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // Micro.g:125:9: assign_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assign_stmt_in_stmt768);
                    assign_stmt51=assign_stmt();

                    state._fsp--;

                    adaptor.addChild(root_0, assign_stmt51.getTree());

                    }
                    break;
                case 2 :
                    // Micro.g:126:19: read_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_read_stmt_in_stmt788);
                    read_stmt52=read_stmt();

                    state._fsp--;

                    adaptor.addChild(root_0, read_stmt52.getTree());

                    }
                    break;
                case 3 :
                    // Micro.g:127:19: write_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_write_stmt_in_stmt808);
                    write_stmt53=write_stmt();

                    state._fsp--;

                    adaptor.addChild(root_0, write_stmt53.getTree());

                    }
                    break;
                case 4 :
                    // Micro.g:128:19: if_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_stmt_in_stmt828);
                    if_stmt54=if_stmt();

                    state._fsp--;

                    adaptor.addChild(root_0, if_stmt54.getTree());

                    }
                    break;
                case 5 :
                    // Micro.g:130:19: do_while_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_do_while_stmt_in_stmt865);
                    do_while_stmt55=do_while_stmt();

                    state._fsp--;

                    adaptor.addChild(root_0, do_while_stmt55.getTree());

                    }
                    break;
                case 6 :
                    // Micro.g:131:19: continue_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_continue_stmt_in_stmt885);
                    continue_stmt56=continue_stmt();

                    state._fsp--;

                    adaptor.addChild(root_0, continue_stmt56.getTree());

                    }
                    break;
                case 7 :
                    // Micro.g:132:19: break_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_break_stmt_in_stmt905);
                    break_stmt57=break_stmt();

                    state._fsp--;

                    adaptor.addChild(root_0, break_stmt57.getTree());

                    }
                    break;
                case 8 :
                    // Micro.g:133:19: return_stmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_return_stmt_in_stmt925);
                    return_stmt58=return_stmt();

                    state._fsp--;

                    adaptor.addChild(root_0, return_stmt58.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stmt"

    public static class assign_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assign_stmt"
    // Micro.g:137:1: assign_stmt : assign_expr SEMICOLON ;
    public final MicroParser.assign_stmt_return assign_stmt() throws RecognitionException {
        MicroParser.assign_stmt_return retval = new MicroParser.assign_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMICOLON60=null;
        MicroParser.assign_expr_return assign_expr59 = null;


        CommonTree SEMICOLON60_tree=null;

        try {
            // Micro.g:137:17: ( assign_expr SEMICOLON )
            // Micro.g:137:19: assign_expr SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_assign_expr_in_assign_stmt942);
            assign_expr59=assign_expr();

            state._fsp--;

            adaptor.addChild(root_0, assign_expr59.getTree());
            SEMICOLON60=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_assign_stmt944); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assign_stmt"

    public static class assign_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assign_expr"
    // Micro.g:139:1: assign_expr : id ASSIGN expr ;
    public final MicroParser.assign_expr_return assign_expr() throws RecognitionException {
        MicroParser.assign_expr_return retval = new MicroParser.assign_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ASSIGN62=null;
        MicroParser.id_return id61 = null;

        MicroParser.expr_return expr63 = null;


        CommonTree ASSIGN62_tree=null;

        try {
            // Micro.g:139:17: ( id ASSIGN expr )
            // Micro.g:139:19: id ASSIGN expr
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_id_in_assign_expr959);
            id61=id();

            state._fsp--;

            adaptor.addChild(root_0, id61.getTree());
            ASSIGN62=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_expr961); 
            ASSIGN62_tree = (CommonTree)adaptor.create(ASSIGN62);
            root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN62_tree, root_0);

            pushFollow(FOLLOW_expr_in_assign_expr964);
            expr63=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr63.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assign_expr"

    public static class read_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "read_stmt"
    // Micro.g:141:1: read_stmt : READ LP id_list RP SEMICOLON -> ^( READ id_list ) ;
    public final MicroParser.read_stmt_return read_stmt() throws RecognitionException {
        MicroParser.read_stmt_return retval = new MicroParser.read_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token READ64=null;
        Token LP65=null;
        Token RP67=null;
        Token SEMICOLON68=null;
        MicroParser.id_list_return id_list66 = null;


        CommonTree READ64_tree=null;
        CommonTree LP65_tree=null;
        CommonTree RP67_tree=null;
        CommonTree SEMICOLON68_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_READ=new RewriteRuleTokenStream(adaptor,"token READ");
        RewriteRuleTokenStream stream_RP=new RewriteRuleTokenStream(adaptor,"token RP");
        RewriteRuleTokenStream stream_LP=new RewriteRuleTokenStream(adaptor,"token LP");
        RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");
        try {
            // Micro.g:141:17: ( READ LP id_list RP SEMICOLON -> ^( READ id_list ) )
            // Micro.g:141:19: READ LP id_list RP SEMICOLON
            {
            READ64=(Token)match(input,READ,FOLLOW_READ_in_read_stmt979);  
            stream_READ.add(READ64);

            LP65=(Token)match(input,LP,FOLLOW_LP_in_read_stmt981);  
            stream_LP.add(LP65);

            pushFollow(FOLLOW_id_list_in_read_stmt983);
            id_list66=id_list();

            state._fsp--;

            stream_id_list.add(id_list66.getTree());
            RP67=(Token)match(input,RP,FOLLOW_RP_in_read_stmt985);  
            stream_RP.add(RP67);

            SEMICOLON68=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_read_stmt987);  
            stream_SEMICOLON.add(SEMICOLON68);



            // AST REWRITE
            // elements: READ, id_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 141:48: -> ^( READ id_list )
            {
                // Micro.g:141:51: ^( READ id_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_READ.nextNode(), root_1);

                adaptor.addChild(root_1, stream_id_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "read_stmt"

    public static class write_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "write_stmt"
    // Micro.g:143:1: write_stmt : WRITE LP id_list RP SEMICOLON -> ^( WRITE id_list ) ;
    public final MicroParser.write_stmt_return write_stmt() throws RecognitionException {
        MicroParser.write_stmt_return retval = new MicroParser.write_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WRITE69=null;
        Token LP70=null;
        Token RP72=null;
        Token SEMICOLON73=null;
        MicroParser.id_list_return id_list71 = null;


        CommonTree WRITE69_tree=null;
        CommonTree LP70_tree=null;
        CommonTree RP72_tree=null;
        CommonTree SEMICOLON73_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_RP=new RewriteRuleTokenStream(adaptor,"token RP");
        RewriteRuleTokenStream stream_WRITE=new RewriteRuleTokenStream(adaptor,"token WRITE");
        RewriteRuleTokenStream stream_LP=new RewriteRuleTokenStream(adaptor,"token LP");
        RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");
        try {
            // Micro.g:143:17: ( WRITE LP id_list RP SEMICOLON -> ^( WRITE id_list ) )
            // Micro.g:143:19: WRITE LP id_list RP SEMICOLON
            {
            WRITE69=(Token)match(input,WRITE,FOLLOW_WRITE_in_write_stmt1010);  
            stream_WRITE.add(WRITE69);

            LP70=(Token)match(input,LP,FOLLOW_LP_in_write_stmt1012);  
            stream_LP.add(LP70);

            pushFollow(FOLLOW_id_list_in_write_stmt1014);
            id_list71=id_list();

            state._fsp--;

            stream_id_list.add(id_list71.getTree());
            RP72=(Token)match(input,RP,FOLLOW_RP_in_write_stmt1016);  
            stream_RP.add(RP72);

            SEMICOLON73=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_write_stmt1018);  
            stream_SEMICOLON.add(SEMICOLON73);



            // AST REWRITE
            // elements: WRITE, id_list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 143:49: -> ^( WRITE id_list )
            {
                // Micro.g:143:52: ^( WRITE id_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_WRITE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_id_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "write_stmt"

    public static class return_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "return_stmt"
    // Micro.g:145:1: return_stmt : RETURN expr SEMICOLON -> ^( RETURN expr ) ;
    public final MicroParser.return_stmt_return return_stmt() throws RecognitionException {
        MicroParser.return_stmt_return retval = new MicroParser.return_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token RETURN74=null;
        Token SEMICOLON76=null;
        MicroParser.expr_return expr75 = null;


        CommonTree RETURN74_tree=null;
        CommonTree SEMICOLON76_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // Micro.g:145:17: ( RETURN expr SEMICOLON -> ^( RETURN expr ) )
            // Micro.g:145:19: RETURN expr SEMICOLON
            {
            RETURN74=(Token)match(input,RETURN,FOLLOW_RETURN_in_return_stmt1040);  
            stream_RETURN.add(RETURN74);

            pushFollow(FOLLOW_expr_in_return_stmt1042);
            expr75=expr();

            state._fsp--;

            stream_expr.add(expr75.getTree());
            SEMICOLON76=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_return_stmt1044);  
            stream_SEMICOLON.add(SEMICOLON76);



            // AST REWRITE
            // elements: RETURN, expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 145:41: -> ^( RETURN expr )
            {
                // Micro.g:145:44: ^( RETURN expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_RETURN.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "return_stmt"

    public static class continue_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "continue_stmt"
    // Micro.g:148:1: continue_stmt : 'CONTINUE' SEMICOLON ;
    public final MicroParser.continue_stmt_return continue_stmt() throws RecognitionException {
        MicroParser.continue_stmt_return retval = new MicroParser.continue_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal77=null;
        Token SEMICOLON78=null;

        CommonTree string_literal77_tree=null;
        CommonTree SEMICOLON78_tree=null;

        try {
            // Micro.g:148:17: ( 'CONTINUE' SEMICOLON )
            // Micro.g:148:19: 'CONTINUE' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal77=(Token)match(input,CONTINUE,FOLLOW_CONTINUE_in_continue_stmt1065); 
            string_literal77_tree = (CommonTree)adaptor.create(string_literal77);
            adaptor.addChild(root_0, string_literal77_tree);

            SEMICOLON78=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_continue_stmt1067); 
            SEMICOLON78_tree = (CommonTree)adaptor.create(SEMICOLON78);
            adaptor.addChild(root_0, SEMICOLON78_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "continue_stmt"

    public static class break_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "break_stmt"
    // Micro.g:150:1: break_stmt : 'BREAK' SEMICOLON ;
    public final MicroParser.break_stmt_return break_stmt() throws RecognitionException {
        MicroParser.break_stmt_return retval = new MicroParser.break_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal79=null;
        Token SEMICOLON80=null;

        CommonTree string_literal79_tree=null;
        CommonTree SEMICOLON80_tree=null;

        try {
            // Micro.g:150:17: ( 'BREAK' SEMICOLON )
            // Micro.g:150:19: 'BREAK' SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal79=(Token)match(input,BREAK,FOLLOW_BREAK_in_break_stmt1081); 
            string_literal79_tree = (CommonTree)adaptor.create(string_literal79);
            adaptor.addChild(root_0, string_literal79_tree);

            SEMICOLON80=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_break_stmt1083); 
            SEMICOLON80_tree = (CommonTree)adaptor.create(SEMICOLON80);
            adaptor.addChild(root_0, SEMICOLON80_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "break_stmt"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // Micro.g:153:1: expr : factor ( addop factor )* ;
    public final MicroParser.expr_return expr() throws RecognitionException {
        MicroParser.expr_return retval = new MicroParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.factor_return factor81 = null;

        MicroParser.addop_return addop82 = null;

        MicroParser.factor_return factor83 = null;



        try {
            // Micro.g:153:7: ( factor ( addop factor )* )
            // Micro.g:153:9: factor ( addop factor )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_factor_in_expr1095);
            factor81=factor();

            state._fsp--;

            adaptor.addChild(root_0, factor81.getTree());
            // Micro.g:153:16: ( addop factor )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=ADD && LA13_0<=SUB)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Micro.g:153:17: addop factor
            	    {
            	    pushFollow(FOLLOW_addop_in_expr1098);
            	    addop82=addop();

            	    state._fsp--;

            	    root_0 = (CommonTree)adaptor.becomeRoot(addop82.getTree(), root_0);
            	    pushFollow(FOLLOW_factor_in_expr1101);
            	    factor83=factor();

            	    state._fsp--;

            	    adaptor.addChild(root_0, factor83.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class factor_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor"
    // Micro.g:155:1: factor : postfix_expr ( mulop postfix_expr )* ;
    public final MicroParser.factor_return factor() throws RecognitionException {
        MicroParser.factor_return retval = new MicroParser.factor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.postfix_expr_return postfix_expr84 = null;

        MicroParser.mulop_return mulop85 = null;

        MicroParser.postfix_expr_return postfix_expr86 = null;



        try {
            // Micro.g:155:9: ( postfix_expr ( mulop postfix_expr )* )
            // Micro.g:155:11: postfix_expr ( mulop postfix_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_postfix_expr_in_factor1114);
            postfix_expr84=postfix_expr();

            state._fsp--;

            adaptor.addChild(root_0, postfix_expr84.getTree());
            // Micro.g:155:24: ( mulop postfix_expr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=MULT && LA14_0<=DIV)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Micro.g:155:26: mulop postfix_expr
            	    {
            	    pushFollow(FOLLOW_mulop_in_factor1118);
            	    mulop85=mulop();

            	    state._fsp--;

            	    root_0 = (CommonTree)adaptor.becomeRoot(mulop85.getTree(), root_0);
            	    pushFollow(FOLLOW_postfix_expr_in_factor1121);
            	    postfix_expr86=postfix_expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, postfix_expr86.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "factor"

    public static class postfix_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfix_expr"
    // Micro.g:157:1: postfix_expr : ( primary | call_expr );
    public final MicroParser.postfix_expr_return postfix_expr() throws RecognitionException {
        MicroParser.postfix_expr_return retval = new MicroParser.postfix_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        MicroParser.primary_return primary87 = null;

        MicroParser.call_expr_return call_expr88 = null;



        try {
            // Micro.g:157:14: ( primary | call_expr )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LP||(LA15_0>=INTLITERAL && LA15_0<=FLOATLITERAL)) ) {
                alt15=1;
            }
            else if ( (LA15_0==IDENTIFIER) ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==SEMICOLON||LA15_2==COMMA||LA15_2==RP||(LA15_2>=ADD && LA15_2<=DIV)||(LA15_2>=L && LA15_2<=NE)) ) {
                    alt15=1;
                }
                else if ( (LA15_2==LP) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // Micro.g:157:16: primary
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_primary_in_postfix_expr1134);
                    primary87=primary();

                    state._fsp--;

                    adaptor.addChild(root_0, primary87.getTree());

                    }
                    break;
                case 2 :
                    // Micro.g:157:26: call_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_call_expr_in_postfix_expr1138);
                    call_expr88=call_expr();

                    state._fsp--;

                    adaptor.addChild(root_0, call_expr88.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "postfix_expr"

    public static class call_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "call_expr"
    // Micro.g:159:1: call_expr : id LP ( expr_list )? RP -> ^( CALL_EXPR id expr_list ) ;
    public final MicroParser.call_expr_return call_expr() throws RecognitionException {
        MicroParser.call_expr_return retval = new MicroParser.call_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LP90=null;
        Token RP92=null;
        MicroParser.id_return id89 = null;

        MicroParser.expr_list_return expr_list91 = null;


        CommonTree LP90_tree=null;
        CommonTree RP92_tree=null;
        RewriteRuleTokenStream stream_RP=new RewriteRuleTokenStream(adaptor,"token RP");
        RewriteRuleTokenStream stream_LP=new RewriteRuleTokenStream(adaptor,"token LP");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
        try {
            // Micro.g:159:11: ( id LP ( expr_list )? RP -> ^( CALL_EXPR id expr_list ) )
            // Micro.g:159:13: id LP ( expr_list )? RP
            {
            pushFollow(FOLLOW_id_in_call_expr1148);
            id89=id();

            state._fsp--;

            stream_id.add(id89.getTree());
            LP90=(Token)match(input,LP,FOLLOW_LP_in_call_expr1150);  
            stream_LP.add(LP90);

            // Micro.g:159:19: ( expr_list )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENTIFIER||LA16_0==LP||(LA16_0>=INTLITERAL && LA16_0<=FLOATLITERAL)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Micro.g:159:19: expr_list
                    {
                    pushFollow(FOLLOW_expr_list_in_call_expr1152);
                    expr_list91=expr_list();

                    state._fsp--;

                    stream_expr_list.add(expr_list91.getTree());

                    }
                    break;

            }

            RP92=(Token)match(input,RP,FOLLOW_RP_in_call_expr1155);  
            stream_RP.add(RP92);



            // AST REWRITE
            // elements: expr_list, id
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 159:33: -> ^( CALL_EXPR id expr_list )
            {
                // Micro.g:159:36: ^( CALL_EXPR id expr_list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL_EXPR, "CALL_EXPR"), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());
                adaptor.addChild(root_1, stream_expr_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "call_expr"

    public static class expr_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr_list"
    // Micro.g:161:1: expr_list : expr ( ',' expr )* -> ^( EXPR_LIST ( expr )+ ) ;
    public final MicroParser.expr_list_return expr_list() throws RecognitionException {
        MicroParser.expr_list_return retval = new MicroParser.expr_list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal94=null;
        MicroParser.expr_return expr93 = null;

        MicroParser.expr_return expr95 = null;


        CommonTree char_literal94_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // Micro.g:162:5: ( expr ( ',' expr )* -> ^( EXPR_LIST ( expr )+ ) )
            // Micro.g:162:7: expr ( ',' expr )*
            {
            pushFollow(FOLLOW_expr_in_expr_list1179);
            expr93=expr();

            state._fsp--;

            stream_expr.add(expr93.getTree());
            // Micro.g:162:12: ( ',' expr )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Micro.g:162:14: ',' expr
            	    {
            	    char_literal94=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list1183);  
            	    stream_COMMA.add(char_literal94);

            	    pushFollow(FOLLOW_expr_in_expr_list1185);
            	    expr95=expr();

            	    state._fsp--;

            	    stream_expr.add(expr95.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 162:26: -> ^( EXPR_LIST ( expr )+ )
            {
                // Micro.g:162:29: ^( EXPR_LIST ( expr )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR_LIST, "EXPR_LIST"), root_1);

                if ( !(stream_expr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_expr.nextTree());

                }
                stream_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr_list"

    public static class primary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primary"
    // Micro.g:164:1: primary : ( LP expr RP | id | INTLITERAL | FLOATLITERAL );
    public final MicroParser.primary_return primary() throws RecognitionException {
        MicroParser.primary_return retval = new MicroParser.primary_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LP96=null;
        Token RP98=null;
        Token INTLITERAL100=null;
        Token FLOATLITERAL101=null;
        MicroParser.expr_return expr97 = null;

        MicroParser.id_return id99 = null;


        CommonTree LP96_tree=null;
        CommonTree RP98_tree=null;
        CommonTree INTLITERAL100_tree=null;
        CommonTree FLOATLITERAL101_tree=null;

        try {
            // Micro.g:164:10: ( LP expr RP | id | INTLITERAL | FLOATLITERAL )
            int alt18=4;
            switch ( input.LA(1) ) {
            case LP:
                {
                alt18=1;
                }
                break;
            case IDENTIFIER:
                {
                alt18=2;
                }
                break;
            case INTLITERAL:
                {
                alt18=3;
                }
                break;
            case FLOATLITERAL:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // Micro.g:164:12: LP expr RP
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LP96=(Token)match(input,LP,FOLLOW_LP_in_primary1208); 
                    pushFollow(FOLLOW_expr_in_primary1211);
                    expr97=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr97.getTree());
                    RP98=(Token)match(input,RP,FOLLOW_RP_in_primary1213); 

                    }
                    break;
                case 2 :
                    // Micro.g:164:27: id
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_id_in_primary1218);
                    id99=id();

                    state._fsp--;

                    adaptor.addChild(root_0, id99.getTree());

                    }
                    break;
                case 3 :
                    // Micro.g:164:32: INTLITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    INTLITERAL100=(Token)match(input,INTLITERAL,FOLLOW_INTLITERAL_in_primary1222); 
                    INTLITERAL100_tree = (CommonTree)adaptor.create(INTLITERAL100);
                    adaptor.addChild(root_0, INTLITERAL100_tree);


                    }
                    break;
                case 4 :
                    // Micro.g:164:45: FLOATLITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FLOATLITERAL101=(Token)match(input,FLOATLITERAL,FOLLOW_FLOATLITERAL_in_primary1226); 
                    FLOATLITERAL101_tree = (CommonTree)adaptor.create(FLOATLITERAL101);
                    adaptor.addChild(root_0, FLOATLITERAL101_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primary"

    public static class addop_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addop"
    // Micro.g:166:1: addop : ( ADD | SUB );
    public final MicroParser.addop_return addop() throws RecognitionException {
        MicroParser.addop_return retval = new MicroParser.addop_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set102=null;

        CommonTree set102_tree=null;

        try {
            // Micro.g:166:8: ( ADD | SUB )
            // Micro.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set102=(Token)input.LT(1);
            if ( (input.LA(1)>=ADD && input.LA(1)<=SUB) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set102));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addop"

    public static class mulop_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mulop"
    // Micro.g:168:1: mulop : ( MULT | DIV );
    public final MicroParser.mulop_return mulop() throws RecognitionException {
        MicroParser.mulop_return retval = new MicroParser.mulop_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set103=null;

        CommonTree set103_tree=null;

        try {
            // Micro.g:168:8: ( MULT | DIV )
            // Micro.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set103=(Token)input.LT(1);
            if ( (input.LA(1)>=MULT && input.LA(1)<=DIV) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set103));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mulop"

    public static class if_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_stmt"
    // Micro.g:172:1: if_stmt : IF LP cond RP stmt_list ( else_part )? ENDIF ;
    public final MicroParser.if_stmt_return if_stmt() throws RecognitionException {
        MicroParser.if_stmt_return retval = new MicroParser.if_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF104=null;
        Token LP105=null;
        Token RP107=null;
        Token ENDIF110=null;
        MicroParser.cond_return cond106 = null;

        MicroParser.stmt_list_return stmt_list108 = null;

        MicroParser.else_part_return else_part109 = null;


        CommonTree IF104_tree=null;
        CommonTree LP105_tree=null;
        CommonTree RP107_tree=null;
        CommonTree ENDIF110_tree=null;

        try {
            // Micro.g:173:5: ( IF LP cond RP stmt_list ( else_part )? ENDIF )
            // Micro.g:173:7: IF LP cond RP stmt_list ( else_part )? ENDIF
            {
            root_0 = (CommonTree)adaptor.nil();

            IF104=(Token)match(input,IF,FOLLOW_IF_in_if_stmt1273); 
            IF104_tree = (CommonTree)adaptor.create(IF104);
            root_0 = (CommonTree)adaptor.becomeRoot(IF104_tree, root_0);

            LP105=(Token)match(input,LP,FOLLOW_LP_in_if_stmt1276); 
            pushFollow(FOLLOW_cond_in_if_stmt1279);
            cond106=cond();

            state._fsp--;

            adaptor.addChild(root_0, cond106.getTree());
            RP107=(Token)match(input,RP,FOLLOW_RP_in_if_stmt1281); 
            pushFollow(FOLLOW_stmt_list_in_if_stmt1284);
            stmt_list108=stmt_list();

            state._fsp--;

            adaptor.addChild(root_0, stmt_list108.getTree());
            // Micro.g:173:34: ( else_part )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ELSIF) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Micro.g:173:34: else_part
                    {
                    pushFollow(FOLLOW_else_part_in_if_stmt1286);
                    else_part109=else_part();

                    state._fsp--;

                    adaptor.addChild(root_0, else_part109.getTree());

                    }
                    break;

            }

            ENDIF110=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_if_stmt1289); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_stmt"

    public static class else_part_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "else_part"
    // Micro.g:175:1: else_part : ELSIF LP cond RP stmt_list ( else_part )? ;
    public final MicroParser.else_part_return else_part() throws RecognitionException {
        MicroParser.else_part_return retval = new MicroParser.else_part_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSIF111=null;
        Token LP112=null;
        Token RP114=null;
        MicroParser.cond_return cond113 = null;

        MicroParser.stmt_list_return stmt_list115 = null;

        MicroParser.else_part_return else_part116 = null;


        CommonTree ELSIF111_tree=null;
        CommonTree LP112_tree=null;
        CommonTree RP114_tree=null;

        try {
            // Micro.g:176:5: ( ELSIF LP cond RP stmt_list ( else_part )? )
            // Micro.g:176:7: ELSIF LP cond RP stmt_list ( else_part )?
            {
            root_0 = (CommonTree)adaptor.nil();

            ELSIF111=(Token)match(input,ELSIF,FOLLOW_ELSIF_in_else_part1306); 
            ELSIF111_tree = (CommonTree)adaptor.create(ELSIF111);
            root_0 = (CommonTree)adaptor.becomeRoot(ELSIF111_tree, root_0);

            LP112=(Token)match(input,LP,FOLLOW_LP_in_else_part1309); 
            pushFollow(FOLLOW_cond_in_else_part1312);
            cond113=cond();

            state._fsp--;

            adaptor.addChild(root_0, cond113.getTree());
            RP114=(Token)match(input,RP,FOLLOW_RP_in_else_part1314); 
            pushFollow(FOLLOW_stmt_list_in_else_part1317);
            stmt_list115=stmt_list();

            state._fsp--;

            adaptor.addChild(root_0, stmt_list115.getTree());
            // Micro.g:176:37: ( else_part )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==ELSIF) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // Micro.g:176:37: else_part
                    {
                    pushFollow(FOLLOW_else_part_in_else_part1319);
                    else_part116=else_part();

                    state._fsp--;

                    adaptor.addChild(root_0, else_part116.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "else_part"

    public static class cond_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cond"
    // Micro.g:179:1: cond : ( expr compop expr | TRUE | FALSE );
    public final MicroParser.cond_return cond() throws RecognitionException {
        MicroParser.cond_return retval = new MicroParser.cond_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TRUE120=null;
        Token FALSE121=null;
        MicroParser.expr_return expr117 = null;

        MicroParser.compop_return compop118 = null;

        MicroParser.expr_return expr119 = null;


        CommonTree TRUE120_tree=null;
        CommonTree FALSE121_tree=null;

        try {
            // Micro.g:179:11: ( expr compop expr | TRUE | FALSE )
            int alt21=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
            case LP:
            case INTLITERAL:
            case FLOATLITERAL:
                {
                alt21=1;
                }
                break;
            case TRUE:
                {
                alt21=2;
                }
                break;
            case FALSE:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // Micro.g:179:13: expr compop expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_cond1338);
                    expr117=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr117.getTree());
                    pushFollow(FOLLOW_compop_in_cond1340);
                    compop118=compop();

                    state._fsp--;

                    root_0 = (CommonTree)adaptor.becomeRoot(compop118.getTree(), root_0);
                    pushFollow(FOLLOW_expr_in_cond1343);
                    expr119=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr119.getTree());

                    }
                    break;
                case 2 :
                    // Micro.g:180:15: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TRUE120=(Token)match(input,TRUE,FOLLOW_TRUE_in_cond1359); 
                    TRUE120_tree = (CommonTree)adaptor.create(TRUE120);
                    adaptor.addChild(root_0, TRUE120_tree);


                    }
                    break;
                case 3 :
                    // Micro.g:181:15: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FALSE121=(Token)match(input,FALSE,FOLLOW_FALSE_in_cond1375); 
                    FALSE121_tree = (CommonTree)adaptor.create(FALSE121);
                    adaptor.addChild(root_0, FALSE121_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cond"

    public static class compop_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compop"
    // Micro.g:183:1: compop : ( L | G | EQ | LE | GE | NE );
    public final MicroParser.compop_return compop() throws RecognitionException {
        MicroParser.compop_return retval = new MicroParser.compop_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set122=null;

        CommonTree set122_tree=null;

        try {
            // Micro.g:183:11: ( L | G | EQ | LE | GE | NE )
            // Micro.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set122=(Token)input.LT(1);
            if ( (input.LA(1)>=L && input.LA(1)<=NE) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set122));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "compop"

    public static class do_while_stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "do_while_stmt"
    // Micro.g:188:1: do_while_stmt : DO stmt_list WHILE LP ( cond ) RP SEMICOLON ;
    public final MicroParser.do_while_stmt_return do_while_stmt() throws RecognitionException {
        MicroParser.do_while_stmt_return retval = new MicroParser.do_while_stmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DO123=null;
        Token WHILE125=null;
        Token LP126=null;
        Token RP128=null;
        Token SEMICOLON129=null;
        MicroParser.stmt_list_return stmt_list124 = null;

        MicroParser.cond_return cond127 = null;


        CommonTree DO123_tree=null;
        CommonTree WHILE125_tree=null;
        CommonTree LP126_tree=null;
        CommonTree RP128_tree=null;
        CommonTree SEMICOLON129_tree=null;

        try {
            // Micro.g:188:17: ( DO stmt_list WHILE LP ( cond ) RP SEMICOLON )
            // Micro.g:195:9: DO stmt_list WHILE LP ( cond ) RP SEMICOLON
            {
            root_0 = (CommonTree)adaptor.nil();

            DO123=(Token)match(input,DO,FOLLOW_DO_in_do_while_stmt1473); 
            DO123_tree = (CommonTree)adaptor.create(DO123);
            root_0 = (CommonTree)adaptor.becomeRoot(DO123_tree, root_0);

            pushFollow(FOLLOW_stmt_list_in_do_while_stmt1476);
            stmt_list124=stmt_list();

            state._fsp--;

            adaptor.addChild(root_0, stmt_list124.getTree());
            WHILE125=(Token)match(input,WHILE,FOLLOW_WHILE_in_do_while_stmt1478); 
            LP126=(Token)match(input,LP,FOLLOW_LP_in_do_while_stmt1481); 
            // Micro.g:195:34: ( cond )
            // Micro.g:195:35: cond
            {
            pushFollow(FOLLOW_cond_in_do_while_stmt1485);
            cond127=cond();

            state._fsp--;

            adaptor.addChild(root_0, cond127.getTree());

            }

            RP128=(Token)match(input,RP,FOLLOW_RP_in_do_while_stmt1488); 
            SEMICOLON129=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_do_while_stmt1491); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "do_while_stmt"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROGRAM_in_program139 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_id_in_program142 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_BEGIN_in_program145 = new BitSet(new long[]{0x0000000009880000L});
    public static final BitSet FOLLOW_pgm_body_in_program148 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_END_in_program150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_id171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_in_pgm_body180 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_func_declarations_in_pgm_body182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_list_in_decl206 = new BitSet(new long[]{0x0000000001880002L});
    public static final BitSet FOLLOW_string_decl_list_in_decl_list230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_decl_list_in_decl_list234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_decl_in_string_decl_list246 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_STRING_in_string_decl256 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_id_in_string_decl259 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ASSIGN_in_string_decl261 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_str_in_string_decl264 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_string_decl266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGLITERAL_in_str277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_decl_in_var_decl_list289 = new BitSet(new long[]{0x0000000001880002L});
    public static final BitSet FOLLOW_var_type_in_var_decl306 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_var_id_list_in_var_decl308 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_var_decl310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_var_type0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_type_in_any_type389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_any_type409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_id_in_var_id_list433 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_var_id_list437 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_var_id_in_var_id_list440 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_id_in_var_id454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_id_list506 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_id_list510 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_id_in_id_list512 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_param_decl_in_param_decl_list541 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_param_decl_list544 = new BitSet(new long[]{0x0000000001880000L});
    public static final BitSet FOLLOW_param_decl_in_param_decl_list546 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_var_type_in_param_decl571 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_id_in_param_decl573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_decl_in_func_declarations625 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_FUNCTION_in_func_decl650 = new BitSet(new long[]{0x0000000003880000L});
    public static final BitSet FOLLOW_any_type_in_func_decl653 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_id_in_func_decl655 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LP_in_func_decl680 = new BitSet(new long[]{0x0000000041880000L});
    public static final BitSet FOLLOW_param_decl_list_in_func_decl683 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RP_in_func_decl686 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_BEGIN_in_func_decl689 = new BitSet(new long[]{0x00C40081918C0000L});
    public static final BitSet FOLLOW_func_body_in_func_decl692 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_END_in_func_decl694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_in_func_body715 = new BitSet(new long[]{0x00C4008190040000L});
    public static final BitSet FOLLOW_stmt_list_in_func_body717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stmt_in_stmt_list744 = new BitSet(new long[]{0x00C4008190040002L});
    public static final BitSet FOLLOW_assign_stmt_in_stmt768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_stmt_in_stmt788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_stmt_in_stmt808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_stmt_in_stmt828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_do_while_stmt_in_stmt865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continue_stmt_in_stmt885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_stmt_in_stmt905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_stmt_in_stmt925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_expr_in_assign_stmt942 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_assign_stmt944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_assign_expr959 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ASSIGN_in_assign_expr961 = new BitSet(new long[]{0x0000000620040000L});
    public static final BitSet FOLLOW_expr_in_assign_expr964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_read_stmt979 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LP_in_read_stmt981 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_id_list_in_read_stmt983 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RP_in_read_stmt985 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_read_stmt987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_write_stmt1010 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LP_in_write_stmt1012 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_id_list_in_write_stmt1014 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RP_in_write_stmt1016 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_write_stmt1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_return_stmt1040 = new BitSet(new long[]{0x0000000620040000L});
    public static final BitSet FOLLOW_expr_in_return_stmt1042 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_return_stmt1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_continue_stmt1065 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_continue_stmt1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_break_stmt1081 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_break_stmt1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_expr1095 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_addop_in_expr1098 = new BitSet(new long[]{0x0000000620040000L});
    public static final BitSet FOLLOW_factor_in_expr1101 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_postfix_expr_in_factor1114 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_mulop_in_factor1118 = new BitSet(new long[]{0x0000000620040000L});
    public static final BitSet FOLLOW_postfix_expr_in_factor1121 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_primary_in_postfix_expr1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_call_expr_in_postfix_expr1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_call_expr1148 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LP_in_call_expr1150 = new BitSet(new long[]{0x0000000660040000L});
    public static final BitSet FOLLOW_expr_list_in_call_expr1152 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RP_in_call_expr1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_expr_list1179 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COMMA_in_expr_list1183 = new BitSet(new long[]{0x0000000620040000L});
    public static final BitSet FOLLOW_expr_in_expr_list1185 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_LP_in_primary1208 = new BitSet(new long[]{0x0000000620040000L});
    public static final BitSet FOLLOW_expr_in_primary1211 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RP_in_primary1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_primary1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTLITERAL_in_primary1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATLITERAL_in_primary1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_addop0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_mulop0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_stmt1273 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LP_in_if_stmt1276 = new BitSet(new long[]{0x00000C0620040000L});
    public static final BitSet FOLLOW_cond_in_if_stmt1279 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RP_in_if_stmt1281 = new BitSet(new long[]{0x00C4038190040000L});
    public static final BitSet FOLLOW_stmt_list_in_if_stmt1284 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_else_part_in_if_stmt1286 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ENDIF_in_if_stmt1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSIF_in_else_part1306 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LP_in_else_part1309 = new BitSet(new long[]{0x00000C0620040000L});
    public static final BitSet FOLLOW_cond_in_else_part1312 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RP_in_else_part1314 = new BitSet(new long[]{0x00C4028190040000L});
    public static final BitSet FOLLOW_stmt_list_in_else_part1317 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_else_part_in_else_part1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cond1338 = new BitSet(new long[]{0x0003F00000000000L});
    public static final BitSet FOLLOW_compop_in_cond1340 = new BitSet(new long[]{0x0000000620040000L});
    public static final BitSet FOLLOW_expr_in_cond1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_cond1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_cond1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_compop0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_do_while_stmt1473 = new BitSet(new long[]{0x00CC008190040000L});
    public static final BitSet FOLLOW_stmt_list_in_do_while_stmt1476 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_WHILE_in_do_while_stmt1478 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LP_in_do_while_stmt1481 = new BitSet(new long[]{0x00000C0620040000L});
    public static final BitSet FOLLOW_cond_in_do_while_stmt1485 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_RP_in_do_while_stmt1488 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SEMICOLON_in_do_while_stmt1491 = new BitSet(new long[]{0x0000000000000002L});

}
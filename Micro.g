grammar Micro;

options {
  	language = Java;
  	ASTLabelType = CommonTree;
    	output = AST;
}

tokens {
    ID_LIST;
    CALL_EXPR;
    STMT_LIST;
    FUNC_DECL_LIST;
    EXPR_LIST;
    PARA_DECL_LIST;
    VAR_DECL;
}

@members {
	 Integer blockCnt = 0;
	 boolean errFlag = true;
	 SymbolTable globalTab;
	 SymbolTable curTab;
	 String output = "";
}

program [SymbolTable symTable]
    :	{
			globalTab = symTable;
            globalTab.setScopeId("global");
			curTab = globalTab;
			output += "Symbol table GLOBAL\n";
        }

		PROGRAM id BEGIN pgm_body END -> ^(PROGRAM pgm_body)
	 	;

id	        : IDENTIFIER ;

pgm_body	: decl! func_declarations
    ;

decl		: decl_list* ;

decl_list       : string_decl_list | var_decl_list ;

/* Global String Declaration */
string_decl_list  : string_decl+ ;

string_decl	: STRING id ASSIGN str SEMICOLON
		{
			SymbolObject strSymbol = new SymbolObject($id.text, "STRING", $str.text);
			if (curTab.isLegal(strSymbol)) {
				curTab.addToTab(strSymbol);
				output += strSymbol.printStr();
			} else {
				if (errFlag)
				   ;//curTab.printErr();
			}
		}
		;
str		: STRINGLITERAL ;


/* Variable Declaration */
var_decl_list	: var_decl+ ;

var_decl        : var_type var_id_list ';' -> ^(VAR_DECL var_type var_id_list) ;

var_type	: FLOAT {curTab.setVarType("FLOAT");}
                | INT   {curTab.setVarType("INT");}
                ;

any_type        : var_type
                | VOID
                ;
var_id_list	: var_id ( COMMA! var_id )*
		;
var_id		: id
		{
			SymbolObject commonSymbol = new SymbolObject($id.text,curTab.getVarType());
			if (curTab.isLegal(commonSymbol)) {
 			       curTab.addToTab(commonSymbol);
			       output += commonSymbol.print();
			} else {
				if (errFlag) {
				   errFlag = false;
				   //curTab.printErr();
				}
			}
		}
		;

id_list
    : id ( ',' id )*  -> ^(ID_LIST id+)
    ;


/* Function Paramater List */
param_decl_list : param_decl param_decl_tail
    ;

param_decl      : var_type id
		{
			SymbolObject commonSymbol = new SymbolObject($id.text,curTab.getVarType());
			if (curTab.isLegal(commonSymbol)) {
 			       curTab.addToTab(commonSymbol);
			       output += commonSymbol.print();
			} else {
				if (errFlag) {
				   errFlag = false;
				   //curTab.printErr();
				}
			}
		}
		;

param_decl_tail : ( ',' param_decl )* ;

/* Function Declarations */
func_declarations : func_decl* -> ^(FUNC_DECL_LIST func_decl*) ;

func_decl       : FUNCTION ^any_type id
		{
		      SymbolTable funcTable = new SymbolTable($id.text);
		      curTab = funcTable;
		      output += "\nSymbol table " + funcTable.getScopeId() + "\n";
        }
		'('! param_decl_list? ')'! BEGIN! func_body END!
		{curTab = globalTab;}
		;

func_body       : decl! stmt_list ;

/* Statement List */
stmt_list       : stmt* -> ^(STMT_LIST stmt*)
    ;

stmt		: assign_stmt
                | read_stmt
                | write_stmt
                | if_stmt
                //| for_stmt
                | do_while_stmt
                | continue_stmt
                | break_stmt
                | return_stmt
		;

/* Basic Statements */
assign_stmt     : assign_expr SEMICOLON!
		;
assign_expr     : id ASSIGN^ expr ;

read_stmt       : READ LP id_list RP SEMICOLON -> ^(READ id_list)
		;
write_stmt      : WRITE LP id_list RP SEMICOLON -> ^(WRITE id_list)
		;
return_stmt     : RETURN expr SEMICOLON -> ^(RETURN expr)
		;

continue_stmt   : 'CONTINUE' SEMICOLON ;

break_stmt      : 'BREAK' SEMICOLON ;

/* Expressions */
expr		: factor (addop^ factor)*
		;
factor		: postfix_expr ( mulop^ postfix_expr )*
		;
postfix_expr	: primary | call_expr
		;
call_expr	: id LP expr_list? RP -> ^(CALL_EXPR expr_list)
		;
expr_list
    : expr ( ',' expr )* -> ^(EXPR_LIST expr+)
		;
primary		: LP! expr RP! | id | INTLITERAL | FLOATLITERAL
		;
addop		: ADD | SUB
		;
mulop		: MULT | DIV
		;

/* Complex Statements and Condition */
if_stmt
    : IF^ LP! cond RP! stmt_list else_part? ENDIF!
    ;
else_part
    : ELSIF^ LP! cond RP! stmt_list else_part?
    ;

cond     	: expr compop^ expr
            | TRUE
            | FALSE
            ;
compop   	: L | G | EQ | LE | GE | NE
    ;
/*for_stmt 	: FOR^ LP! assign_expr? SEMICOLON cond? SEMICOLON assign_expr? RP! stmt_list ENDFOR!
    ;*/

do_while_stmt   :
        {
		      blockCnt += 1;
		      SymbolTable dowhileTable = new SymbolTable(blockCnt.toString());
		      curTab = dowhileTable;
		      output += "\nSymbol table BLOCK " + dowhileTable.getScopeId() + "\n" ;
        }
        DO^ stmt_list WHILE! LP! (cond) RP! SEMICOLON!
		{
            curTab = globalTab;
        }
    ;

//keywords
PROGRAM : 'PROGRAM' ;
BEGIN   : 'BEGIN'   ;
STRING  : 'STRING' ;
FUNCTION :  'FUNCTION' ;
INT     :  'INT' ;
FLOAT   :  'FLOAT' ;
IF      :  'IF' ;
ELSIF   :  'ELSIF' ;
ENDIF   :  'ENDIF' ;
END     :  'END' ;
VOID    :  'VOID' ;
DO      :  'DO' ;
WHILE   :  'WHILE' ;
FOR     :  'FOR' ;
ENDFOR  :  'ENDFOR' ;
WRITE   :  'WRITE' ;
RETURN  :  'RETURN' ;
READ    :  'READ' ;
TRUE    :  'TRUE' ;
FALSE   :  'FALSE' ;
BREAK   :  'BREAK' ;
CONTINUE:  'CONTINUE' ;
ASSIGN  :  ':=' ;
SEMICOLON : ';' ;
COMMA   : ',' ;
LP      : '(' ;
RP      : ')' ;
G       : '>' ;
L       :  '<' ;
GE      : '>=' ;
LE      : '<=' ;
EQ      :  '=' ;
NE      : '!=' ;
ADD     : '+';
SUB     : '-';
MULT    : '*';
DIV     : '/';
//variable
IDENTIFIER : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
INTLITERAL : ('0'..'9')+ ;
FLOATLITERAL: ('0'..'9')*'.'('0'..'9')+ ;
STRINGLITERAL: '"'~('"')*'"' ;

COMMENT : '--' ~'\n'* '\n' {$channel = HIDDEN;};
WS : (' '|'\r'|'\n'|'\t'|'\f')+ {$channel = HIDDEN;};

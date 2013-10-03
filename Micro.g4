grammar Micro;

@members {
	 Integer blockCnt = 0;
	 boolean errFlag = true;
	 SymbolTable globalTab;
	 SymbolTable curTab;
	 String output = "";
}

program:	{
			globalTab = new SymbolTable("global");
			curTab = globalTab;
			output += "Symbol table GLOBAL\n";
         	}
	 
		'PROGRAM' id 'BEGIN' pgm_body 'END' 
	        {
			if (errFlag)
				System.out.println(output);
		}
	 	;

id	        : IDENTIFIER ;

pgm_body	: decl func_declarations ;
		
decl		: decl_list* ;

decl_list       : string_decl_list | var_decl_list ;

/* Global String Declaration */
string_decl_list  : string_decl+ ;
		
string_decl	: 'STRING' id ':=' str ';' 
		{
			SymbolObject strSymbol = new SymbolObject($id.text, "STRING", $str.text);
			if (curTab.isLegal(strSymbol)) {
				curTab.addToTab(strSymbol);
				output += strSymbol.printStr();
			} else {
				if (errFlag)
				   curTab.printErr();
			}
		}
		; 
str		: STRINGLITERAL ;
	

/* Variable Declaration */
var_decl_list	: var_decl+ ;
	
var_decl        : var_type var_id_list ';'
		;
var_type	: 'FLOAT' {curTab.setVarType("FLOAT");} 
                | 'INT'   {curTab.setVarType("INT");} 
                ;
		
any_type        : var_type 
                | 'VOID'
		;
var_id_list	: var_id ( ',' var_id )*
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
				   curTab.printErr();
				}
			}
		}
		;
id_list		: id id_tail ;

id_tail 	: ( ',' id )* ;


/* Function Paramater List */
param_decl_list : param_decl param_decl_tail ;
		
param_decl      : var_type id
		{
			SymbolObject commonSymbol = new SymbolObject($id.text,curTab.getVarType());
			if (curTab.isLegal(commonSymbol)) {
 			       curTab.addToTab(commonSymbol); 
			       output += commonSymbol.print();
			} else {
				if (errFlag) {
				   errFlag = false;
				   curTab.printErr();
				}
			}

		}
		;
		
param_decl_tail : ( ',' param_decl )* 
		;

/* Function Declarations */
func_declarations : func_decl* ;
		
func_decl       : 'FUNCTION' any_type id 
		{
		      SymbolTable funcTable = new SymbolTable($id.text);
		      curTab = funcTable;
		      output += "\nSymbol table " + funcTable.getScopeId() + "\n";
  	        }
		'(' param_decl_list? ')' 'BEGIN' func_body 'END'
		{curTab = globalTab;} 
		;
		
func_body       : decl stmt_list ;
		
/* Statement List */
stmt_list       : stmt* ;		

stmt		: assign_stmt 
                | read_stmt 
                | write_stmt 
                | if_stmt 
                | for_stmt 
                | do_while_stmt 
                | continue_stmt 
                | break_stmt 
                | return_stmt
		;

/* Basic Statements */
assign_stmt     : assign_expr ';'
		;
assign_expr     : id ':=' expr ;
		
read_stmt       : 'READ' '(' id_list ')' ';'
		;
write_stmt      : 'WRITE' '(' id_list ')' ';'
		;
return_stmt     : 'RETURN' expr ';'
		;

continue_stmt   : 'CONTINUE' ';' ;

break_stmt      : 'BREAK' ';' ;

/* Expressions */
expr		: factor (addop factor)* 
		;
factor		: postfix_expr ( mulop postfix_expr )* 
		;
postfix_expr	: primary | call_expr 
		;
call_expr	: id '(' expr_list? ')' 
		;
expr_list         
		: expr ( ',' expr )*
		;
primary		: '(' expr ')' | id | INTLITERAL | FLOATLITERAL 
		;
addop		: '+' | '-' 
		;
mulop		: '*' | '/' 
		;

/* Complex Statements and Condition */ 
if_stmt		: 'IF' '(' cond ')'
		{
		      blockCnt += 1;
		      SymbolTable ifTable = new SymbolTable(blockCnt.toString());
		      curTab = ifTable;
		      output += "\nSymbol table BLOCK " + ifTable.getScopeId() + "\n\n";
  	        } 
		
		 stmt_list else_part 'ENDIF' 
		{curTab = globalTab;}
		;
else_part	:  ('ELSE'
		{
		      blockCnt += 1;
		      SymbolTable elseTable = new SymbolTable(blockCnt.toString());
		      curTab = elseTable;
		      output += "\nSymbol table BLOCK " + elseTable.getScopeId() + "\n\n";
  	        } 
                stmt_list)*
		{curTab = globalTab;}
                | ( 'ELSIF' '(' cond ')' 
		{
		      blockCnt += 1;
		      SymbolTable elseifTable = new SymbolTable(blockCnt.toString());
		      curTab = elseifTable;
		      output += "\nSymbol table BLOCK " + elseifTable.getScopeId() + "\n\n";
  	        } 
		stmt_list )*
		{curTab = globalTab;}
                | ( 'ELSIF' '(' (TRUE|FALSE) ')' 
		{
		      blockCnt += 1;
		      SymbolTable elseifTable = new SymbolTable(blockCnt.toString());
		      curTab = elseifTable;
		      output += "\nSymbol table BLOCK " + elseifTable.getScopeId() + "\n\n";
                }
		{curTab = globalTab;}
		stmt_list )*
		;
cond     	: expr compop expr 
		;
compop   	: '<' | '>' | '=' | '<=' | '>=' | '!='
		;
for_stmt 	: 'FOR' '(' assign_expr? ';' cond? ';' assign_expr? ')' stmt_list 'ENDFOR' 
		;

do_while_stmt   : 'DO'
		{
		      blockCnt += 1;
		      SymbolTable dowhileTable = new SymbolTable(blockCnt.toString());
		      curTab = dowhileTable;
		      output += "\nSymbol table BLOCK " + dowhileTable.getScopeId() + "\n" ;
                }		
	        (decl stmt_list)?
		'WHILE' '(' (cond|TRUE|FALSE) ')' ';' 
		{curTab = globalTab;}
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
WRITE   :  'WRITE' ;
RETURN  :  'RETURN' ;
READ    :  'READ' ;
TRUE    :  'TRUE' ;
FALSE   :  'FALSE' ;
BREAK   :  'BREAK' ;

//variable
IDENTIFIER : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
INTLITERAL : [0-9]+ ;
FLOATLITERAL: [-]*[0-9]*[.][0-9]+ ;
STRINGLITERAL : '"'~["]*'"' ;

COMMENT : '-''-'~[\n]* -> skip ;
WS : [ \t\r\n]+ -> skip ;

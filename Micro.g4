grammar Micro;

program         : 'PROGRAM' id 'BEGIN' pgm_body 'END' ;

id	        : IDENTIFIER ;

pgm_body	: decl func_declarations ;
		
decl		: decl_list* ;

decl_list       : string_decl_list | var_decl_list ;

/* Global String Declaration */
string_decl_list  : string_decl+ ;
		
string_decl	: 'STRING' id ':=' str ';' 
		; 
str		: STRINGLITERAL ;
	

/* Variable Declaration */
var_decl_list	: var_decl ;
	
var_decl        : (var_type id_list ';')+
		;
var_type	: 'FLOAT' 
                | 'INT' 
                ;
		
any_type        : var_type 
                | 'VOID'
		;
id_list		: id ( ',' id )* ;


/* Function Paramater List */
param_decl_list : param_decl param_decl_tail ;
		
param_decl      : var_type id ;
		
param_decl_tail : ( ',' param_decl )* 
		;

/* Function Declarations */
func_declarations : func_decl* ;
		
func_decl       : 'FUNCTION' any_type id '(' param_decl_list? ')' 'BEGIN' func_body 'END' ;
		
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
if_stmt		: 'IF' '(' cond ')' stmt_list else_part 'ENDIF' 
		;
else_part	: ( 'ELSE' stmt_list )? 
                | ( 'ELSIF' '(' cond ')' stmt_list )*
                | ( 'ELSIF' '(' (TRUE|FALSE) ')' stmt_list )*
		;
cond     	: expr compop expr 
		;
compop   	: '<' | '>' | '=' | '<=' | '>=' | '!='
		;
for_stmt 	: 'FOR' '(' assign_expr? ';' cond? ';' assign_expr? ')' stmt_list 'ENDFOR' 
		;

do_while_stmt   : 'DO' (stmt_list)? 'WHILE' '(' (cond|TRUE|FALSE) ')' ';' 
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

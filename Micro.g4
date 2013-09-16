grammar Micro;
a : 'a' ;

//keywords
PROGRAM : 'PROGRAM' ;
BEGIN   : 'BEGIN'   ;
STRING  : 'STRING'  ;
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
BREAK   :  'BREAK' ;

//variable
IDENTIFIER : [_A-Za-z]+[0-9]* ;
INTLITERAL : [0-9]+ ;
FLOATLITERAL: [-]*[0-9]*[.][0-9]+ ;
STRINGLITERAL : '"'~["]*'"' ;

//operator
PLUS : '+' ;
MINUS : '-';
MUL : '*' ;
DIV : '/' ;
LPAREN : '(' ;
RPAREN : ')' ;
LBRACE : '{' ;
RBRACE : '}' ;
LABRACKET : '<' ;
RABRACKET : '>' ;
COMMA : ',' ;
EXCLAMATION : '!' ;
SEMICOLON : ';' ;
EQUAL : '=' ;
DOT : '.' ;
ASSIGN : ':=' ;
NEQUAL : '!=' ;
LEQUAL : '<=' ;
GEQUAL : '>=' ;


COMMENT : '-''-'~[\n]* -> skip ;
WS : [ \t\r\n]+ -> skip ;


grammar Micro;
a : 'a' ;
KEYWORD :  'PROGRAM' 
        |  'BEGIN'
        |  'STRING'
        |  'FUNCTION'
        |  'INT'
        |  'FLOAT'
        |  'IF'
        |  'ELSIF'
        |  'ENDIF'
        |  'END'
        |  'VOID'
        |  'DO'
        |  'WHILE'
        |  'WRITE'
        |  'RETURN'
        |  'READ'
        |  'TRUE'
        |  'BREAK'
        ;
IDENTIFIER : [_A-Za-z]+[0-9]* ;
INTLITERAL : [0-9]+ ;
FLOATLITERAL: [-]*[0-9]*[.][0-9]+ ;
OPEARTOR : [\+\-\*\/\(\)\{\}\<\>\!\,\;\=\.] 
         | ':='
         | '!='
         | '<='
         ;
STRINGLITERAL : '"'~["]*'"' ;
COMMENT : '-''-'~[\n]* -> skip ;
WS : [ \t\r\n]+ -> skip ;


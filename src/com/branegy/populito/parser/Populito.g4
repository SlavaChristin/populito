grammar Populito;


@header {
   package com.branegy.populito.parser;
}

expression
  : v_list=list
  | v_field=field
  | v_constant=constant
  | v_function=function
  | v_ifthenelse=if_then_else
  | v_null=NULL
;

conditional_expression
  : conditional_or;

conditional_or
  : conditional_and (OR conditional_and)*;

conditional_and
  : term (AND term)*;

term
  : v_left=expression (v_operator=operator v_right=expression)?
  | LPAREN v_center=conditional_expression RPAREN
; 
  
if_then_else
  : IF v_codition=conditional_expression THEN v_then=expression ELSE v_else=expression END;


list
  : OPEN_SB expression (COMMA expression )* CLOSE_SB;

parameters
  : ID EQ expression (COMMA ID EQ expression)*;

    
function
  : name=ID '(' parameters? ')';

constant
  : v_number= NUMBER
  | v_string= STRING
;

field
  : DOLLAR (v_parent=ID DOT)? v_name=ID;

operator
  : GT | GE | LT | LE | EQ;

binary     : AND | OR;

IF         : 'if';
THEN       : 'then';
ELSE       : 'else';
END        : 'end';
OPEN_SB    : '[';
CLOSE_SB   : ']';
EQ         : '=';
COMMA      : ',';
DOLLAR     : '$';
DOT        : '.';
GT         : '>';
GE         : '>=';
LT         : '<';
LE         : '<=';
AND        : 'and';
OR         : 'or';
NOT        : 'not';
TRUE       : 'true';
FALSE      : 'false';
LPAREN     : '(' ;
RPAREN     : ')' ;
NULL       : 'null';

ID         : ('a'..'z' | 'A'..'Z') ('0'..'9'|'a'..'z'|'A'..'Z')*;
WS         :   (' '|'\t')+ {skip();} ;
NUMBER     : '-'? ('0'..'9')+ ('.' ('0'..'9')+ )?;

STRING     : '"' (ESC|~('"'|'\\'|'\n'|'\r'))* '"';

ESC	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		);

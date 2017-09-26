grammar Populito;


@header {
   package com.branegy.populito.parser;
}


mathExpression
  : plusOrMinus
  | expression
;

plusOrMinus
  : v_left=plusOrMinus v_operation=PLUS  v_right=multOrDiv
  | v_left=plusOrMinus v_operation=MINUS v_right=multOrDiv
  | v_right=multOrDiv
;
 
multOrDiv
  : v_left=multOrDiv v_operation=MULT v_right=pow
  | v_left=multOrDiv v_operation=DIV  v_right=pow
  | v_right=pow
;

pow
  : unaryMinus (POWER pow)?
;

unaryMinus
   : v_operation=MINUS unaryMinus
   | expression
;

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
  : IF v_codition=conditional_expression THEN v_then=mathExpression ELSE v_else=mathExpression END;


list
  : OPEN_SB mathExpression (COMMA mathExpression )* CLOSE_SB;

parameters
  : ID EQ mathExpression (COMMA ID EQ mathExpression)*;

    
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
PLUS	   : '+';
MINUS      : '-';
MULT	   : '*';
DIV 	   : '/';
POWER	   : '^';


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

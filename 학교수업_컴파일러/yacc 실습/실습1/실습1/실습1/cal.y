%{
/* YACC source for calculator program */
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
%}
%token  NAME NUMBER  DIV  MOD  SQR
%left  '+'  '-'
%left  '*'  '/'
%nonassoc UMINUS
%%
statemet: NAME '=' expression
	| expression {printf("= %d\n", $1);}
	;

expression: expression '+' expression {$$ = $1 + $3;}
		| expression '-' expression {$$ = $1 - $3;}
		| expression '*' expression {$$ = $1 * $3;}
		| expression '/' expression {
			if($3==0) yyerror ("divide by zero");
			else $$ = $1 / $3;
		}
		| '-' expression %prec UMINUS {$$ = -$2};
		| '(' expression ')' {$$ = $2;}
		| NUMBER
		;
%%
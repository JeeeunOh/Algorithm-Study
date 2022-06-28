%{
/*lex source for Mini C*/
/*½ÇÇàÀ» À§ÇØ Ãß°¡ÇÑ ºÎºÐ*/
#include "tn.h"

%}
%%
"const"		return(tconst);
"else"		return(telse);
"if"		return(tif);
"int"		return(tint);
"return"	return(treturn);
"void"		return(tvoid);
"while"		return(twhile);
"=="		return(tequal);
"!="		return(tnotequ);
"<="		return(tlesse);
">="		return(tgreate);
"&&"		return(tand);
"||"		return(tor);
"++"		return(tinc);
"--"		return(tdec);
"+="		return(taddAssign);
"-="		return(tsubAssign);
"*="		return(tmulAssign);
"/="		return(tdivAssign);
"%="		return(tmodAssign);
[A-Za-z_][A-Za-z0-9_]*		return(tident);
[1-9][0-9]*|0([0-7]+|(x|X)[0-9A-Fa-f]*)?	return(tnumber);
"/*"([^*]|\*+[^*/])*\**"*"	;
"//".*	;
[ \t\n] ;
.	return(yytext[0]);
%%

int yywrap() {
	return 1;
}
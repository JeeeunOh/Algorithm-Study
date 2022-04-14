%{
/*
 * scanner.l - lexical analyzer for the MiniC
 * programmer - 오지은, 노윤주
 * date - 20222/04/14
 */
#include <stdio.h>
#include <stdlib.h>
#include "tn.h"
#include "glob.h"
%}
A [A-Za-z_]
D [0-9]
%%
"const"							return(TCONST);
"else"							return(TELSE);
"if"							return(TIF);
"int"							return(TINT);
"return"							return(TRETURN);
"void"							return(TVOID);
"while"							return(TWHILE);
"=="							return(TEQUAL);
"!="							return(TNOTEQU);
"<="							return(TLESSE);
">="							return(TGREATE);
"&&"							return(TAND);
"||"							return(TOR);
"+"							return(TPLUS);
"-"							return(TMINUS);
"*"							return(TMUL);
"/"							return(TDIV);
"%"							return(TMOD);
"="							return(TSUBT);
"!"							return(TNOT);
"<"							return(TLESS);
">"							return(TGREAT);
"++"							return(TINC);
"--"							return(TDEC);
"+="							return(TADDASSIGN);
"-="							return(TSUBASSIGN);
"*="							return(TMULASSIGN);
"/="							return(TDIVASSIGN);
"%="							return(TMODASSIGN);
{A}({A}|{D})*						return(TIDENT);
[1-9][0-9]*						return(TNUMBER);
[0-9]+"."[0-9]+						return(TREALNUM);
("/*"{[^*]|\*+[^*/]}*\**"*/")|("//".*)				return(TCOMMENT);
[ \t\n]							return(TSPACE);
.							return(yytext[0]);
"("|")"|","|"{"|"}"|"["|"]"|";"					return(TSPECIAL);

%%
int yywrap(){ 
    printf("---------end\n");
    return 1;
}

%{
      	/* LEX source for calculator program */
%}
extern int yylval;
%%
[ \t]	; /* ignore blanks and tabs */
[0-9]+	{yylval = atoi(yytext); return NUMBER;}
"mod"	return MOD;
"div"	return DIV;
"sqr"	return SQR;
\n|.	return yytext[0];  /* return everything else */
%%
int yywrap()
{
    printf("1971027 Jieun Oh");
    return 0;
}
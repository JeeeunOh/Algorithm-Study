%{
#include <stdio.h>
#include <stdlib.h>

enum tokentypes { 
    TEOF, TCONST, TELSE, TIF, TINT, TRETURN, TVOID, TWHILE, TEQUAL, 
    TNOTEQU, TLESS, TGREAT, TAND, TOR, TINC, TDEC, 
    TADDASSIGN, TSUBASSIGN, TMULASSIGN, TDIVASSIGN, TMODASSIGN, 
    TIDENT, TNUMBER, TERROR
};
%}
%%
"const"     return(TCONST);
"else"      return(TELSE);
"if"        return(TIF);
"int"       return(TINT);
"return"    return(TRETURN);  
"void"      return(TVOID);
"while"     return(TWHILE);
"=="        return(TEQUAL);
"!="        return(TNOTEQU);
"<="        return(TLESS);
">="        return(TGREAT);
"&&"        return(TAND);
"||"        return(TOR);
"++"        return(TINC);
"--"        return(TDEC);
"+="        return(TADDASSIGN);
"-="        return(TSUBASSIGN);
"*="        return(TMULASSIGN);
"/="        return(TDIVASSIGN);
"%="        return(TMODASSIGN);
[A-Za-z_][A-Za-z0-9_]*                          return (TIDENT);
[1-9][0-9]*|0([0-7]+|(x|X)[0-9A-Fa-f]*)?        return(TNUMBER);
.                                               return (TERROR);
%%

void main(){
    enum tokentypes tt; /* token types */
    printf(" Start of Lex\n");

    while ((tt=yylex()) != TEOF){
        switch (tt){
            case TCONST         : printf("TCONST %10s ", "const"); break;
            case TELSE          : printf("TELSE %10s ", "else"); break;
            case TIF            : printf("TIF %10s ", "if"); break;
            case TINT           : printf("TINT %10s ", "int"); break;
            case TRETURN        : printf("TRETURN %10s ", "return"); break;
            case TWHILE         : printf("TWHILE %10s ", "while"); break;
            case TEQUAL         : printf("TEQUAL %10s ", "equal"); break;
            case TNOTEQU        : printf("TNOTEQU %10s ", "not equal"); break;
            case TLESS          : printf("TLESS %10s ", "less"); break;
            case TGREAT         : printf("TGREAT %10s ", "great"); break;
            case TAND           : printf("TAND %10s ", "and"); break;
            case TOR            : printf("TOR %10s ", "or"); break;
            case TINC           : printf("TINC %10s ", "increase"); break;
            case TDEC           : printf("TDEC %10s ", "decrease"); break;
            case TADDASSIGN     : printf("TADDASSIGN %10s ", "addition"); break;
            case TSUBASSIGN     : printf("TSUBASSIGN %10s ", "substraction"); break;
            case TMULASSIGN     : printf("TMULASSIGN %10s ", "multiplication"); break;
            case TDIVASSIGN     : printf("TDIVASSIGN %10s ", "division"); break;
            case TMODASSIGN     : printf("TMODASSIGN %10s ", "modification"); break;

            case TIDENT         : printf("TIDENT %10s ", "i dont know"); break;
            case TNUMBER        : printf("TNUMBER %10s ", "i dont know"); break;
            case TERROR         : printf("Error: %c\n", yytext[0]); break;
        }
    }
}

int yywrap(){ 
    printf(" ----- 1971027 Jieun Oh ----- End of Lex\n");
    return 1;
}
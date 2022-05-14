#include <stdio.h>
#include <stdlib.h>
#include "tn.h"
extern yylex();
extern char *yytext;

void main(){
    enum tnumber tn; /* token number */
    printf("---------start\n");
    while ((tn=yylex()) != TEOF){
        switch (tn){
            case TCONST		    : printf("TCONST %10s\n ", "const"); break;
            case TELSE		    : printf("TELSE %10s\n ", "else"); break;
            case TIF			: printf("TIF %10s\n ", "if"); break;
            case TINT		    : printf("TINT %10s\n ", "int"); break;
            case TRETURN		: printf("TRETURN %10s\n ", "return"); break;
            case TVOID		    : printf("TVOID %10s\n ", "void"); break;
            case TWHILE		    : printf("TWHILE %10s\n ", "while"); break;
            case TEQUAL		    : printf("TEQUAL %10s\n ", "equal"); break;
            case TNOTEQU		: printf("TNOTEQU %10s\n ", "not equal"); break;
            case TLESSE		    : printf("TLESS %10s\n ", "less"); break;
            case TGREATE		: printf("TGREAT %10s\n ", "great"); break;
            case TAND		    : printf("TAND %10s\n ", "and"); break;
            case TOR			: printf("TOR %10s\n ", "or"); break;
            case TINC		    : printf("TINC %10s\n ", "increase"); break;
            case TDEC		    : printf("TDEC %10s\n ", "decrease"); break;
            case TADDASSIGN		: printf("TADDASSIGN %10s\n ", "addition"); break;
            case TSUBASSIGN		: printf("TSUBASSIGN %10s\n ", "substraction"); break;
            case TMULASSIGN		: printf("TMULASSIGN %10s\n ", "multiplication"); break;
            case TDIVASSIGN		: printf("TDIVASSIGN %10s\n ", "division"); break;
            case TMODASSIGN		: printf("TMODASSIGN %10s\n ", "modification"); break;

            case TIDENT		    : printf("%s\n", yytext); break;
            case TNUMBER		: printf("%s\n", yytext); break;
        }
    }
}
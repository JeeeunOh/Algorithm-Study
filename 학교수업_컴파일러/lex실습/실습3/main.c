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
            case TCONST		    : printf("TCONST %10s ", "const"); break;
            case TELSE		    : printf("TELSE %10s ", "else"); break;
            case TIF			: printf("TIF %10s ", "if"); break;
            case TINT		    : printf("TINT %10s ", "int"); break;
            case TRETURN		: printf("TRETURN %10s ", "return"); break;
            case TVOID		    : printf("TVOID %10s ", "void"); break;
            case TWHILE		    : printf("TWHILE %10s ", "while"); break;
            case TEQUAL		    : printf("TEQUAL %10s ", "equal"); break;
            case TNOTEQU		: printf("TNOTEQU %10s ", "not equal"); break;
            case TLESSE		    : printf("TLESS %10s ", "less"); break;
            case TGREATE		: printf("TGREAT %10s ", "great"); break;
            case TAND		    : printf("TAND %10s ", "and"); break;
            case TOR			: printf("TOR %10s ", "or"); break;
            case TINC		    : printf("TINC %10s ", "increase"); break;
            case TDEC		    : printf("TDEC %10s ", "decrease"); break;
            case TADDASSIGN		: printf("TADDASSIGN %10s ", "addition"); break;
            case TSUBASSIGN		: printf("TSUBASSIGN %10s ", "substraction"); break;
            case TMULASSIGN		: printf("TMULASSIGN %10s ", "multiplication"); break;
            case TDIVASSIGN		: printf("TDIVASSIGN %10s ", "division"); break;
            case TMODASSIGN		: printf("TMODASSIGN %10s ", "modification"); break;

            case TIDENT		    : printf("%s\n", yytext); break;
            case TNUMBER		: printf("%s\n", yytext); break;
        }
    }
}
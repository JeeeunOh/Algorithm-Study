%{
#include <stdio.h>
#include <stdlib.h>
enum tnumber { TEOF, TINTEGER, TBEGIN, TEND };
%}
%%

int                       return(TINTEGER); 
"{"                       return(TBEGIN); 
"}"                       return(TEND);

%%

void main(){
    enum tnumber tn; /* token number */
    printf("------- START\n");
    while ((tn=yylex()) != TEOF){
        switch (tn){
            case TINTEGER    : printf("integer"); break;
            case TBEGIN     : printf("begin"); break;
            case TEND       : printf("end"); break;
        }
    }
}

int yywrap(){ 
    printf(" ------- 1971027 JIEUN OH -------- \n");
    return 1;
}
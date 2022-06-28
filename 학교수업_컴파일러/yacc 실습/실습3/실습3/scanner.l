%{
/*
* scanner.l- lexical analyzer for the MiniC(HW3)
*
* Programmer - team2
*
* date - 
*
*
*/
#include <stdio.h>
#include <stdlib.h>
#include "tn.h" /* token name definition */
#include "glob.h" /* global variation */
extern reporterror(enum tnumber tn);  /* reporterror.c의 에러 출력 함수 */
extern int linenum; /* 코드의 line number */


%}

%%

 /*
 * Keyword(예약어)
 */
"const" return(TCONST);
"else" return(TELSE);
"if" return(TIF);
"int" return(TINT);
"return" return(TRETURN);
"void" return(TVOID);
"while" return(TWHILE);


 /*
 * ILL Identifier
 */
[0-9]+[a-zA-Z_][a-zA-Z0-9_]* reporterror(TILLIDENT);

 /*
 * 주석문
 */
\/\/.* return (TONECMT);
\/\*([^*]|\*+[^*/])*\*+\/ return (TMULCMT); 

 /*
 * Operator (연산자)
 */
"+" return(TPLUS);
"-" return(TMINUS);
"*" return(TSTAR);
"/" return(TSLASH);
"%" return(TMOD);
"=" return(TASSIGN);
"+=" return(TADDASSIGN);
"-=" return(TSUBASSIGN);
"*=" return(TMULASSIGN);
"/=" return(TDIVASSIGN);
"%=" return(TMODASSGIN);
"!" return(TNOT);
"&&" return(TAND);
"||" return(TOR);
"==" return(TEQUAL);
"!=" return(TNOTEQU);
"<" return(TLESS);
">" return(TOVER);
"<=" return(TLESSE);
">=" return(TOVERE);
"++" return(TINC);
"--" return(TDEC);

 /*
 * Special Symbols
 */
"(" return(TOSBRA);
")" return(TCSBRA);
"," return(TCOMMA);
"{" return(TOMBRA);
"}" return(TCMBRA);
"[" return(TOLBRA);
"]" return(TCLBRA);
";" return(TSEMI);

 /*
 * White spaces
 */
[ \t] ;
[\n] {
  linenum++;
}

/*
 * Identifier (명칭)
 */
[a-zA-Z_][a-zA-Z0-9_]* {

  if(yyleng>MaxIdentLen){ 
    reporterror(TLONG);
  }

  else{
    SymmbolTable();
  }
}

 /*
 * Constant (상수)
 */
[0-9]+  return(TNUMBER);
[0-9]+\.[0-9]+ return(TFLOAT);

 /*
 * illegal Symbol
 */
.    reporterror(TILLSYM);
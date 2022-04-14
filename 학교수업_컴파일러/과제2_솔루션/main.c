/*
 * main.c - 각 token에 대한 출력
 * programmer - 팀 6: 1876375정하늘, 1971039이진경, 1971051최수정
 * date - 2021.04.28
 */

#include <stdio.h>
#include "tn.h"
#include "glob.h"

int lineCount = 1;   // 라인 수
int cErrors = 0;     // 에러 수

/* printtoken
   : 토큰 타입 별로 출력한다
     잘못된 토큰(에러)일 경우 에러를 출력해주고 전체 에러 수를 카운트한다 */
void printtoken(enum tnumber tn) {
   printf("%-22d", lineCount);

   switch (tn) {
   case TSTRING: printf("%-22s%-22s%-22s", "TSTRING", "", yytext); break;
   case TCHAR: printf("%-22s%-22s%-22s", "TCHAR", "", yytext); break;

   // 예약어
   case TCONST: printf("%-22s%-22s%-22s", "TCONST","", yytext); break;
   case TELSE: printf("%-22s%-22s%-22s", "TELSE", "", yytext); break;
   case TIF: printf("%-22s%-22s%-22s", "TIF", "", yytext); break;
   case TINT: printf("%-22s%-22s%-22s", "TINT", "", yytext); break;
   case TRETURN: printf("%-22s%-22s%-22s", "TRETURN", "", yytext); break;
   case TVOID: printf("%-22s%-22s%-22s", "TVOID", "", yytext); break;
   case TWHILE: printf("%-22s%-22s%-22s", "TWHILE", "", yytext); break;

   // 산술 연산자
   case TADD: printf("%-22s%-22s%-22s", "TADD", "", yytext); break;
   case TSUB: printf("%-22s%-22s%-22s", "TSUB", "", yytext); break;
   case TMUL: printf("%-22s%-22s%-22s", "TMUL", "", yytext); break;
   case TDIV: printf("%-22s%-22s%-22s", "TDIV", "", yytext); break;
   case TMOD: printf("%-22s%-22s%-22s", "TMOD", "", yytext); break;

   // 대입 연산자
   case TASSIGN: printf("%-22s%-22s%-22s", "TASSIGN", "", yytext); break;
   case TADDASSIGN: printf("%-22s%-22s%-22s", "TADDASSIGN", "", yytext); break;
   case TSUBASSIGN: printf("%-22s%-22s%-22s", "TSUBASSIGN", "", yytext); break;
   case TMULASSIGN: printf("%-22s%-22s%-22s", "TMULASSIGN", "", yytext); break;
   case TDIVASSIGN: printf("%-22s%-22s%-22s", "TDIVASSIGN", "", yytext); break;
   case TMODASSIGN: printf("%-22s%-22s%-22s", "TMODASSIGN", "", yytext); break;

   // 논리 연산자
   case TNOT: printf("%-22s%-22s%-22s", "TNOT", "", yytext); break;
   case TAND: printf("%-22s%-22s%-22s", "TAND", "", yytext); break;
   case TOR: printf("%-22s%-22s%-22s", "TOR", "", yytext); break;

   // 비교연산자
   case TEQUAL: printf("%-22s%-22s%-22s", "TEQUAL", "", yytext); break;
   case TNOTEQU: printf("%-22s%-22s%-22s", "TNOTEQU", "", yytext); break;
   case TLESS: printf("%-22s%-22s%-22s", "TLESS", "", yytext); break;
   case TGREAT: printf("%-22s%-22s%-22s", "TGREAT", "", yytext); break;
   case TLESSE: printf("%-22s%-22s%-22s", "TLESSE", "", yytext); break;
   case TGREATE: printf("%-22s%-22s%-22s", "TGREATE", "", yytext); break;

   // 소, 중, 대괄호 및 콤마, 세미콜론
   case TBRASL: printf("%-22s%-22s%-22s", "TBRASL", "", yytext); break;
   case TBRASR: printf("%-22s%-22s%-22s", "TBRASR", "", yytext); break;
   case TBRAML: printf("%-22s%-22s%-22s", "TBRAML", "", yytext); break;
   case TBRAMR: printf("%-22s%-22s%-22s", "TBRAMR", "", yytext); break;
   case TBRALL: printf("%-22s%-22s%-22s", "TBRALL", "", yytext); break;
   case TBRALR: printf("%-22s%-22s%-22s", "TBRALR", "", yytext); break;
   case TCOMMA: printf("%-22s%-22s%-22s", "TCOMMA", "", yytext); break;
   case TSEMICOLON: printf("%-22s%-22s%-22s", "TSEMICOLON", "", yytext); break;

   // 증감 연산자
   case TINC: printf("%-22s%-22s%-22s", "TINC", "", yytext); break;
   case TDEC: printf("%-22s%-22s%-22s", "TDEC", "", yytext); break;

   // Identifier
   case TIDENT:
      if(overflow){  // ST overflow 발생한 경우
         printOverflowError();
         cErrors++;
      }
      else printf("%-22s%-22d%-22s", "TIDENT", stindex, yytext);
      break;

   // 상수
   case TNUMBER: printf("%-22s%-22s%-22s", "TNUMBER", "", yytext); break;
   case TRNUMBER: printf("%-22s%-22s%-22s", "TRNUMBER", "", yytext); break;

   // 에러
   case TLONGIDERR: printLongIDError(); cErrors++; break;
   case TSWDIGITERR: printSWDigitError(); cErrors++; break;
   case TILLSYMBOLERR: printIllSymbolError(); cErrors++; break;
   
   }
   printf("\n");
}

/* main
   : yylex()을 호출하여 토큰을 구분하여 출력한다
     마지막에 전체 에러 개수를 출력하고 종료한다 */
void main() {
    enum tnumber tn;    /* token type */

   // 헤딩 출력
    printf("%-22s%-22s%-22s%-22s\n","Line number","Token type","ST-index","Token");

   // 토큰을 구분하여 출력
    while((tn=yylex()) != TEOF){ 
      printtoken(tn);
      if(overflow) break; // 오버플로우 발생 시 종료
    }

   // 전체 에러 개수를 출력
   if (cErrors == 0)
      printf("No errors detected\n");
   else
      printf("%d errors detected\n", cErrors);
}
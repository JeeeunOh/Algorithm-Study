/*
 * reporterror.c - printing error
 * programmer - 팀 6: 1876375정하늘, 1971039이진경, 1971051최수정
 * date - 2021.04.28
 */

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "glob.h"

/* printError
   : 에러 출력문의 공통 부분을 출력한다 */
void printError(){
    printf("%-22s", "***error***");
    printf("%-22s", "");
    printf("%s ", yytext);
}

/* printLongIDError
   : 12자 이상이라서 id가 될 수 없는 토큰의 오류를 출력한다 */
void printLongIDError(){
    printError();
    printf("is too long");
}

/* printSWDigitError
   : 숫자로 시작해서 id가 될 수 없는 토큰의 오류를 출력한다 */
void printSWDigitError(){
    printError();
    printf("starts with digit");
}

/* printIllSymbolError
   : 잘못된 심볼 오류를 출력한다 */
void printIllSymbolError(){
    printError();
    printf("is illegal symbol");
}

/* printOverflowrror
   : ST 오버플로우 오류를 출력한다 */
void printOverflowError(){
    printf("%-22s", "***error***");
    printf("%-22s", "");
    printf("ST OVERFLOW, failed to save %s", yytext);
}
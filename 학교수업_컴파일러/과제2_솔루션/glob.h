/*
 * glob.h - global variable for the project
 * programmer - 팀 6: 1876375정하늘, 1971039이진경, 1971051최수정
 * date - 2021.04.28
 */

#ifndef GLOB_H_
#define GLOB_H_

#define STsize 1000    // ST 사이즈
#define HTsize 100     // HT 사이즈

/* HT 관련 구조체 */
typedef struct HTentry* HTpointer;
typedef struct HTentry {
   int index;         // ST내 시작 인덱스
   HTpointer next;    // 다음 id 포인터
} HTentry;

void SymbolTable();           // 현재 id의 symbol table management를 수행
void printIllSymbolError();   // ill symbol 에러 출력
void printLongIDError();      // 12자 초과 에러 출력
void printSWDigitError();     // 숫자로 시작 에러 출력
void printOverflowError();    // ST 오버플로우 에러 출력

extern yylex();
extern yyleng;
extern char *yytext;
extern int lineCount;      // 라인 수
extern int stindex;        // 현재 id의 ST-index
extern int overflow;       // ST 오버플로우 여부

#endif
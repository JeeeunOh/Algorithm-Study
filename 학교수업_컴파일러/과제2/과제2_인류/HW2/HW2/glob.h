/*
* glob.h - global variable for the project(HW2)
*
* Programmer - team2
*
* date - 4/27/2021
*
*/

#define MaxIdentLen 12    // identifier의 최대 길이
extern char *yytext;   // 렉스 정규표현과 매칭된 문자열
extern int yyleng;  // 매칭된 문자열의 길이
extern int linenum=1;  // 코드에서의 line number
extern int cErrors = 0; // 에러 개수
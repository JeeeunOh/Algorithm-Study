/*
* symtable.c - identifier를 ST에 넣고, HT구함 (HW2)
*
* Programmer - team2
*
* date - 4/27/2021
*
*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h> //exit()
#include "tn.h"
extern int linenum;
extern int yyleng;
extern char *yytext;
extern reporterror(enum tnumber tn);


#define STsize 1000 // string table 사이즈
#define HTsize 100 // hash table 사이즈
#define FALSE 0
#define TRUE 1

typedef struct HTentry *HTpointer;
typedef struct HTentry {
	int index; //ST안에 있는 identifier의 인덱스
	HTpointer next; //다음 identifier를 가리키는 포인터

}HTentry;


HTpointer HT[HTsize];
char ST[STsize];

int nextid = 0; //현재 identifier
int nextfree = 0; //the next available index of ST
int hashcode; //identifier의 hashcode
int sameid; //identifier의 첫번째 인덱스
int found; //for the previous ocurrence of a idntifier
int input;



/* PrintHStable - hash table 출력*/
void PrintHStable()
{
	int i, j;
	HTpointer here;

	printf("\n\n\n\n\n [[  HASH TABLE  ]] \n\n");

	for (i = 0; i < HTsize; i++) {
		if (HT[i] != NULL) {
			printf("\n  Hash Code %3d : ", i);
		}
		for (here = HT[i]; here != NULL; here = here->next) {
			j = here->index;
			while (ST[j] != '\0' && j < STsize) {
				printf("%c", ST[j++]);
				//                printf("      ");

			}

			printf(" ");
			//            printf("\n");
		}
	}
	printf("\n\n\n < %5d characters are used in the string table > \n ", nextfree);

}


/*ComputeHS
* identifier의 hascode 계산 : 모든 characters의 아스키 값을 더한 후, HT사이즈로 나눈 나머지
*/
void ComputeHS(int nid, int nfree)
{
	int code, i;
	code = 0;
	for (i = nid; i < nfree - 1; i++) {
		code += (int)ST[i]; //아스키 코드 합
		hashcode = code % HTsize; //mod
	}
}

/*
LookupHS
각 identifer에 대해, hastable에 이미 있는지 확인
이미 있다면 found를 true로 초기화 / 없다면 false로 초기화
*/
void LookupHS(int nid, int hscode)
{
	HTpointer here;
	int i, j;
	found = FALSE;

	//비어있지 않으면
	if (HT[hscode] != NULL) {
		here = HT[hscode];
		while (here != NULL && found == FALSE) {
			found = TRUE;
			i = here->index;
			j = nid;
			sameid = i;
			while (ST[i] != '\0' && ST[j] != '\0' && found == TRUE) {
				if (ST[i] != ST[j]) found = FALSE;
				else {
					i++;
					j++;
				}
			}
			here = here->next;

		}
	}
}


/*
ADDHT
새로운 identifier를 hash table에 넣는다.
ht[hashcode]리스트가 비어있다면, 해당 identifier의 ST에서 starting index를 값으로 넣어주고
리스트가 비어있지않으면 리스트 맨 앞에 해당 identifier의 ST에서 starting index를 값으로 넣어준다.
*/
void ADDHT(int hscode)
{
	HTpointer ptr;

	ptr = (HTpointer *)malloc(sizeof(ptr));
	ptr->index = nextid;
	ptr->next = HT[hscode];
	HT[hscode] = ptr;
}


/*
MAIN
*	identifier로 인식된 token을 한 글자씩 ST에 넣음. (yytext, yyleng이용)
*	해당 identifier의 hashcode값을 계산.
*	HT[hashcode]에 identifier가 이미 있는지 확인
*	이미 있으면, 현재 읽은 identifier를 ST에서 삭제
*	아직 없으면, HT[hashcode]의 index에 identifier의 ST에서의 첫 인덱스 값을 넣음
*	identifier에 대해 line number, Token-type, ST-index(identifier인 경우), token 순으로 출력
*/
int SymmbolTable()
{

	nextid = nextfree;


	//ST overflow 발생 시
	if (nextfree == STsize) {
		reporterror(TOVERFLOW);
	}

	// yytext 한글자씩 ST에 넣음
	for (int i = 0; i < yyleng; i++) {
		ST[nextfree++] = yytext[i];
	}
	// identifier를 다 넣은 후
	ST[nextfree++]= '\0';

	// HS계산, 각 identifer에 대해, hastable에 이미 있는지 확인
	ComputeHS(nextid, nextfree);
	LookupHS(nextid, hashcode);
	

	if (!found) { // 아직 같은 identifier를 ST에 넣은 적 없을 때
		// line number, Token-type, ST-index(identifier인 경우), token 순으로 출력
		printf("%-20d %-35s %-20d %-30s\n", linenum, "Identifier", nextid, yytext);
		ADDHT(hashcode); // HT 삽입
	}
	else { // 이미 같은 identifier가 있을 때

		// line number, Token-type, ST-index(identifier인 경우), token 순으로 출력
		printf("%-20d %-35s %-20d %-30s\n", linenum, "Identifier", sameid, yytext);
		nextfree = nextid; //linenum ST에 읽은 identifier를 다음에 덮어씀
	}


	/*ST출력
	printf("===ST===\n");
	for (int i = 0; i < nextfree; i++) {
	if (ST[i] == '\0') printf("\n");
	else printf("%c", ST[i]);
	}
	printf("\n\n\n");
	*/

	}

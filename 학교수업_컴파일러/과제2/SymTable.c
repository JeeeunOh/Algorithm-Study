#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h> 

#define FILE_NAME "testdata4.txt"
#define STsize 1000 //size of string table
#define HTsize 100 //size of hash table

#define isLetter(x) (((x) >= 'a' && (x) <= 'z') || ((x) >= 'A' && (x) <= 'Z'))
#define isDigit(x) ((x) >= '0' && (x) <= '9')

// 전역변수 선언
int nextid = 0, nextfree = 0;
int hashcode;
int found;
int idx1, idx2;
char errStr[1000] = ""; // 유효하지 않은 identifier를 저장할 문자 배열
int length; // identifier의 길이를 저장하기 위한 변수

typedef struct HTentry* HTpointer;
typedef struct HTentry {
	int index; 	 //index of identifier in ST
	HTpointer next;  //pointer to next identifier
} HTentry;

enum errorTypes { noerror, illsp, illid, overst, longid };
typedef enum errorTypes ERRORtypes;

char seperators[] = " .,;:?!\t\n";

HTpointer HT[HTsize];
char ST[STsize];

// more global variables…
ERRORtypes err;

FILE* fp;   //to be a pointer to FILE 
char input;

// PrintHeading	- 헤더 부분 단순 출력 함수
void PrintHeading() {
	printf("\n\n");
	printf("-------------            ------------\n");
	printf(" Index in ST              identifier\n");
	printf("-------------            ------------\n");
	printf("\n");
}

//Initialize - open input file
void initialize()
{
	fopen_s(&fp, FILE_NAME, "r");
	input = fgetc(fp);
}

// Skip Seperators - skip over strings of spaces,tabs,newlines, . , ; : ? !
void SkipSeperators()
{
	while (input != EOF) {
		int flag = 0; // input과 seperator[]의 원소 중 하나가 일치하면 1, 일치하지 않으면 0

		for (int i = 0; i < sizeof(seperators); i++) {
			if (seperators[i] == input) { // input과 seperator[] 원소 비교
				flag = 1; // 원소 중 하나라도 같으면 flag = 1
				break;
			}
		}

		if (flag == 1) input = fgetc(fp); // input이 delimeter인 경우에는 input 값 새로 읽어오기
		else break; // input이 delimeter가 아닌 경우에는 반복 종료
	}
}

// isSeperator - 문자를 받아와서 seperator인지 확인하는 함수.
//				 seperator가 맞으면 1, 아니면 0 return
int isSeperator(char c) {
	for (int i = 0; i < sizeof(seperators); i++) {
		if (seperators[i] == c)
			return 1;
	}

	return 0;
}

// PrintHStable     -   	Prints the hash table.write out the hashcode and the list of identifiers 
//			associated with each hashcode,but only for non-empty lists.
//			Print out the number of characters used up in ST.
void PrintHStable()
{
	//HT의 값을 출력하는 함수
	//단, HT의 값이 non-empty list인 경우
	//HT의 각 원소들은 index/pointer 값을 가지는 구조체
	//HT에서 next의 값이 null 인 경우
	/*
	* 초기 상태
	* |  HT[0]  |  HT[1]  |  HT[2]  |  HT[3]  |...
	*  (0, null) (1, null) (2, null) (3, null) ...
	*
	* hashcode의 값이 2인 entry가 추가되는 경우
	*  (0, null) (1, null) (2, addr) (3, null) ...
	*                      (index, null)
	*/

	printf("\n\n[[ HASH TABLE ]]\n\n");

	for (int i = 0; i < HTsize; i++) {
		HTentry* node = HT[i]; // HT[i]의 head node

		if (node == NULL) continue; // 노드가 null이라면 다음 리스트로 넘어가기

		printf("Hash Code %2d : ", i);

		while (node != NULL) {
			char ch = ST[node->index]; // identifier의 첫번째 문자
			while (ch != '\0') { // identifier 전체를 출력하는 반복문
				printf("%c", ch);
				ch = ST[++node->index];
			}

			printf("\t");
			node = node->next; // 다음 노드로 넘어가기
		}
		printf("\n");
	}

	int cnt = 0; // ST에서 사용되는 character의 수를 저장하기 위한 변수
	for (int i = 0; i < STsize; i++)
		// ST의 i번째 원소가 유효한 문자거나 정수면 cnt + 1
		if (isLetter(ST[i]) || (ST[i] == '_') || isDigit(ST[i]))
			cnt++;

	printf("\n<%d characters are used in the string table>\n", cnt);
}

// PrintIdentifier - ST에 저장된 identifier를 출력하는 함수
void PrintIdentifier() {
	// 결과 출력시 줄맞춤을 위해 str이라는 문자 배열에 따로 identifier를 복사한 후
	// str을 줄맞춤으로 출력하는 방식 사용

	char str[1000] = ""; // idendifier를 저장할 문자 배열
	int idx = 0; // str 배열의 인덱스
	for (int i = nextid; i < nextfree; i++)
		str[idx++] = ST[i]; // identifier를 str 배열에 저장
	printf("%-25s", str); // identifier 출력
}

// PrintError    - 	Print out error messages
//			overst :  overflow in ST
//			illid    : illegal identifier
//			longid   : identifier가 12자 이내가 아닌 경우
void PrintError(ERRORtypes err)
{
	if (err == overst) {
		printf("***Error*** OVERFLOW\n");
		PrintHStable();
		exit(0);
	}
	else if (err == illid) {
		printf("%-25s", "***Error***");
		PrintIdentifier();
		printf("%s\n", "illegal identifier");
	}
	else if (err == longid) {
		printf("%-25s", "***Error***");
		PrintIdentifier();
		printf("%s\n", "too long identifier");
	}
}

// deleteIdentifier - 유효하지 않은 identifier를 ST에서 삭제하는 함수
void deleteIdentifier() {
	for (int i = nextfree - 1; i >= nextid; i--) {
		ST[i] = '\0';
	}
}

//ReadID 	- 	Read identifier from the input file the string table ST directly into
//			ST(append it to the previous identifier).
//			An identifier is a string of letters and digits, starting with a letter.
//			If first letter is digit, print out error message.
void ReadID()
{
	// 입력 파일로부터 identifier를 읽어와서 ST에 저장
	// identifier가 유효한가를 따지기 위해 input이 영어 알파벳 대소문자인지/숫자인지/_인지를 판단하여야 함

	// 이 때 ST에 저장하는 시작위치 nextid
	// ST에 저장되고 그 다음 빈 공간의 위치 nextfree

	/* 변수 설정 */
	nextid = nextfree;
	length = 0; // identifier가 12자 이내인지 확인하기 위한 길이 변수

	// identifier가 숫자로 시작하는 경우 에러 처리
	if (isdigit(input) != 0) err = illid;

	while (input != EOF) {
		if (isSeperator(input) == 1) break; // input이 delimeter인 경우 반복문 종료

		/* ST에 identifier 입력하기 */
		int valid_identifier = 1; // 유효한 identifier이면 1, 그렇지 않으면 0
		while (isSeperator(input) != 1) {
			if (!isLetter(input) && (input != '_') && !isDigit(input))
				valid_identifier = 0; // 유효하지 않은 문자가 있는 경우 flag를 0으로 설정

			if (nextfree >= STsize) { // 만약 nextfree가 STsize 이상인 경우
				deleteIdentifier(); // ST에 지금까지 입력된 identifier 삭제
				return; // 함수 종료
			}

			length++; // identifier 길이 + 1
			ST[nextfree++] = input; // input을 ST에 저장 및 nextfree + 1
			input = fgetc(fp); // 새로운 문자 읽어오기

			if (input == EOF) break;
		}

		/* identifier가 12자 이내가 아닌 경우 err 설정 */
		if (length >= 13) {
			err = longid;
			break;
		}

		/* 유효하지 않은 identifier인 경우 err 설정 */
		if (valid_identifier == 0) {
			err = illid;
			break;
		}
	}

	// 에러 메시지 출력 및 에러 처리
	if (err != noerror) {
		PrintError(err); // 에러 메시지 출력
		deleteIdentifier(); // ST에서 유효하지 않은 identifier 삭제
		nextfree = nextid; // 변수 설정
		input = fgetc(fp); // 새로운 문자 읽어오기
	}
}

// ComputeHS 	- Compute the hash code of identifier by summing the ordinal values of its
//			  characters and then taking the sum modulo the size of HT. 
void ComputeHS(int nid, int nfree)
{
	//인덱스 nid부터 nfree 까지에 해당하는 ST의 값을 읽어와서 더해준 후, HT의 크기로 나누고, +1 한 값이 hashcode
	//hashcode는 전역변수로 선언되어 있음 

	int code, i;
	code = 0;
	for (i = nid; i < nfree - 1; i++)
		code += (int)ST[i];
	hashcode = code % HTsize;
}

// LookupHS 	-For each identifier,Look it up in the hashtable for previous occurrence
//			of the identifier.If find a match, set the found flag as true.
//			Otherwise flase.
//			If find a match, save the starting index of ST in same id.
void LookupHS(int nid, int hscode)
{
	//hashcode에 해당하는 HT의 리스트를 탐색하여 해당 identifier가 이미 HT에 있는지 없는지 여부를 판단
	//판단 결과는 found 변수에 저장

	found = 0;
	HTentry* node = HT[hscode]; // hascode에 해당하는 HT의 리스트의 첫번째 노드
	while (node != NULL) {
		idx1 = node->index; // 현재 HT[hscode]에 존재하는 identifier의 첫 문자의 ST 인덱스 
		idx2 = nid; // HT에 추가하고자 하는 identifier의 첫 문자의 ST 인덱스
		char ch1 = ST[idx1]; // 현재 HT[hscode]에 존재하는 identifier의 첫 문자
		char ch2 = ST[idx2]; // HT에 추가하고자 하는 identifier의 첫 문자
		int same = 0; // same이 0이면 ch1과 ch2가 같지 않음 의미, 1이면 같음 의미

		while (ch1 != '\0' && ch2 != '\0') {
			if (ch1 == ch2) { // 두 문자가 같은 경우
				same = 1;
				ch1 = ST[++idx1]; // 다음 문자
				ch2 = ST[++idx2]; // 다음 문자
			}
			else { // 두 문자가 같지 않은 경우
				same = 0;
				break;
			}
		}

		if (same == 1) { // identifier가 이미 HT에 있는 경우
			idx1 = node->index; // 이미 존재하는 identifier의 ST index를 전달
			found = 1;
			break;
		}
		node = node->next; // 다음 노드
	}
}

// ADDHT	-	Add a new identifier to the hash table.
//			If list head ht[hashcode] is null, simply add a list element with
//			starting index of the identifier in ST.
//			IF list head is not a null , it adds a new identifier to the head of the chain ?
void ADDHT(int hscode)
{
	// 새로운 노드 생성 및 리스트의 head에 새 노드 삽입
	HTpointer ptr;

	ptr = (HTpointer)malloc(sizeof(ptr));
	ptr->index = nextid;
	ptr->next = HT[hscode];
	HT[hscode] = ptr;
}

/*  MAIN	-	Read the identifier from the file directly into ST.
Compute its hashcode.
Look up the idetifier in hashtable HT[hashcode]
If matched, delete the identifier from STand print ST - index of the matching identifier.
If not matched, add a new element to the list, pointing to new identifier.
Print the identifier, its index in ST, and whether it was entered or present.
Print out the hashtable, and number of characters used up in ST
*/

int main()
{
	int i;
	PrintHeading(); // 헤더 부분 단순 출력 함수
	initialize(); // 입력 파일 open && 입력 파일로부터 첫번째 값을 읽어와서 input에 저장

	while (input != EOF) { // 파일의 끝까지 반복
		err = noerror; // err는 프로그램 수행 도중 발생하는 에러 구분을 위해 사용하는 변수. 초기값은 에러 없음으로 설정
		SkipSeperators(); // input값을 하나씩 읽어오는데, delimiter인 경우 skip
		if (input == EOF) break; // seperator가 파일의 끝에 있을 경우, '\0'가 입력되는 것을 방지하기 위한 코드
		ReadID(); // 다음 delimiter가 나타날 때까지 identifier 읽어오기. 읽어 온 identifier는 ST에 저장
				  // nextid, nextfree 값이 이 때 설정
		if (err == noerror) { // illegal identifier가 아닌 경우 hashcode 계산 후 lookup
			if (nextfree >= STsize) { //nextid와 nextfree는 ST의 인덱스
				err = overst; // ST에 대한 overflow 발생
				PrintError(err); // 에러 출력
				break;
			}
			ST[nextfree++] = '\0'; // 항상 문자 배열의 끝에는 널문자

			ComputeHS(nextid, nextfree); // hashcode 계산 (계산식은 강의노트에)
			LookupHS(nextid, hashcode); // hashcode는 ComputeHS에서 계산된 결과값
										// hashcode에 해당하는 리스트를 탐색

			if (!found) { // LookupHS 수행 결과, HT에서 찾은 경우는 found값을 0이 아닌 값으로 설정
				// print messge
				printf("%-25d", nextid); // ST에서의 index 출력
				PrintIdentifier(); // identifier 출력
				printf("%s\n", "(entered)");

				ADDHT(hashcode); // 새로운 HTentry를 추가
			}
			else {
				// print message
				printf("%-25d", idx1); // ST에서의 index 출력
				PrintIdentifier(); // identifier 출력
				deleteIdentifier(); // ST에서 해당 identifier 삭제
				nextfree = nextid; // 인덱스 처리
				printf("%s\n", "(already existed)");
			}
		}
	}
	PrintHStable();
}

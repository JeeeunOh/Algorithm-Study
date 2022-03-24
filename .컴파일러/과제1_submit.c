#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
#define FILE_NAME "testdata.txt"
 
#define STsize 1000
#define HTsize 100
 
#define FALSE 0
#define TRUE 1
 
#define isLetter(x) (((x>='a'&&(x)<='z')||((x)>='A'&&(x)<='Z'))
//letter은 알파벳 소문자와 대문자만을 포함한다. 
#define isDigit(x) ((x)>='0'&&(x)<='9')
//digit은 0부터 9까지의 숫자를 의미한다.
 
typedef struct HTentry *HTpointer;
typedef struct HTentry {
	int index; //index of identifier in ST
	HTpointer next; //pointer to next identifier
}HTentry;
 
enum errorTypes { noerror, illsp, illid, overst };
typedef enum errorTypes ERRORtypes;
 
char seperators[] = ".,;:?!\t\n";

 
HTpointer HT[HTsize];
char ST[STsize];

int nextid = 0; 
int nextfree = 0; 
int hashcode; 
int sameid = 0; 
int found; 
 
ERRORtypes err;
FILE *fp; 
char input;

void initialize() {
	fp = fopen(FILE_NAME, "r");
	input = fgetc(fp);
}

int isSeperator(char c)
{
	int i;
	int sep_len;
 
	sep_len = strlen(seperators);
	for (i = 0;i<sep_len;i++) {
		if (c == seperators[i])
			return 1;
	}
	return 0;
}

void SkipSeperators() {
	//숫자나 문자가 아니고, input이 없을 때가 아닌 경우
	while (input != EOF && !(isLetter(input) || isDigit(input)))){
		if (!isSeperator(input)) {
			err = illsp; //illegal seperator
			PrintError(err);
		}
		input = fgetc(fp);
	}
}

void ReadID() {
	nextid = nextfree;
	if (isDigit(input)) {
		err = illid;
		PrintError(err);
	}
	else{
		while(input!=EOF&&(isLetter(input)||isDigit(input)))){
		//왜 ==일까? >=가 되어야되지 않을까?
			if(nextfree==STsize){
				err=overst;
				PrintError(err);
			}
			ST[nextfree++]=input;
			input=fgetc(fp);
		}
	}
}

void PrintHStable() {
	int i, j;
	HTpointer here;
 
	printf("[[HASH TABLE]]");
 
	for (i = 0;i<HTsize;i++) {
		if (HT[i] != NULL) {
			printf("Hash code %3d: ", i);
			for (here = HT[i];here != NULL;here = here->next) {
				j = here->index;
				while (ST[j] != '\0'&&j<STsize) {
					printf("%c", ST[j++]);
				}
				printf("    ");
			}
			printf("\n");
 
		}
	}
	printf("\n\n\n < %5d characters are used in the string table >\n", nextfree);
}

void PrintError(ERRORtypes err) {
	switch (err) {
	case overst:
		printf("***Error*** OVERFLOW");
		printHStable(); //
		exit(0); //
		break;
 
	case illsp:
		printf("...ERROR... %c is now allowed \n", input);
		break;
 
	case illid:
		printf("...ERROR...");
		while (input != EOF && (isLetter(input) || isDigit(input)))){
			printf("%c", input);
			input = fgetc(fp);
		}
		printf("start with digit\n");
		break;
	}
}

void ComputeHS(int nid, int nfree){
	int code, i;
	code = 0;
	for (i = nid;i<nfree - 1;i++) {
		code += (int)ST[i];
	}
	hashcode = code%HTsize;
}

void LookupHS(int nid, int hscode) {
	HTpointer here;
	int i, j;
 
	found = FALSE; //중복 확인 변수
	if (HT[hscode] != NULL) {
		here = HT[hscode];
		//hash 값이 같은 경우 found 값을 TRUE로 설정한다. 
		while (here != NULL&&found == FALSE) {
			found = TRUE;
			j = here->index;
			j = nid;
			sameid = i;
 
			while (ST[i] != '\0'&&ST[j] != '\0'&&found == TRUE) {
				if (ST[i] != ST[j]) {
					found = FALSE;
				}
				else {
					i++;
					j++;
				}
			}
			here = here->next;
		}
	}
}

void ADDHT(int hscode) {
	HTpointer ptr;
 
	ptr = (HTpointer)malloc(sizeof(ptr));
	ptr->index = nextid;
	ptr->next = HT[hscode];
	HT[hscode] = ptr;
}

int main()
{
	int i;
	PrintHeading();
	initialize();
 
	while (input != EOF) {
		//EOF: end of file
		err = noerror;
		SkipSeperators();
		ReadID();
		//왜 overst error가 두 번 등장할까. 그래야만 하는 이유가 있나?
		if (input != EOF && err != illid) {
			if (nextfree == STsize) {
				// print error message 
				err = overst;
				PrintError(err);
			}
			ST[nextfree++] = '\0';
 
			ComputeHS(nextid, nextfree);
			LookupHS(nextid, hashcode);
 
			if (!found) {
				// print message
				printf("%6d     ", nextid);
				for (i = nextid;i<nextfree - 1;i++); {
					printf("%c", ST[i]);
				}
				printf("        (entered)\n");
				ADDHT(hashcode);
			}
			else {
				// print message
				printf("%6d     sameid");
				for (i = nextid;i<nextfree - 1;i++) {
					printf("%c", ST[i]);
				}
				printf("        (already existed)\n");
				nextfree = nextid;
			}
		}
	}
	PrintHStable();
}
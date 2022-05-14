#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
#define FILE_NAME "testdata1.txt"
 
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
//\t: tab, \n: enter
 
HTpointer HT[HTsize];
//hash table의 pointer를 HT라는 이름의 배열로 만든다.
char ST[STsize];
//symbol table을 ST라는 배열로 만든다.
 
//more global variables...
int nextid = 0; //the current identifier
int nextfree = 0; //the next available index of ST
				  //nextfree의 주소=nextid 주소+identifier 길이..?
int hashcode; //hash code of identifier
int sameid = 0; //first index of identifier
 
int found; // for the previous occurence of an identifie
 
ERRORtypes err;
 
FILE *fp; //to be a pointer to FILE, that is "testdata.txt"
char input;
 
//3페이지
 
//Initialize -open input File
void initialize() {
	fp = fopen(FILE_NAME, "r");
	input = fgetc(fp);
	//pointer fp로 파일을 읽는다. (fgetc: 문자를 읽어오는 함수)
}
 
//isSeperator -distinguish the seperator
int isSeperator(char c)
{
	int i;
	int sep_len;
 
	sep_len = strlen(seperators);
	for (i = 0;i<sep_len;i++) {
		if (c == seperators[i])
			return 1;
		//c가 seperator인 경우
	}
	return 0;
	//c가 seperator가 아닌 다른 캐릭터일 경우
}
 
//PrintHeading - print the Heading
 
void PrintHeading(){
	printf("\n\n");
	printf("--------------------------\n");
	printf("Index in ST     identifier\n");
	printf("--------------------------\n");
	printf("\n");
}
 
/* PrintHStable - Prints the hash table.write out the hashcode and the list of identifiers
associated with each hashcode,but only for non-empty lists.
Print out the number of characters used up in ST.
*/
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
/*
	case toolong:
		printf("...ERROR...");
		while (input != EOF && (isLetter(input) || isDigit(input))) {
			printf("%c", input);
			input = fgetc(fp)
		}
		printf("too long identifier\n");
		break;
 
	}
}
*/
 
//5페이지
 
//SkipSeperators -skip over strings of spaces,tabs,newlines, . , ; : ? ! 
//if illegal seperators,print out error message.
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
 
/*ReadIO - Read identifier from the input file the string table ST directly into
ST(append it to the previous identifier).
An identifier is a string of letters and digits, starting with a letter.
If first letter is digit, print out error message.
*/
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
 
//6페이지
 
// ComputeHS - Compute the hash code of identifier by summing the ordinal values of its 
//              characters and then taking the sum modulo the size of HT.
void ComputeHS(int nid, int nfree)
{
	//main 함수에서는 nid=nextid, nfree=nextfree이다.
	int code, i;
	code = 0;
	for (i = nid;i<nfree - 1;i++) {
		code += (int)ST[i];
	}
	hashcode = code%HTsize;
}
 
/* LookupHS -For each identifier,Look it up in the hashtable for previous occurrence
of the identifier.If find a match, set the found flag as true.
Otherwise flase.
If find a match, save the starting index of ST in same id.
*/
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
 
//7페이지
 
/* ADDHT- Add a new identifier to the hash table.
If list head ht[hashcode] is null, simply add a list element with
starting index of the identifier in ST.
IF list head is not a null , it adds a new identifier to the head of the chain
*/
void ADDHT(int hscode) {
	HTpointer ptr;
 
	ptr = (HTpointer)malloc(sizeof(ptr));
	ptr->index = nextid;
	ptr->next = HT[hscode];
	HT[hscode] = ptr;
}
 
 
/*
Read the identifier from the file directly into ST.
Compute its hashcode.
Look up the idetifier in hashtable HT[hashcode]
If matched, delete the identifier from ST and print ST-index of the matching identifier.
If not matched , add a new element to the list,pointing to new identifier.
Print the identifier,its index in ST, and whether it was entered or present.
Print out the hashtable,and number of characters used up in ST
*/
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
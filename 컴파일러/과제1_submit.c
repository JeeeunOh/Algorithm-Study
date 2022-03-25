#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
#define FILE_NAME "testdata.txt"
 
#define STsize 1000
#define HTsize 100
 
#define FALSE 0
#define TRUE 1
 
#define isLetter(x) ( ((x) >= 'a' && (x) <='z') || ((x) >= 'A' && (x) <= 'Z') )
#define isDigit(x) ( (x) >= '0' && (x) <= '9' )

typedef struct HTentry *HTpointer;
typedef struct HTentry {
	int index; 
	HTpointer next;
}HTentry;
 
enum errorTypes { noerror, illsp, illid, overst };
typedef enum errorTypes ERRORtypes;
 
char seperators[] = ".,;:?!\t\n";
 
HTpointer HT[HTsize];
char ST[STsize];
 
int nextid = 0;
int nextfree = 0;  
int hashcode; 
int sameid;
int found; 

ERRORtypes err;

FILE *fp;
char input;

void initialize(){
  fp = fopen(FILE_NAME, "r");
  input = fgetc( fp );
}

int isSeperator(char c) {
  int i;
  int sep_len;

  sep_len = strlen(seperators);
  for( i = 0 ; i < sep_len; i++ ) {
    if( c == seperators[i] )
      return 1;
  }
  return 0;
}

void PrintHeading(){
  printf("\n\n");
  printf("  -----------      ------------ \n");
  printf("  Index in ST       identifier  \n");
  printf("  -----------      ------------ \n");
  printf("\n");
}

// 교수님이 안 주심
void PrintHStable() {
	int i, j;
	HTpointer here;
 
	printf("\n[[HASH TABLE]]\n");
 
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

void PrintError( ERRORtypes err ){
  switch( err ) {
    case overst : 
      printf("  ...Error...   OVERFLOW ");
      PrintHStable();
      exit(0);
      break;
    case illsp :
      printf("  ...Error...  %c is illegal seperator \n", input);
      break;
    case illid : 
      printf("  ...Error... ");
      while( input != EOF && (isLetter(input) || isDigit(input)) ) {
	printf("%c", input);
	input = fgetc( fp );
      }
      printf(" start with digit \n");
      break;
  }
}

void SkipSeperators(){
  while( input != EOF && !( isLetter(input) || isDigit(input) ) ) {
    if( !isSeperator(input) ) {
      err = illsp;
      PrintError( err );
    }
    input = fgetc( fp );
  }
}

// 겨수님이 안 주심
void ReadID() {
	nextid = nextfree;
	if (isDigit(input)) {
		err = illid;
		PrintError(err);
	}
	else{
		while(input!=EOF&&(isLetter(input)||isDigit(input))){
			if(nextfree==STsize){
				err=overst;
				PrintError(err);
			}
			ST[nextfree++]=input;
			input=fgetc(fp);
		}
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

void LookupHS( int nid, int hscode ){
	int a,b;
	HTpointer cur;
	found = FALSE;
	
	if ( HT[hscode]!= NULL ) {
		cur = HT[hscode];
		while ( cur!= NULL && found == FALSE ) {
			b = cur->index;
			b = nid;
			sameid = a;
			found = TRUE;
 
			while ( ST[a]!= '\0' && ST[b] != '\0' && found == TRUE ) {
				if ( ST[a]!= ST[b] ) found = FALSE;
				else {
					a++;
					b++;
				}
			}
			cur = cur->next;
		}
	}
}

void ADDHT(int hscode) { 
	HTpointer cur;
	cur = (HTpointer)malloc(sizeof(cur));
	cur->index = nextid;
	cur->next = HT[hscode];
	HT[hscode] = cur;
}

int main(){
	int i;
  	PrintHeading();
  	initialize();

  	while(input!= EOF) { // 파일의 끝에 도달할때까지 반복
		err = noerror; // 에러가 없다고 가정
		SkipSeperators();
		ReadID();
		if( input!= EOF && err!= illid ) {
			if (nextfree == STsize) { // 스택 오버플로가 일어났을 때 에러 출력
				err = overst;
				PrintError(err);
			}

			ST[nextfree++] = '\0'; // 문자열의 끝임을 표현해주고
			ComputeHS(nextid, nextfree);
			LookupHS(nextid, hashcode);
	
			if (!found) { // 같은 해시 값 찾지 못했을 때
				printf("     %d          ", nextid);
				for ( i=nextid ; i<nextfree-1 ; i++ ) printf("%c", ST[i]); 
				printf("                  (entered)\n");
				ADDHT(hashcode);
			}

			else { // 같은 해시 값 찾았을 때
				printf("     %d          sameid");
				for ( i=nextid ; i<nextfree-1 ; i++ ) printf("%c", ST[i]);  
				printf("                  (already existed)\n");
				nextfree = nextid;
			}
		}
	}
	PrintHStable();
}
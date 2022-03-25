#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
#define FILE_NAME "testdata1.txt"
 
#define STsize 1000
#define HTsize 100
 
#define isLetter(x) ( ((x) >= 'a' && (x) <='z') || ((x) >= 'A' && (x) <= 'Z') || (x) == '_' )
#define isDigit(x) ( (x) >= '0' && (x) <= '9' )

typedef struct HTentry *HTpointer;
typedef struct HTentry {
	int index; 
	HTpointer next;
}HTentry;
 
enum errorTypes { noerror, illsp, illid, overst, toolong };
typedef enum errorTypes ERRORtypes;
 
char seperators[] = " .,;:?!\t\n";

HTpointer HT[HTsize];
char ST[STsize];
 
int nextid = 0, nextfree = 0;  
int hashcode, sameid;
int found; 

ERRORtypes error;

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
    if( c == seperators[i] ) return 1;
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

void PrintHStable() {
    HTpointer pointer;
    printf("\n\n[[  HASH TABLE  ]]\n\n");

    for (int i = 0; i < HTsize; i++) {
        pointer = HT[i];
        if (pointer != NULL) {
            printf("Hash Code %3d : ", i);
            while (pointer != NULL) {
                int data = pointer->index;
                while (data < STsize && ST[data] != '\0') {
                    printf("%c", ST[data]);
                    data++;
                }
                printf("   ");
                pointer = pointer->next;
            }
            printf("\n");
        }
    }
    printf("\n<%d characters are used in the string table>\n", nextfree);
}

void PrintError( ERRORtypes err ){
  switch( err ) {
      case overst :
          printf("...Error...                            OVERFLOW ");
          PrintHStable();
          exit(0);
          break;
      case illsp :
          printf("...Error...         %c                  is illegal seperator \n", input);
          break;
      case illid :
          printf("...Error...     ");
          while( input != EOF && (isLetter(input) || isDigit(input)) ) {
              printf("%c", input);
              input = fgetc( fp );
          }
          printf("                             start with digit \n");
          break;
      case toolong :
          printf("...Error...     ");
          while( input != EOF && (isLetter(input) || isDigit(input)) ) {
              printf("%c", input);
              input = fgetc( fp );
          }
          printf("                            too long identifier \n");
          break;
  }
}

void SkipSeperators(){
  while( input != EOF && !( isLetter(input) || isDigit(input) ) ) {
    if( !isSeperator(input) ) {
      error = illsp;
      PrintError( error );
    }
    input = fgetc( fp );
  }
}

void ReadID() {
    nextid = nextfree;
    int count = 0;
    
    if (isLetter(input)) {
        count++;
        while(input != EOF && (isLetter(input) || isDigit(input))) {
            count++;
            if (nextfree == STsize) {
                error = overst;
                PrintError(error);
            }
            if (count >= 12) {
                PrintError(toolong);
            }
            ST[nextfree] = input;
            nextfree++;
            input = fgetc(fp);
        }
    } else {
        error = illid;
        PrintError(error);
    }
}

void ComputeHS( int nid, int nfree ){
    int sum = 0;
    for (int i = nid; i < nfree; i++) {
        sum += ST[i];
    }
    hashcode = sum % HTsize;
}

void LookupHS( int nid, int hscode ){
	int a,b;
	HTpointer cur;
	found = 0;
	
	if ( HT[hscode]!= NULL ) {
		cur = HT[hscode];
		while ( cur!= NULL && found == 0 ) {
			b = cur->index;
			b = nid;
			sameid = a;
			found = 1;
 
			while ( ST[a]!= '\0' && ST[b] != '\0' && found == 1 ) {
				if ( ST[a]!= ST[b] ) found = 0;
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
		error = noerror; // 에러가 없다고 가정
		SkipSeperators();
		ReadID();
		if( input!= EOF && error!= illid ) {
			if (nextfree == STsize) { // 스택 오버플로가 일어났을 때 에러 출력
				error = overst;
				PrintError(error);
			}

			ST[nextfree++] = '\0'; // 문자열의 끝임을 표현해주고
			ComputeHS(nextid, nextfree);
			LookupHS(nextid, hashcode);
	
			if (!found) { // 같은 해시 값 찾지 못했을 때
				printf("     %d          ", nextid);
				for ( i=nextid ; i<nextfree-1 ; i++ ) printf("%c", ST[i]); 
				printf("                            (entered)\n");
				ADDHT(hashcode);
			}

			else { // 같은 해시 값 찾았을 때
				printf("     %d              sameid ");
				for ( i=nextid ; i<nextfree-1 ; i++ ) printf("%c", ST[i]);  
				printf("                            (already existed)\n");
				nextfree = nextid;
			}
		}
	}
	PrintHStable();
}
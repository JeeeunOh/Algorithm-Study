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
int longFlag=0; // 문자열 길이가 12가 넘으면 TRUE처리
char lastChar[1024]="";

int lastCharIndex; // 오버플로우 때 이제까지 완전하게 받은 char 개수가 몇개인지 저장

ERRORtypes error;

FILE *fp;
char input;

void initialize(){
  fp = fopen(FILE_NAME, "r");
  input = fgetc( fp );
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
    if(error==overst) printf("\n<%d characters are used in the string table>\n", lastCharIndex);
    else printf("\n<%d characters are used in the string table>\n", nextfree);
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

void PrintError( ERRORtypes err ){
  switch( err ) {
    case overst :
        printf("...Error...       OVERFLOW ");
        PrintHStable();
        exit(0);
        break;
    case illsp :
        printf("...Error...       %c is illegal seperator \n", input);
        break;
    case illid :
        printf("...Error...       ");
        while( input != EOF && (isLetter(input) || isDigit(input)) ){ 
            printf("%c", input);
            input = fgetc( fp );
        }
        printf(" start with digit \n");
        break;
    case toolong :
        printf("...Error...       ");
        for(int i=0 ; i<strlen(lastChar); i++){
            printf("%c", lastChar[i]);
        }
        while( input != EOF && (isDigit(input) || isLetter(input)) ){
            printf("%c", input);
            input = fgetc( fp );
        }
        printf(" too long identifier \n");
        break;
    default : break;
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
    
    if (isDigit(input)) {
        error = illid;
        PrintError(error);
    }
    else {
        lastChar[0] = '\0'; // 배열 내용 지움
        while(input != EOF && (isLetter(input) || isDigit(input))) {
            if (nextfree == STsize) {
                error = overst;
                PrintError(error);
            }

            strcat(lastChar, &input);
    
            ST[nextfree] = input;
            nextfree++;
            input = fgetc(fp);
            count++;

            if (count > 12) {
                PrintError(toolong);
                nextfree-=14;
                longFlag=1;
            }
        }
    }
}

void ComputeHS( int nid, int nfree ){
    int sum = 0;
    for (int i = nid; i < nfree; i++) {
        sum += ST[i];
    }
    hashcode = sum % HTsize;
}

void LookupHS( int nid, int hscode ){ // 같은 해시코드 있는지 확인
	int a,b;
	HTpointer cur;
	found = 0; // 없다고 가정하고 찾기
	
	if ( HT[hscode]!= NULL ) { // 해당 해시코드 자리가 비어있지 않으면
		cur = HT[hscode];
		while ( cur!= NULL && found == 0 ) { // cur이 비어있지 않고 아직 같은 해시코드 찾지 못했으면
            found = 1; // 찾았다고 해주고
			a = cur->index; 
			b = nid;
			sameid = a;
 
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
        if(input==EOF) break;
		ReadID();
		if(error!= illid ) {
			if (nextfree == STsize) { // 스택 오버플로가 일어났을 때 에러 출력
				error = overst;
				PrintError(error);
			}
            lastCharIndex=nextfree;
			ST[nextfree++] = '\0'; // 문자열의 끝임을 표현해주고
			ComputeHS(nextid, nextfree);
			LookupHS(nextid, hashcode);
	
			if (!found && longFlag==0) { // 같은 해시 값 찾지 못했을 때
				printf("     %3d          ", nextid);
				for ( i=nextid ; i<nextfree-1 ; i++ ) printf("%c", ST[i]); 
				printf("                            (entered)\n");
				ADDHT(hashcode); // 해시코드 추가해줌
			}

			else if (found && longFlag==0) { // 같은 해시 값 찾았을 때
				printf("     %3d         ", sameid);
				for ( i=nextid ; i<nextfree-1 ; i++ ) printf("%c", ST[i]);  
				printf("                            (already existed)\n");
				nextfree = nextid;
			} else if(longFlag==1){ // longFlag 처리
                longFlag=0;
            }
		}
	}
	PrintHStable();
}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define FILE_NAME "testdata1.txt"
#define _CRT_SECURE_NO_WARNINGS

#define STsize 1000 //size of string table
#define HTsize 100 //size of hash table

#define FALSE 0
#define TRUE 1

//노윤주
#define isLetter(x) ( ((x) >= 'a' && (x) <='z') || ((x) >= 'A' && (x) <= 'Z') || (x) == '_' )
#define isDigit(x) ( (x) >= '0' && (x) <= '9' )

typedef struct HTentry *HTpointer;
typedef struct HTentry {
  int index;  //index of identifier in ST
  HTpointer next;  //pointer to next identifier
} HTentry;

//노윤주
enum errorTypes { noerror, illsp, illid, overst, toolong };
typedef enum errorTypes ERRORtypes;

char seperators[] = " .,;:?!\t\n";

HTpointer HT[HTsize];
char ST[STsize];

//more define variables..
//main 함수에서 정의되지 않은 변수들을 전역변수 혹은 함수 내의 지역변수로 선언
int nextid = 0, nextfree = 0;  //the current identifier //the next available index of ST
int hashcode;  //hash code of identifier
int sameid;  //first index of identifier
int found;

ERRORtypes error; //more global variables
FILE* fp; //to be a pointer to FILE
char input;

//Initialize - open input file
void initialize() { // 파일 읽으면서 char 하나씩 가져옴
    fp = fopen(FILE_NAME, "r");
    input = fgetc( fp );
}

//isSerperator  -  distinguish the seperator
int isSeperator(char c) 
{
  int i;
  int sep_len;

  sep_len = strlen(seperators);
  for( i = 0 ; i < sep_len; i++ ) {
    if(c == seperators[i])
      return 1;
  }
  return 0;
}

//printHeading	 -		Print the heading
void PrintHeading()
{
  printf("\n\n");
  printf("  -----------      ------------ \n");
  printf("  Index in ST       identifier  \n");
  printf("  -----------      ------------ \n");
  printf("\n");
}

// PrintHStable     -       Prints the hash table.write out the hashcode and the list of identifiers
//            associated with each hashcode,but only for non-empty lists.
//            Print out the number of characters used up in ST. ?
void PrintHStable() {
    //HT에서 next의 값이 null인 경우 - empty
    /*
     * 초기 상태
     * |  HT[0]  |  HT[1]  |  HT[2]  |  HT[3]  | ...
     *  (0, null) (1, null) (2, null) (3, null) ...
     *
     * hashcode의 값이 2인 entry가 추가되는 경우
     *  (0, null) (1, null) (2, addr) (3, null) ...
     *                      (index, null)
     */
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

//print the hashtable and abort by calling the function "abort()".
//노윤주 (추가)
void PrintError( ERRORtypes err )
{
  switch( err ) {
      case overst :
          printf("...Error...   OVERFLOW ");
          PrintHStable();
          exit(0);
          break;
      case illsp :
          printf("...Error...  %c is illegal seperator \n", input);
          break;
      case illid :
          printf("...Error...     ");
          while( input != EOF && (isLetter(input) || isDigit(input)) ) {
              printf("%c", input);
              input = fgetc( fp );
          }
          printf("    start with digit \n");
          break;
      case toolong :
          printf("...Error... ");
          while( input != EOF && (isLetter(input) || isDigit(input)) ) {
              printf("%c", input);
              input = fgetc( fp );
          }
          printf(" too long identifier \n");
          break;
  }
}

/* Skip Seperators -   	skip over strings of spaces,tabs,newlines, . , ; : ? !
						if illegal seperators,print out error message.*/

void SkipSeperators()
{
  while( input != EOF && !( isLetter(input) || isDigit(input) ) ) {
    if( !isSeperator(input) ) {
      error = illsp;
      PrintError( error );
    }
    input = fgetc( fp );
  }
}

//            ST(append it to the previous identifier).
//노윤주
void ReadID() {
    nextid = nextfree;
    int count = 0;
    
    if (isDigit(input)) {
        error = illid;
        PrintError(error);
        }
    else {
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
    }
}

//노윤주
void ComputeHS( int nid, int nfree ){
    int sum = 0;
    for (int i = nid; i < nfree; i++) { //nfree - 1 해야하나..? 왜지
        sum += ST[i]; //(int) 씌워줘야할까..
    }
    hashcode = sum % HTsize; //+1 안 해도 되나..?
}

//언니
void LookupHS( int nid, int hscode ) { // 해시코드 찾아냄
    int a = 0;
    int b;
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

//언니
void ADDHT( int hscode ) {
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
                printf("     %d         ", sameid);
                for ( i=nextid ; i<nextfree-1 ; i++ ) printf("%c", ST[i]);
                printf("                            (already existed)\n");
                nextfree = nextid;
            }
        }
    }
    PrintHStable();
}
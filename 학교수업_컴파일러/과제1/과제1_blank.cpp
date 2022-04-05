#include <stdio.h> 
#include <stdlib.h> 
#include <string.h>

#define FILE_NAME "testdata.txt"
#define STsize 1000 
#define HTsize 100

typedef struct HTentry *HTpointer; 
typedef struct HTentry {
    int index; //index of identifier in ST
    HTpointer next; //pointer to next identifier 
} HTentry;

enum errorTypes { noerror, illsp, illid, overst }; 
typedef enum errorTypes ERRORtypes;

char seperators[] = " .,;:?!\t\n";

HTpointer HT[HTsize]; 
char ST[STsize];

ERRORtypes err;
FILE *fp; 
char input;

void initialize() { // 파일 읽으면서 char 하나씩 가져옴
    fp = fopen(FILE_NAME, "r");
    input = fgetc( fp ); 
}

// 지은
void SkipSeperators() { // 기호, 스페이스 등을 만나면 스킵하기 : 하

}

void ReadID() { //identifier 읽어옴 : 중

}

// 윤주
void PrintHStable() { // 해시테이블 출력 : 하

}

void PrintError( ERRORtypes err ) { // 오버플로우, 잘못된 기호들 에러메세지 : 중

}


int ComputeHS( int nid, int nfree ){ // 해시코드 값 계산

}

boolean LookupHS( int nid, int hscode ) { // 해시코드 찾아냄

}

void ADDHT( int hscode ) { // 해시테이블에 추가

}

int main() {

    int i; 
    int nextid, nextfree, hashcode;
    PrintHeading(); 
    initialize();

    while (input != EOF) {
        err = noerror;
        SkipSeperators();
        ReadID();
        if( input != EOF && err != illid ) { 
            if( nextfree == STsize ) {
                // print error message ST[nextfree++] = '\0';
                hashcode = ComputeHS( nextid, nextfree );
                if( !LookupHS( nextid, hashcode )) { // 해시코드 못 찾아냈으면
                    // print message
                    ADDHT( hashcode );
                } else {
                // print message 
                }
            }
        }
    }
    PrintHStable(); 
}
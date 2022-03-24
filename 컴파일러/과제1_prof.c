#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define FILE_NAME "testdata.txt"

#define STsize 1000  //size of string table
#define HTsize 100	//size of hash table

#define FALSE 0
#define TRUE 1

#define isLetter(x) ( ((x) >= 'a' && (x) <='z') || ((x) >= 'A' && (x) <= 'Z') )
#define isDigit(x) ( (x) >= '0' && (x) <= '9' )

typedef struct HTentry *HTpointer;
typedef struct HTentry {
  int index;  //index of identifier in ST
  HTpointer next;  //pointer to next identifier
} HTentry;


enum errorTypes { noerror, illsp, illid, overst };
typedef enum errorTypes ERRORtypes;

char seperators[] = " .,;:?!\t\n";

HTpointer HT[HTsize];
char ST[STsize];

int nextid = 0;  //the current identifier
int nextfree = 0;  //the next available index of ST
int hashcode;  //hash code of identifier
int sameid;  //first index of identifier

int found;  //for the previous occurrence of an identifie

ERRORtypes err;

FILE *fp;   //to be a pointer to FILE 
char input;



//Initialize - open input file

void initialize()
{
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
    if( c == seperators[i] )
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



/*PrintHStable     -   	Prints the hash table.write out the hashcode and the list of identifiers 
						associated with each hashcode,but only for non-empty lists.
						Print out the number of characters used up in ST. */

void PrintHStable()
{

}




/* PrintError    - 	Print out error messages
			overst :  overflow in ST
			print the hashtable and abort by calling the function "abort()".
			illid    : illegal identifier
			illsp    :illegal seperator*/

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
      printf("...Error... ");
      while( input != EOF && (isLetter(input) || isDigit(input)) ) {
	printf("%c", input);
	input = fgetc( fp );
      }
      printf(" start with digit \n");
      break;
  }
}



/* Skip Seperators -   	skip over strings of spaces,tabs,newlines, . , ; : ? !
						if illegal seperators,print out error message.*/

void SkipSeperators()
{
  while( input != EOF && !( isLetter(input) || isDigit(input) ) ) {
    if( !isSeperator(input) ) {
      err = illsp;
      PrintError( err );
    }
    input = fgetc( fp );
  }
}



/*ReadID 	- 	Read identifier from the input file the string table ST directly into
			ST(append it to the previous identifier).
			An identifier is a string of letters and digits, starting with a letter.
			If first letter is digit, print out error message. */

void ReadID() 
{

}



/* ComputeHS 	- 	Compute the hash code of identifier by summing the ordinal values of its
					characters and then taking the sum modulo the size of HT. */

void ComputeHS( int nid, int nfree )
{

}



/*LookupHS 	-	For each identifier,Look it up in the hashtable for previous occurrence
				of the identifier.If find a match, set the found flag as true.
				Otherwise flase.
				If find a match, save the starting index of ST in same id. */

void LookupHS( int nid, int hscode )
{

}


/* ADDHT	-	Add a new identifier to the hash table.
			If list head ht[hashcode] is null, simply add a list element with
			starting index of the identifier in ST.
			IF list head is not a null , it adds a new identifier to the head of the chain */

void ADDHT( int hscode )
{

}


/* MAIN		-	Read the identifier from the file directly into ST.
			Compute its hashcode.
			Look up the idetifier in hashtable HT[hashcode]
 		 	If matched, delete the identifier from ST and print ST-index
			of the matching identifier.
			If not matched , add a new element to the list,pointing to new identifier.
			Print the identifier,its index in ST, and whether it was entered or present.
			Print out the hashtable,and number of characters used up in ST
*/
int main()
{
  int i;
  PrintHeading();
  initialize();

  while(input != EOF) {
    err = noerror;
    SkipSeperators();
    ReadID();
    if( input != EOF && err != illid ) {


      ComputeHS( nextid, nextfree );
      LookupHS( nextid, hashcode );
      
      if( !found ) {

      }
      else {

      }
    }
  }
  PrintHStable();
}

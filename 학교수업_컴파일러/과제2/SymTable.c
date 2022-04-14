#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h> 

#define FILE_NAME "testdata4.txt"
#define STsize 1000 //size of string table
#define HTsize 100 //size of hash table

#define isLetter(x) (((x) >= 'a' && (x) <= 'z') || ((x) >= 'A' && (x) <= 'Z'))
#define isDigit(x) ((x) >= '0' && (x) <= '9')

// �������� ����
int nextid = 0, nextfree = 0;
int hashcode;
int found;
int idx1, idx2;
char errStr[1000] = ""; // ��ȿ���� ���� identifier�� ������ ���� �迭
int length; // identifier�� ���̸� �����ϱ� ���� ����

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

// more global variables��
ERRORtypes err;

FILE* fp;   //to be a pointer to FILE 
char input;

// PrintHeading	- ��� �κ� �ܼ� ��� �Լ�
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
		int flag = 0; // input�� seperator[]�� ���� �� �ϳ��� ��ġ�ϸ� 1, ��ġ���� ������ 0

		for (int i = 0; i < sizeof(seperators); i++) {
			if (seperators[i] == input) { // input�� seperator[] ���� ��
				flag = 1; // ���� �� �ϳ��� ������ flag = 1
				break;
			}
		}

		if (flag == 1) input = fgetc(fp); // input�� delimeter�� ��쿡�� input �� ���� �о����
		else break; // input�� delimeter�� �ƴ� ��쿡�� �ݺ� ����
	}
}

// isSeperator - ���ڸ� �޾ƿͼ� seperator���� Ȯ���ϴ� �Լ�.
//				 seperator�� ������ 1, �ƴϸ� 0 return
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
	//HT�� ���� ����ϴ� �Լ�
	//��, HT�� ���� non-empty list�� ���
	//HT�� �� ���ҵ��� index/pointer ���� ������ ����ü
	//HT���� next�� ���� null �� ���
	/*
	* �ʱ� ����
	* |  HT[0]  |  HT[1]  |  HT[2]  |  HT[3]  |...
	*  (0, null) (1, null) (2, null) (3, null) ...
	*
	* hashcode�� ���� 2�� entry�� �߰��Ǵ� ���
	*  (0, null) (1, null) (2, addr) (3, null) ...
	*                      (index, null)
	*/

	printf("\n\n[[ HASH TABLE ]]\n\n");

	for (int i = 0; i < HTsize; i++) {
		HTentry* node = HT[i]; // HT[i]�� head node

		if (node == NULL) continue; // ��尡 null�̶�� ���� ����Ʈ�� �Ѿ��

		printf("Hash Code %2d : ", i);

		while (node != NULL) {
			char ch = ST[node->index]; // identifier�� ù��° ����
			while (ch != '\0') { // identifier ��ü�� ����ϴ� �ݺ���
				printf("%c", ch);
				ch = ST[++node->index];
			}

			printf("\t");
			node = node->next; // ���� ���� �Ѿ��
		}
		printf("\n");
	}

	int cnt = 0; // ST���� ���Ǵ� character�� ���� �����ϱ� ���� ����
	for (int i = 0; i < STsize; i++)
		// ST�� i��° ���Ұ� ��ȿ�� ���ڰų� ������ cnt + 1
		if (isLetter(ST[i]) || (ST[i] == '_') || isDigit(ST[i]))
			cnt++;

	printf("\n<%d characters are used in the string table>\n", cnt);
}

// PrintIdentifier - ST�� ����� identifier�� ����ϴ� �Լ�
void PrintIdentifier() {
	// ��� ��½� �ٸ����� ���� str�̶�� ���� �迭�� ���� identifier�� ������ ��
	// str�� �ٸ������� ����ϴ� ��� ���

	char str[1000] = ""; // idendifier�� ������ ���� �迭
	int idx = 0; // str �迭�� �ε���
	for (int i = nextid; i < nextfree; i++)
		str[idx++] = ST[i]; // identifier�� str �迭�� ����
	printf("%-25s", str); // identifier ���
}

// PrintError    - 	Print out error messages
//			overst :  overflow in ST
//			illid    : illegal identifier
//			longid   : identifier�� 12�� �̳��� �ƴ� ���
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

// deleteIdentifier - ��ȿ���� ���� identifier�� ST���� �����ϴ� �Լ�
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
	// �Է� ���Ϸκ��� identifier�� �о�ͼ� ST�� ����
	// identifier�� ��ȿ�Ѱ��� ������ ���� input�� ���� ���ĺ� ��ҹ�������/��������/_������ �Ǵ��Ͽ��� ��

	// �� �� ST�� �����ϴ� ������ġ nextid
	// ST�� ����ǰ� �� ���� �� ������ ��ġ nextfree

	/* ���� ���� */
	nextid = nextfree;
	length = 0; // identifier�� 12�� �̳����� Ȯ���ϱ� ���� ���� ����

	// identifier�� ���ڷ� �����ϴ� ��� ���� ó��
	if (isdigit(input) != 0) err = illid;

	while (input != EOF) {
		if (isSeperator(input) == 1) break; // input�� delimeter�� ��� �ݺ��� ����

		/* ST�� identifier �Է��ϱ� */
		int valid_identifier = 1; // ��ȿ�� identifier�̸� 1, �׷��� ������ 0
		while (isSeperator(input) != 1) {
			if (!isLetter(input) && (input != '_') && !isDigit(input))
				valid_identifier = 0; // ��ȿ���� ���� ���ڰ� �ִ� ��� flag�� 0���� ����

			if (nextfree >= STsize) { // ���� nextfree�� STsize �̻��� ���
				deleteIdentifier(); // ST�� ���ݱ��� �Էµ� identifier ����
				return; // �Լ� ����
			}

			length++; // identifier ���� + 1
			ST[nextfree++] = input; // input�� ST�� ���� �� nextfree + 1
			input = fgetc(fp); // ���ο� ���� �о����

			if (input == EOF) break;
		}

		/* identifier�� 12�� �̳��� �ƴ� ��� err ���� */
		if (length >= 13) {
			err = longid;
			break;
		}

		/* ��ȿ���� ���� identifier�� ��� err ���� */
		if (valid_identifier == 0) {
			err = illid;
			break;
		}
	}

	// ���� �޽��� ��� �� ���� ó��
	if (err != noerror) {
		PrintError(err); // ���� �޽��� ���
		deleteIdentifier(); // ST���� ��ȿ���� ���� identifier ����
		nextfree = nextid; // ���� ����
		input = fgetc(fp); // ���ο� ���� �о����
	}
}

// ComputeHS 	- Compute the hash code of identifier by summing the ordinal values of its
//			  characters and then taking the sum modulo the size of HT. 
void ComputeHS(int nid, int nfree)
{
	//�ε��� nid���� nfree ������ �ش��ϴ� ST�� ���� �о�ͼ� ������ ��, HT�� ũ��� ������, +1 �� ���� hashcode
	//hashcode�� ���������� ����Ǿ� ���� 

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
	//hashcode�� �ش��ϴ� HT�� ����Ʈ�� Ž���Ͽ� �ش� identifier�� �̹� HT�� �ִ��� ������ ���θ� �Ǵ�
	//�Ǵ� ����� found ������ ����

	found = 0;
	HTentry* node = HT[hscode]; // hascode�� �ش��ϴ� HT�� ����Ʈ�� ù��° ���
	while (node != NULL) {
		idx1 = node->index; // ���� HT[hscode]�� �����ϴ� identifier�� ù ������ ST �ε��� 
		idx2 = nid; // HT�� �߰��ϰ��� �ϴ� identifier�� ù ������ ST �ε���
		char ch1 = ST[idx1]; // ���� HT[hscode]�� �����ϴ� identifier�� ù ����
		char ch2 = ST[idx2]; // HT�� �߰��ϰ��� �ϴ� identifier�� ù ����
		int same = 0; // same�� 0�̸� ch1�� ch2�� ���� ���� �ǹ�, 1�̸� ���� �ǹ�

		while (ch1 != '\0' && ch2 != '\0') {
			if (ch1 == ch2) { // �� ���ڰ� ���� ���
				same = 1;
				ch1 = ST[++idx1]; // ���� ����
				ch2 = ST[++idx2]; // ���� ����
			}
			else { // �� ���ڰ� ���� ���� ���
				same = 0;
				break;
			}
		}

		if (same == 1) { // identifier�� �̹� HT�� �ִ� ���
			idx1 = node->index; // �̹� �����ϴ� identifier�� ST index�� ����
			found = 1;
			break;
		}
		node = node->next; // ���� ���
	}
}

// ADDHT	-	Add a new identifier to the hash table.
//			If list head ht[hashcode] is null, simply add a list element with
//			starting index of the identifier in ST.
//			IF list head is not a null , it adds a new identifier to the head of the chain ?
void ADDHT(int hscode)
{
	// ���ο� ��� ���� �� ����Ʈ�� head�� �� ��� ����
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
	PrintHeading(); // ��� �κ� �ܼ� ��� �Լ�
	initialize(); // �Է� ���� open && �Է� ���Ϸκ��� ù��° ���� �о�ͼ� input�� ����

	while (input != EOF) { // ������ ������ �ݺ�
		err = noerror; // err�� ���α׷� ���� ���� �߻��ϴ� ���� ������ ���� ����ϴ� ����. �ʱⰪ�� ���� �������� ����
		SkipSeperators(); // input���� �ϳ��� �о���µ�, delimiter�� ��� skip
		if (input == EOF) break; // seperator�� ������ ���� ���� ���, '\0'�� �ԷµǴ� ���� �����ϱ� ���� �ڵ�
		ReadID(); // ���� delimiter�� ��Ÿ�� ������ identifier �о����. �о� �� identifier�� ST�� ����
				  // nextid, nextfree ���� �� �� ����
		if (err == noerror) { // illegal identifier�� �ƴ� ��� hashcode ��� �� lookup
			if (nextfree >= STsize) { //nextid�� nextfree�� ST�� �ε���
				err = overst; // ST�� ���� overflow �߻�
				PrintError(err); // ���� ���
				break;
			}
			ST[nextfree++] = '\0'; // �׻� ���� �迭�� ������ �ι���

			ComputeHS(nextid, nextfree); // hashcode ��� (������ ���ǳ�Ʈ��)
			LookupHS(nextid, hashcode); // hashcode�� ComputeHS���� ���� �����
										// hashcode�� �ش��ϴ� ����Ʈ�� Ž��

			if (!found) { // LookupHS ���� ���, HT���� ã�� ���� found���� 0�� �ƴ� ������ ����
				// print messge
				printf("%-25d", nextid); // ST������ index ���
				PrintIdentifier(); // identifier ���
				printf("%s\n", "(entered)");

				ADDHT(hashcode); // ���ο� HTentry�� �߰�
			}
			else {
				// print message
				printf("%-25d", idx1); // ST������ index ���
				PrintIdentifier(); // identifier ���
				deleteIdentifier(); // ST���� �ش� identifier ����
				nextfree = nextid; // �ε��� ó��
				printf("%s\n", "(already existed)");
			}
		}
	}
	PrintHStable();
}

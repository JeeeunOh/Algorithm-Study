package unit10_사전;

import java.util.Arrays;
import java.util.Random;

public class 이진탐색ADT {
	static int SIZE = 15;
	static class element{
		int key;
		char[] value = new char[10];
		public element() {
			key=0;
			Arrays.fill(value, 'ㅁ');
		}
	}
	static class DictType{
		element[] dict = new element[SIZE];
		int size;
		public DictType() {
			Arrays.fill(dict, new element());
			size=0;
		}
	}
	static void insertKey(DictType d) {
		for(int i=0 ; i<SIZE ; i++) {
			Random ran = new Random();
			d.dict[i].key =  ran.nextInt(30); 
			for(int j=0 ; j<i ; j++) {
				if(d.dict[i].key == d.dict[j].key) i--; // key값이 중복되지 않게
			}
		}
	}
	
	static void insertValue(DictType d) {
		for(int i=0 ; i<SIZE ; i++) {
			for(int j=0 ; j<5 ; j++) { //다섯글자 입력받음 , 알파벳 아스키코드
				Random ran = new Random();
				d.dict[i].key =  ran.nextInt(26)+97; 
			}
			d.size++;
		}
	}
	static void printDict(DictType d) {
		System.out.println("key value");
		System.out.println("================");
		for(int i=0 ; i<d.size ; i++) {
			System.out.printf("%2d  ", d.dict[i].key);
			for(int j=0 ; j<5 ; j++)
				System.out.printf("%c\n", d.dict[i].value[j]);
		}
	}
	static void makeDict(DictType d) {
		insertKey(d);
		insertValue(d);
	}
	
	public static void main(String[] args) {
		DictType d = new DictType();
		makeDict(d);
		printDict(d);
	}

}

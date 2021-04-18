package unit05_우선순위큐;

import java.util.*;

// 선택정렬, 제자리정렬
// 제자리정렬 프린트가 안됨. 왜 인지 모름
public class 제자리정렬_수업 {
	static int MAX_SIZE = 15;
	static int[] list = new int[MAX_SIZE];

//선택정렬
static void selectionSort() { 
	int indexMin, temp; 
	for (int i = 0; i < list.length-1; i++) { 
		indexMin = i; 
		for (int j = i + 1; j < list.length; j++) { 
			if (list[j] < list[indexMin]) { 
				indexMin = j; 
				} 
			}  
		temp = list[indexMin]; 
		list[indexMin] = list[i]; 
		list[i] = temp;
		//for(int k= 0 ; k<MAX_SIZE ; k++) System.out.printf("%d ", list[k]);
		//System.out.println();
		} 
	return;
}

//삽입정렬 - 왜 안돼??
static void insertion_sort() {
	int i, j, save;
	for(i = 1; i < MAX_SIZE ; MAX_SIZE++) {
		save = list[i];
		j=i-1;
		while(j>=0 && list[j]>save) {
			list[j+1]=list[j];
			j--;
		}
		list[j+1]=save;
	}
	for(int k= 0 ; k<MAX_SIZE ; k++) System.out.printf("%d ", list[k]);
	return;
}

	public static void main(String[] args) {
		// 선택정렬
		for(int i = 0 ; i<MAX_SIZE ; i++) {
			Random ran = new Random();
			list[i] = ran.nextInt(MAX_SIZE)+1;
			for(int j = 0 ; j < i ; j++) {
				if(list[i] == list[j]) i--;
			}
		}
		for(int i = 0 ; i<MAX_SIZE ; i++) System.out.printf("%d ", list[i]);
		System.out.println();
		selectionSort();
		for(int i = 0 ; i<MAX_SIZE ; i++) System.out.printf("%d ", list[i]);
		System.out.println();
		
		// 삽입정렬
		for(int i = 0 ; i<MAX_SIZE ; i++) {
			Random ran = new Random();
			list[i] = ran.nextInt(MAX_SIZE)+1;
			for(int j = 0 ; j < i ; j++) {
				if(list[i] == list[j]) i--;
			}
		}
		for(int i = 0 ; i<MAX_SIZE ; i++) System.out.printf("%d ", list[i]);
		System.out.println();
		insertion_sort();
		for(int i = 0 ; i<MAX_SIZE ; i++) System.out.printf("%d ", list[i]);
		System.out.println();
	}
}

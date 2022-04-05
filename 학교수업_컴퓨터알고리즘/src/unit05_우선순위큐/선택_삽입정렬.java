package unit05_우선순위큐;

import java.util.*;

// 제자리정렬 - 선택정렬 삽입정렬

public class 선택_삽입정렬 {
	static int MAX_SIZE = 15;
	static int[] list = new int[MAX_SIZE];

//선택정렬; removemin, minKey, minElement에 유리
static void selectionSort() { 
	int indexMin, temp; 
	// 한 자리를 정해놓고 그 자리에 들어갈 최소값을 탐색해서
	// 자리의 숫자와 최솟값의 숫자를 교환함
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
		} 
	return;
}

//삽입정렬 : 초기리스트가 완전히 또는 거의 정렬된 경우 ; insertItem에 유리
static void insertion_sort() {
	int i, j, save;
	//배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열과 비교
	for(i = 1; i < MAX_SIZE ; i++) {
		save = list[i];
		j=i-1;
		while(j>=0 && list[j]>save) {
			// 해당 배열의 자리 찾아나감
			list[j+1]=list[j];
			j--;
		}
		// 자리 찾으면 집어넣음
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
		System.out.println("---선택정렬 전---");
		for(int i = 0 ; i<MAX_SIZE ; i++) System.out.printf("%d ", list[i]);
		System.out.println();
		
		System.out.println("---선택정렬 후---");
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
		System.out.println("---삽입정렬 전---");
		for(int i = 0 ; i<MAX_SIZE ; i++) System.out.printf("%d ", list[i]);
		System.out.println();
		
		System.out.println("---삽입정렬 후---");
		insertion_sort();
		System.out.println();
	}
}

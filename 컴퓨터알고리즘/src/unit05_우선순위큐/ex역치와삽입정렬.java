package unit05_우선순위큐;

import java.util.*;

// 선택정렬, 제자리정렬
// 제자리정렬 프린트가 안됨. 왜 인지 모름
public class ex역치와삽입정렬 {
	static int MAX_SIZE = 15;
	static int[] list = new int[MAX_SIZE];

//삽입정렬 
static int insertion_sort() {
	int i, j, save;
	int cnt=0;
	for(i = 1; i < MAX_SIZE ; i++) {
		save = list[i];
		j=i-1;
		while(j>=0 && list[j]<save) {
			list[j+1]=list[j];
			j--;
			cnt++;
			System.out.printf("%3d : ",  cnt);
			for(int k= 0 ; k<MAX_SIZE ; k++) {
				System.out.printf("%3d  ",  list[k]);
			}
			System.out.println();
		}
		list[j+1]=save;
	}
	
	for(int k= 0 ; k<MAX_SIZE ; k++) System.out.printf("%d ", list[k]);
	return cnt;
}

	public static void main(String[] args) {
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
		int cnt = insertion_sort();
		System.out.println();
		System.out.printf("%d번의 연산이 필요하다.", cnt);
	}
}

package unit05_우선순위큐;

import java.util.*;

// 선택정렬, 제자리정렬

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
			// 기준이 되는 i 바로 전부터 배열 처음까지 탐색하는데 이때 list[j]<save일때 계속 list[j]를 list[j+1]로 옮기면서 save의 자리를 찾는다.
			list[j+1]=list[j];
			j--;
			cnt++;
		}
		list[j+1]=save; //자리를 찾아서 while문을 빠져나오면 save를 해당자리에 저장한다.
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

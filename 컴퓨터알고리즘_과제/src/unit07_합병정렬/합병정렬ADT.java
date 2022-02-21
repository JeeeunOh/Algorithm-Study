package unit07_합병정렬;
//ex. 배열에 대한 합병 정렬
import java.util.Random;

// 분할 -> 재귀 -> 통치
public class 합병정렬ADT {
	static int MAX_SIZE =15;
	static int[] sorted = new int[MAX_SIZE];
	
	static void merge(int[] list, int left, int mid, int right) {
		int i = left; // 앞 배열의 시작
		int j = mid+1; // 뒤 배열의 시작
		int k = left; // k에 앞 배열의 시작 저장
		int l;
		
		while(i<=mid && j <=right) {
			if(list[i]<=list[j]) sorted[k++] = list[i++]; //list[i]가 앞부분인지 list[j]가 앞부분인지 판별 후 머지
			else sorted[k++] = list[j++];
		}
		
		if(i>mid)  for(l = j ; l<=right ; l++) sorted[k++] = list[l];// j~ right를 앞에 저장
		else  for(l=i ; l<=mid ; l++) sorted[k++] = list[l]; // i~right을 저장
		
		for(l=left ; l<=right ; l++) list[l] = sorted[l]; // 최종 머지된 배열을 list로 갱신해줌
	}
	
	static void merge_sort(int[] list, int left, int right) {
		int mid;
		if(left<right) {
			mid = (left+right)/2;
			merge_sort(list, left, mid);
			merge_sort(list, mid+1, right);
			merge(list, left, mid, right);
		}
	}
	
	public static void main(String[] args) {
		int[] list = new int[MAX_SIZE];
		for(int i=0 ; i<MAX_SIZE ; i++) {
			Random ran = new Random();
			list[i] = ran.nextInt(100)+1; 
			for (int j=0 ; j < i ; j++)
				if(list[i] == list[j]) i--;
		}
		for (int i=0 ; i<MAX_SIZE ; i++)
			System.out.printf("[%d] ", list[i]);
		System.out.println(); // 정렬되지 않은 배열 생성됨
		
		merge_sort(list, 0, MAX_SIZE-1);
		
		for (int i=0 ; i<MAX_SIZE ; i++) 
			System.out.printf("[%d] ", list[i]);
		System.out.println(); // 정렬된 배열 생성
	}
}

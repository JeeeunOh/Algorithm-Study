package unit08_퀵정렬;
// 분할정복기법과 재귀알고리즘 이용 정렬 알고리즘
// 오류남, 왜?????????? m-> 해결
import java.util.Random;

public class 퀵정렬ADT {
	static int MAX_SIZE = 10;
	static int[] list = new int[MAX_SIZE];
	
	static void SWAP(int x, int y) {
		int t = list[x];
		list[x] = list[y];
		list[y]  = t;
		for (int i=0 ; i<MAX_SIZE ; i++) System.out.printf("[%d] ", list[i]);
		System.out.println();
	}
	
	/*static int partition(int left, int right) { // 교수님 코드, 이렇게 하면 배열크기초과 오류남
		int pivot, temp, low, high;
		low = left; 
		high = right+1;
		pivot = list[left];
		do {
			do {
				low++;
			}while(list[low] < pivot);
			
			do {
				high--;
			} while(list[high]>pivot);
			
			if(low<high) SWAP(low, high);
		} while(low < high);
		
		SWAP(left, right);
		
		return high;
		}*/
	
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];

		while (left < right) {
			while ((arr[left] < pivot) && (left < right)) left++;
			while ((arr[right] > pivot) && (left < right)) right--;
			if (left < right) SWAP(left, right); 
		}
		return left;
    }
	
	static void quick_sort(int[] list,  int left, int right) {
		if(left < right) {
			int q = partition(list, left, right);
			quick_sort(list, left, q-1);
			quick_sort(list, q+1, right); // q는 계산 되었으니 빠져야한다.
		}
	} // 퀵정렬
	
	public static void main(String[] args) {
		for(int i=0 ; i<MAX_SIZE ; i++) {
			Random ran = new Random();
			list[i] = ran.nextInt(MAX_SIZE); 
			for (int j=0 ; j < i ; j++)
				if(list[i] == list[j]) i--;
		} // 리스트에 중복x값 집어넣음
		for (int i=0 ; i<MAX_SIZE ; i++)
			System.out.printf("[%d] ", list[i]);
		System.out.println();
		
		quick_sort(list, 0, MAX_SIZE-1);
		
		for (int i=0 ; i<MAX_SIZE ; i++) System.out.printf("[%d] ", list[i]);
		
	}

}

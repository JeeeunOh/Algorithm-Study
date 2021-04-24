package unit08_퀵정렬;
// 분할정복기법과 재귀알고리즘 이용 정렬 알고리즘
// 오류남, 왜??????????
import java.util.Random;

public class ex색분리{
	static int MAX_SIZE = 10;
	
	static int partition(int arr[], int left, int right) {

		int pivot = arr[(left + right) / 2];

		while (left < right) {
			while ((arr[left] < pivot) && (left < right)) left++;
			while ((arr[right] > pivot) && (left < right)) right--;

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		return left;
	}

	static void quickSort(int arr[], int left, int right) {

		if (left < right) {
			int pivotNewIndex = partition(arr, left, right);
			quickSort(arr, left, pivotNewIndex - 1);
			quickSort(arr, pivotNewIndex + 1, right);
		}

	}
	
	public static void main(String[] args) {
		int[] list = new int[MAX_SIZE];
		for(int i=0 ; i<MAX_SIZE ; i++) {
			Random ran = new Random();
			list[i] = ran.nextInt(2); 
			for (int j=0 ; j < i ; j++)
				if(list[i] == list[j]) i--;
		} // 리스트에 중복x값 집어넣음
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		quickSort(list, 0, MAX_SIZE-1);
		
		System.out.printf("결과 : ");

		for (int i : list) {
			System.out.print(i + " ");
		}
		
	}

}

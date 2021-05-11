package unit08_퀵정렬;
// 분할정복기법과 재귀알고리즘 이용 정렬 알고리즘
// 오류남, 왜??????????
import java.util.Random;

public class 퀵정렬_구글링{
	
	static int MAX_SIZE = 10;
	
	static int partition(int arr[], int left, int right) { // 0 이 빨강, 1이 파랑
		while (left < right) {
			while ((arr[left] !=0) && (left < right)) left++;
			while ((arr[right] !=1) && (left < right)) right--;
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
		list[0]=0;list[1]=1;
		list[2]=0;list[3]=1;
		list[4]=0;list[5]=1;
		list[6]=0;list[7]=1;
	list[8]=0;list[9]=1; // 0 이 빨강, 1이 파랑
		
		for (int i : list ) System.out.print(i + " "); 
		System.out.println();
		
		quickSort(list, 0, MAX_SIZE-1);
		
		System.out.printf("결과 : ");
		for (int i : list) System.out.print(i + " "); 
		
	}
}

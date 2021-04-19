package unit08_������;
// ������������� ��;˰��� �̿� ���� �˰���
// ������, ��??????????
import java.util.Random;

public class ������_���۸�{
	static int MAX_SIZE = 10;
	
	static int partition(int arr[], int left, int right) {

		int pivot = arr[(left + right) / 2];

		while (left < right) {
			while ((arr[left] < pivot) && (left < right))
				left++;
			while ((arr[right] > pivot) && (left < right))
				right--;

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
			list[i] = ran.nextInt(MAX_SIZE); 
			for (int j=0 ; j < i ; j++)
				if(list[i] == list[j]) i--;
		} // ����Ʈ�� �ߺ�x�� �������
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		quickSort(list, 0, MAX_SIZE-1);
		
		System.out.printf("��� : ");

		for (int i : list) {
			System.out.print(i + " ");
		}
		
	}

}

package unit08_������;
// ������������� ��;˰��� �̿� ���� �˰���
// ������, ��??????????
import java.util.Random;

public class ���ڸ������� {
	static int MAX_SIZE = 10;
	
	static void SWAP(int[] list, int x, int y) {
		int t = list[x];
		list[x] = list[y];
		list[y]  = t;
		for (int i=0 ; i<MAX_SIZE ; i++)
			System.out.printf("[%d] ", list[i]);
		System.out.println();
	}
	
	static int partition(int[] list, int left, int right, int k) { // ������ �ڵ�, �̷��� �ϸ� �迭ũ���ʰ� ������
		int pivot, temp, low, high;
		pivot = list[k];
	
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
		}
	
	static void quick_sort(int[] list,  int left, int right) {
		if(left < right) {
			Random ran = new Random();
			int k =  ran.nextInt(right-left)+ left + 1; 
			int q = partition(list, left, right, k);
			quick_sort(list, left, q-1);
			quick_sort(list, q+1, right); // q�� ��� �Ǿ����� �������Ѵ�.
		}
	} // ������
	
	public static void main(String[] args) {
		int[] list = new int[MAX_SIZE];
		for(int i=0 ; i<MAX_SIZE ; i++) {
			Random ran = new Random();
			list[i] = ran.nextInt(MAX_SIZE); 
			for (int j=0 ; j < i ; j++)
				if(list[i] == list[j]) i--;
		} // ����Ʈ�� �ߺ�x�� �������
		for (int i=0 ; i<MAX_SIZE ; i++)
			System.out.printf("[%d] ", list[i]);
		System.out.println();
		
		quick_sort(list, 0, MAX_SIZE-1);
		
		for (int i=0 ; i<MAX_SIZE ; i++) System.out.printf("[%d] ", list[i]);
		
	}

}

package unit08_������;
// ������������� ��;˰��� �̿� ���� �˰���
// ������, ��??????????
import java.util.Random;

public class ������ADT {
	static int MAX_SIZE = 10;
	
	static void SWAP(int[] list, int x, int y) {
		int t = list[x];
		list[x] = list[y];
		list[y]  = t;
		for (int i=0 ; i<MAX_SIZE ; i++)
			System.out.printf("[%d] ", list[i]);
		System.out.println();
	}
	
	/*static int partition(int left, int right) { // ������ �ڵ�, �̷��� �ϸ� �迭ũ���ʰ� ������
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
	
	private static int partition(int[] list, int low, int high) {
        int pivot = list[(low + high) / 2];
        while (low <= high) {
            while (list[low] < pivot) low++;
            while (list[high] > pivot) high--;
            if (low <= high) {
                SWAP(list, low, high);
                low++;
                high--;
            }
        }
        return low;
    }
	
	static void quick_sort(int[] list,  int left, int right) {
		if(left < right) {
			int q = partition(list, left, right);
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

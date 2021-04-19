package unit06_����������;
//�ּ��� ; �ּҰ��� ��Ʈ, �ִ��� : �ִ밪�� ��Ʈ
//���⼱ �ּ��� ����
public class ��ADT {
	static int MAX_ELEMENT = 100;
	static class Heap{
		int[] arr = new int[MAX_ELEMENT];
		int size;
	}
	static void init(Heap h) {
		h.size=0;
	}
	static void upHeap(Heap h) {
		int i = h.size;
		int key = h.arr[i]; // ���� ������
		while((i!=1)&&(key<h.arr[i/2])) { // i�� ���� �� ���Ұ� �ƴϰ�, key�� i�� �θ𺸴� ������
			h.arr[i] = h.arr[i/2]; // i�� �θ��� i��
			i/=2; //i�� �θ�� �ö�
		}
		h.arr[i] = key;
	}
	static void insertItem(Heap h, int key) {
		h.size++;
		h.arr[h.size] = key;
		upHeap(h);
	}
	static void printHeap(Heap h) {
		for (int i = 1; i <= h.size; i++) {
			System.out.printf("[%d] ", h.arr[i]);
		}
		System.out.println();
	}
	
	static void downHeap(Heap h) {
		int temp = h.arr[1];
		int parent = 1, child=2;
		while(child<=h.size) {
			if(child<h.size && h.arr[child] > h.arr[child+1]) child++;
			if(temp <= h.arr[child]) break;
			h.arr[parent] = h.arr[child];
			parent = child;
			child*=2;
		}
		h.arr[parent]=temp;
	}
	static int removeMin(Heap h) {
		int key = h.arr[1];
		h.arr[1]=h.arr[h.size];
		h.size--;
		downHeap(h);
		return key;
	}
	
	public static void main(String[] args) {
		Heap h = new Heap();
		init(h);
		insertItem(h, 2);
		insertItem(h, 20);
		insertItem(h, 4);
		insertItem(h,14);
		insertItem(h, 7);
		insertItem(h, 12);
		insertItem(h, 8);
		insertItem(h,17);
		insertItem(h,15);
		insertItem(h, 9);
		printHeap(h);
		System.out.printf("%d",removeMin(h));
	}

}

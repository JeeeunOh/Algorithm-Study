package unit06_����������;

import java.util.Random;

//
// ���ڸ� �� ������ heap sort�� ���� ����� ���δ�, ���ĵ� ����Ʈ�� �迭�� �־��� ��쿡�� �ش�
//����� �� ������ heap sort�� �ӵ��� ���δ�.
//�̰� ���ڸ� �� ����
public class ���ڸ������� {
	static int MAX_ELEMENT = 15;
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
	
	//���ڸ� �� ���� �˰���	
	static void inPlaceHeapSort(Heap h) {
		int size = h.size;
		int key;
		for(int i = 0 ; i<size ; i++) {
			key = removeMin(h);
			h.arr[h.size+1] = key;
		}
	}
	
	public static void main(String[] args) {
		Heap h = new Heap();
		int[] list = new int[MAX_ELEMENT];
		
		init(h);
		for(int i = 1 ; i<MAX_ELEMENT ; i++) {
			Random ran = new Random();
			insertItem(h,ran.nextInt(100)+1);
		}
		printHeap(h);
		inPlaceHeapSort(h);
		for(int i = 1 ; h.arr[i]>0; i++) { //���⼭ �� ������ �߻��ұ�
			System.out.printf("[%d] ", h.arr[i]);
			}
		System.out.println();
	}

}

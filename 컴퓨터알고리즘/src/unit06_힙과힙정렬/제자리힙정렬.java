package unit06_힙과힙정렬;

import java.util.Random;

//
// 제자리 힙 정렬은 heap sort의 공간 사용을 줄인다, 정렬될 리스트가 배열로 주어진 경우에만 해당
//상향식 힙 생성은 heap sort의 속도를 높인다.
//이건 제자리 힙 정렬
public class 제자리힙정렬 {
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
		int key = h.arr[i]; // 제일 마지막
		while((i!=1)&&(key<h.arr[i/2])) { // i가 제일 위 원소가 아니고, key가 i의 부모보다 작을때
			h.arr[i] = h.arr[i/2]; // i의 부모값은 i임
			i/=2; //i의 부모로 올라감
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
	
	//제자리 힙 정렬 알고리즘	
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
		for(int i = 1 ; h.arr[i]>0; i++) { //여기서 왜 오류가 발생할까
			System.out.printf("[%d] ", h.arr[i]);
			}
		System.out.println();
	}

}

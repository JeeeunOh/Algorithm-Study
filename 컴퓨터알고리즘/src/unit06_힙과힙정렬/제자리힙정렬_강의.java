package unit06_힙과힙정렬;
// 강의자료대로 교수님이 짜주신것
import java.util.*;

import unit06_힙과힙정렬.제자리힙정렬.Heap;

public class 제자리힙정렬_강의 {
	static int MAX_ELEMENT = 100;
	static Heap h = new Heap();
	static class Heap{
		int[] H = new int[MAX_ELEMENT];
		int n;
	}
	
	static void downHeap(int i) {
		if(i*2>h.n) return;
		if(h.H[i] <h.H[i*2] || h.H[i] <h.H[i*2+1]) {
			if(h.H[i*2] >= h.H[i*2+1]) {
				int temp;
				temp = h.H[i];
				h.H[i] = h.H[i*2];
				h.H[i*2]=temp;
				downHeap(i*2);
			} else {
				int temp;
				temp = h.H[i];
				h.H[i] = h.H[i*2+1];
				h.H[i*2+1]=temp;
				downHeap(i*2+1);
			}
		}
		else return;
	}
	
	static void buildHeap() {
		for(int i = h.n/2 ; i>=1 ; i--)
			downHeap(i);
	}
	
	static int removeMax() {
		int key = h.H[1];
		h.H[1]=h.H[h.n--];
		downHeap(1);
		return key;
	}
	
	static void inPlaceHeapSort() {
		int size = h.n;
		int key;
		for(int i = 0 ; i<size ; i++) {
			key = removeMax();
			h.H[h.n+1] = key;
		}
	}
	
	static void printHeap() {
		for (int i = 1; i <= h.n; i++) {
			System.out.printf("[%d] ", h.H[i]);
		}
		System.out.println();
	}
	
	static void printArray() {
		for (int i = 1;h.H[i]>0; i++) {
			System.out.printf("[%d] ", h.H[i]);
		}
		System.out.println();
	}
	
	static void rBuildHeap(int i) {
		if(i>h.n) return;
		if(i*2 <=h.n) rBuildHeap(2*i);
		if(i*2+1 <=h.n) rBuildHeap(2*i+1);
		downHeap(i);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		h.n =0;
		System.out.println(" 입력할 원소의 개수 : ");
		h.n = sc.nextInt();
		for(int i = 1 ; i<= h.n ; i++) {
			Random ran = new Random();
			h.H[i] = ran.nextInt(100)+1;
		}
		//buildHeap();
		rBuildHeap(1); // 위의 것과 이것 모두 정렬
		printHeap();
		inPlaceHeapSort();
		printArray();
	}

}

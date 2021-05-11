package unit06_힙과힙정렬;
// 강의자료대로 교수님이 짜주신것
// 리스트가 배열인 경우에만 사용
// 최대힙 사용
import java.util.*;

public class 제자리힙정렬_강의 {
	static int MAX_ELEMENT = 100;
	static Heap h = new Heap();
	static class Heap{
		int[] H = new int[MAX_ELEMENT];
		int n;
	}
	
	static void downHeap(int i) { // 상향식 힙 생성-> 1기 작업
		if(i*2>h.n) return; // 자식 인덱스가 존재하지 않으면 return
		if(h.H[i] <h.H[i*2] || h.H[i] <h.H[i*2+1]) { 
			if(h.H[i*2] >= h.H[i*2+1]) {// 왼쪽자식이 더 크면
				int temp;
				temp = h.H[i];
				h.H[i] = h.H[i*2];
				h.H[i*2]=temp; // 왼쪽 자식과 자신 바꾸고
				downHeap(i*2); // 재귀
			} else {// 오른쪽자식이 더 크면
				int temp;
				temp = h.H[i];
				h.H[i] = h.H[i*2+1];
				h.H[i*2+1]=temp; // 오른쪽 자식과 자신 바꿈
				downHeap(i*2+1);
			}
		}
		else return;
	}
	
	static void buildHeap() {  // i를 직접 바꿔가면서 재배열 ; 2기 작업
		for(int i = h.n/2 ; i>=1 ; i--) // 비재귀적 상향식 힙생성
			downHeap(i);
	}
	static void rBuildHeap(int i) { // 자식으로 내려가면서 재배열 ; 2기 작업
		if(i>h.n) return; // 재귀적 상향식 힙생성
		if(i*2 <=h.n) rBuildHeap(2*i);
		if(i*2+1 <=h.n) rBuildHeap(2*i+1);
		downHeap(i);
	}
	
	static int removeMax() { // 제일 위 키 반납한 후
		int key = h.H[1];
		h.H[1]=h.H[h.n--]; // 제일 밑 키를 제일 위로 끌어올리고
		downHeap(1); // 해당 키 기준 down힙 통해 재정렬한다.
		return key; // 맨 처음에 저장했던 제일 위 키 반납
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

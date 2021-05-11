package unit06_����������;
// �����ڷ��� �������� ¥�ֽŰ�
// ����Ʈ�� �迭�� ��쿡�� ���
// �ִ��� ���
import java.util.*;

public class ���ڸ�������_���� {
	static int MAX_ELEMENT = 100;
	static Heap h = new Heap();
	static class Heap{
		int[] H = new int[MAX_ELEMENT];
		int n;
	}
	
	static void downHeap(int i) { // ����� �� ����-> 1�� �۾�
		if(i*2>h.n) return; // �ڽ� �ε����� �������� ������ return
		if(h.H[i] <h.H[i*2] || h.H[i] <h.H[i*2+1]) { 
			if(h.H[i*2] >= h.H[i*2+1]) {// �����ڽ��� �� ũ��
				int temp;
				temp = h.H[i];
				h.H[i] = h.H[i*2];
				h.H[i*2]=temp; // ���� �ڽİ� �ڽ� �ٲٰ�
				downHeap(i*2); // ���
			} else {// �������ڽ��� �� ũ��
				int temp;
				temp = h.H[i];
				h.H[i] = h.H[i*2+1];
				h.H[i*2+1]=temp; // ������ �ڽİ� �ڽ� �ٲ�
				downHeap(i*2+1);
			}
		}
		else return;
	}
	
	static void buildHeap() {  // i�� ���� �ٲ㰡�鼭 ��迭 ; 2�� �۾�
		for(int i = h.n/2 ; i>=1 ; i--) // ������� ����� ������
			downHeap(i);
	}
	static void rBuildHeap(int i) { // �ڽ����� �������鼭 ��迭 ; 2�� �۾�
		if(i>h.n) return; // ����� ����� ������
		if(i*2 <=h.n) rBuildHeap(2*i);
		if(i*2+1 <=h.n) rBuildHeap(2*i+1);
		downHeap(i);
	}
	
	static int removeMax() { // ���� �� Ű �ݳ��� ��
		int key = h.H[1];
		h.H[1]=h.H[h.n--]; // ���� �� Ű�� ���� ���� ����ø���
		downHeap(1); // �ش� Ű ���� down�� ���� �������Ѵ�.
		return key; // �� ó���� �����ߴ� ���� �� Ű �ݳ�
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
		System.out.println(" �Է��� ������ ���� : ");
		h.n = sc.nextInt();
		for(int i = 1 ; i<= h.n ; i++) {
			Random ran = new Random();
			h.H[i] = ran.nextInt(100)+1;
		}
		//buildHeap();
		rBuildHeap(1); // ���� �Ͱ� �̰� ��� ����
		printHeap();
		
		inPlaceHeapSort();
		printArray();
	}

}

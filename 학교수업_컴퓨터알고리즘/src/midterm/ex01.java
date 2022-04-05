package midterm;

import java.util.*;

public class ex01 {
	static class DListNode{ //���
		int elem=0;
		DListNode prev, next;
	}
	static class  SetType{ //����Ʈ
		DListNode H = new DListNode(); // ���
		DListNode T = new DListNode(); // ������
	}
	static void addLast(SetType st, int data) { // ������ �߰�
		DListNode newNode = new DListNode();
		newNode.elem = data;
		newNode.next=newNode.next = null;
		
		if(st.H == null) {
			st.H = newNode;
			newNode.next = st.T;
		} else if(st.H!=null) { // head�� null�� �ƴ� ���
			if(st.T == null) {
				st.T = newNode;
				newNode.prev = st.H;
			} else {
				st.T.next = newNode;
				st.T = newNode;
				newNode.prev = st.T;
			}
        }
	}

	static void initNode(DListNode H, DListNode T){
		H.next = T;
		T.prev = H;
	}
	static void initSet(SetType st){ // ���Ḯ��Ʈ �ʱ�ȭ
		st.H=null;
		st.T = null;
		}
	static void printList(SetType ss) {
	   DListNode now = ss.H; // tempNode�� head�� ����Ű�� ù��° ��带 �Ҵ�
        // tempNode�� null�� �ƴ� ������ �ݺ��Ͽ� ���
        while(now != null) {
            System.out.print(now.elem+ " ");
            now = now.next;    // temp ��忡 ���� ���(tempNode.link) �Ҵ�.
        }
    }
	
	static int[] selectionSort(int[] list) { //��������
		int indexMin, temp; 
		// �� �ڸ��� ���س��� �� �ڸ��� �� �ּҰ��� Ž���ؼ�
		// �ڸ��� ���ڿ� �ּڰ��� ���ڸ� ��ȯ��
		for (int i = 0; i < list.length-1; i++) { 
			indexMin = i; 
			for (int j = i + 1; j < list.length; j++) { 
				if (list[j] < list[indexMin]) { 
					indexMin = j; 
					} 
				}  
			temp = list[indexMin]; 
			list[indexMin] = list[i]; 
			list[i] = temp;
			} 
		System.out.print("�������� : ");
		for(int k= 0 ; k<SIZE ; k++) System.out.printf("%d ", list[k]);
		
		return list;
	}
	
	static int[] insertion_sort(int[] list) {
		int i, j, save;
		//�迭�� ��� ��Ҹ� �տ������� ���ʴ�� �̹� ���ĵ� �迭�� ��
		for(i = 1; i < SIZE ; i++) {
			save = list[i];
			j=i-1;
			while(j>=0 && list[j]>save) {
				// �ش� �迭�� �ڸ� ã�Ƴ���
				list[j+1]=list[j];
				j--;
			}
			// �ڸ� ã���� �������
			list[j+1]=save;
		}
		
		System.out.print("�������� : ");
		for(int k= 0 ; k<SIZE ; k++) System.out.printf("%d ", list[k]);
		return list;
	}
	
	static void ������(int[] A, int[] B){ // ������
		int[] ans = new int[2*SIZE];
		int k=SIZE;
		for(int i = 0 ; i < SIZE  ; i++) ans[i]= A[i];
				for(int i = 0 ; i < SIZE  ; i++) {
					for(int j=0 ; j<SIZE  ; j++) {
						if(B[i]==A[j]) break;
						if(j==SIZE -1) {
							ans[k]=B[i];
							k++; }
					}
				}
				System.out.print("A�� B�� ������ : ");
				for(int i = 0 ; i < k ; i++) System.out.printf("%d ", ans[i]);
				System.out.println();
	}
	static void ������(int[] A, int[] B){ // ������
		int[] ans = new int[2*SIZE];
	    int k=0;
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				if(A[i] ==B[j]) break;
				if(j==4) {
					ans[k] = A[i];
					k++;
				}
			}
		}
		System.out.print("A�� B�� ������ : ");
		for(int i = 0 ; i < k ; i++) System.out.printf("%d ", ans[i]);
		System.out.println();
	}
	
	
	static int SIZE = 10;
	static SetType s1 = new SetType(); // ó���� ������ ����Ʈ
	static SetType s2 = new SetType(); // ���ĵ� ����Ʈ

	public static void main(String[] args) {
		initNode(s1.H, s1.T);
		initSet(s1);
		initNode(s2.H, s2.T);
		initSet(s2);
		int[] listA = new int[SIZE];
		int[] listB = new int[SIZE];
		
		for(int i = 0 ; i< SIZE ; i++) { // s1�� ����
			Random ran = new Random();
			int data = ran.nextInt(40)+1;
			if(data<11) {
				i--;continue; // �ٽ� ����
			}
			addLast(s1, data); // ���⼭ ����
			listA[i] = data; // ����Ʈ�� ������ ����
		}
		printList(s1); //s1 ����
		System.out.println();
		
		for(int i = 0 ; i< SIZE ; i++) { // s2�� ����
			Random ran = new Random();
			int data = ran.nextInt(40)+1;
			if(data<11) {
				i--;continue; // �ٽ� ����
			}
			addLast(s2, data); // ���⼭ ����
			listB[i] = data; // ����Ʈ�� ������ ����
		}
		printList(s2); //s2 ����
		System.out.println();
		
		listA = selectionSort(listA); //  ����Ʈ ��������
		System.out.println();
	    listB = insertion_sort(listB); //  ����Ʈ ��������
	    System.out.println();
	    
	    ������(listA, listB);
	    ������(listA, listB); // �����հ� ������
	}
}







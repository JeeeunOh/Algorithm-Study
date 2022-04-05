package midterm;

import java.util.*;

public class ex01 {
	static class DListNode{ //노드
		int elem=0;
		DListNode prev, next;
	}
	static class  SetType{ //리스트
		DListNode H = new DListNode(); // 헤드
		DListNode T = new DListNode(); // 마지막
	}
	static void addLast(SetType st, int data) { // 데이터 추가
		DListNode newNode = new DListNode();
		newNode.elem = data;
		newNode.next=newNode.next = null;
		
		if(st.H == null) {
			st.H = newNode;
			newNode.next = st.T;
		} else if(st.H!=null) { // head가 null이 아닌 경우
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
	static void initSet(SetType st){ // 연결리스트 초기화
		st.H=null;
		st.T = null;
		}
	static void printList(SetType ss) {
	   DListNode now = ss.H; // tempNode에 head가 가리키는 첫번째 노드를 할당
        // tempNode가 null이 아닐 때까지 반복하여 출력
        while(now != null) {
            System.out.print(now.elem+ " ");
            now = now.next;    // temp 노드에 다음 노드(tempNode.link) 할당.
        }
    }
	
	static int[] selectionSort(int[] list) { //선택정렬
		int indexMin, temp; 
		// 한 자리를 정해놓고 그 자리에 들어갈 최소값을 탐색해서
		// 자리의 숫자와 최솟값의 숫자를 교환함
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
		System.out.print("선택정렬 : ");
		for(int k= 0 ; k<SIZE ; k++) System.out.printf("%d ", list[k]);
		
		return list;
	}
	
	static int[] insertion_sort(int[] list) {
		int i, j, save;
		//배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열과 비교
		for(i = 1; i < SIZE ; i++) {
			save = list[i];
			j=i-1;
			while(j>=0 && list[j]>save) {
				// 해당 배열의 자리 찾아나감
				list[j+1]=list[j];
				j--;
			}
			// 자리 찾으면 집어넣음
			list[j+1]=save;
		}
		
		System.out.print("삽입정렬 : ");
		for(int k= 0 ; k<SIZE ; k++) System.out.printf("%d ", list[k]);
		return list;
	}
	
	static void 합집합(int[] A, int[] B){ // 합집합
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
				System.out.print("A와 B의 합집합 : ");
				for(int i = 0 ; i < k ; i++) System.out.printf("%d ", ans[i]);
				System.out.println();
	}
	static void 차집합(int[] A, int[] B){ // 차집합
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
		System.out.print("A와 B의 차집합 : ");
		for(int i = 0 ; i < k ; i++) System.out.printf("%d ", ans[i]);
		System.out.println();
	}
	
	
	static int SIZE = 10;
	static SetType s1 = new SetType(); // 처음에 생성한 리스트
	static SetType s2 = new SetType(); // 정렬된 리스트

	public static void main(String[] args) {
		initNode(s1.H, s1.T);
		initSet(s1);
		initNode(s2.H, s2.T);
		initSet(s2);
		int[] listA = new int[SIZE];
		int[] listB = new int[SIZE];
		
		for(int i = 0 ; i< SIZE ; i++) { // s1에 저장
			Random ran = new Random();
			int data = ran.nextInt(40)+1;
			if(data<11) {
				i--;continue; // 다시 설정
			}
			addLast(s1, data); // 여기서 오류
			listA[i] = data; // 리스트에 데이터 저장
		}
		printList(s1); //s1 생성
		System.out.println();
		
		for(int i = 0 ; i< SIZE ; i++) { // s2에 저장
			Random ran = new Random();
			int data = ran.nextInt(40)+1;
			if(data<11) {
				i--;continue; // 다시 설정
			}
			addLast(s2, data); // 여기서 오류
			listB[i] = data; // 리스트에 데이터 저장
		}
		printList(s2); //s2 생성
		System.out.println();
		
		listA = selectionSort(listA); //  리스트 선택정렬
		System.out.println();
	    listB = insertion_sort(listB); //  리스트 삽입정렬
	    System.out.println();
	    
	    합집합(listA, listB);
	    차집합(listA, listB); // 합집합과 차집합
	}
}







package unit04_기본추상자료형;
// 구현 해주심
public class ex기간 {
	static int SIZE = 6;
	static int[] X = new int[SIZE];
	static int[] S = new int[SIZE];
	 static Stack st = new Stack();
	//--------------------------- 여기서부터 스택 구현 시작----------------------------
	static class Node{
		int item ;
		Node next;
	}
	static class Stack{
		Node top;
		int size;
	}
	//초기화
	static void init () {
		st.top=null;
		st.size=0;
	}
	//push
	static void push(int n) {
		Node newNode = new Node();
		newNode.item = n;
		newNode.next = st.top; // 새로운 노드 다음 노드가 스택 젤 위
		st.top = newNode; // 스택 젤 위는 새로운 노드
		st.size++;
	}
	//pop
	static void pop() {
		int result;
		Node tmp;
		if(isEmpty()) {
			System.out.println("Empty");
			return;
		}
		tmp = st.top;
		result = tmp.item;
		st.top =tmp.next;
		st.size--;
	}
	//printAll
	static void printAll() {
		Node i;
		i=st.top;
		if(i==null) {
			System.out.println();
			return;
		}
		while(i!=null) {
			System.out.printf("%d ", i.item);
			i=i.next;
		}
	}
	//isEmpty
	static boolean isEmpty() {
		return st.top==null;
	}
	//getSize
	static int getSize() {
		return st.size;
	}
	//top
	static int top() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			return -1;
		}
		return st.top.item;
	}
	//--------------------------- 여기까지 스택 구현----------------------------
	static void spans() { // 정의 적용
		int s;
		for(int i = 0 ; i<SIZE ; i++) {
			s = 1;
			while((s<=i) && (X[i-s] <=X[i])) s++;
			S[i] = s;
		}
	}
	static void spans2() { // 스택 사용
		init();
		for (int i = 0 ; i<SIZE ; i++) {
			while(!isEmpty() && (X[top()]<=X[i])) pop();
			if(isEmpty()) S[i]=i+1;
			else S[i] = i-top();
			push(i);
		}
		while(isEmpty()) pop();
		return;
	}
	
	public static void main(String[] args) {
		X[0]=6; X[1]=3;
		X[2]=4; X[3]=2;
		X[4]=5; X[5]=3;
		
		spans();
		for(int i = 0 ; i < SIZE ; i++) System.out.printf("[%d] ", S[i]); 
		System.out.println();
		
		X[0]=6; X[1]=3;
		X[2]=4; X[3]=2;
		X[4]=5; X[5]=3;
		spans2();
		for(int i = 0 ; i < SIZE ; i++)  System.out.printf("[%d] ", S[i]); 
		System.out.println();
	}
}

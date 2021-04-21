package unit04_�⺻�߻��ڷ���;
// ���� ���ֽ�
public class ex�Ⱓ {
	static int SIZE = 6;
	static int[] X = new int[SIZE];
	static int[] S = new int[SIZE];
	 static Stack st = new Stack();
	//--------------------------- ���⼭���� ���� ���� ����----------------------------
	static class Node{
		int item ;
		Node next;
	}
	static class Stack{
		Node top;
		int size;
	}
	//�ʱ�ȭ
	static void init () {
		st.top=null;
		st.size=0;
	}
	//push
	static void push(int n) {
		Node newNode = new Node();
		newNode.item = n;
		newNode.next = st.top;
		st.top = newNode;
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
	//--------------------------- ������� ���� ����----------------------------
	static void spans() { // ���� ����
		int s;
		for(int i = 0 ; i<SIZE ; i++) {
			s = 1;
			while((s<=i) && (X[i-s] <=X[i])) s++;
			S[i] = s;
		}
	}
	static void spans2() { // ���� ���
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
		X[0]=6;
		X[1]=3;
		X[2]=4;
		X[3]=2;
		X[4]=5;
		X[5]=3;
		
		spans();
		for(int i = 0 ; i < SIZE ; i++) {
			System.out.printf("[%d] ", S[i]);
		}
		System.out.println();
		
		spans2();
		for(int i = 0 ; i < SIZE ; i++) {
			System.out.printf("[%d] ", S[i]);
		}
		System.out.println();

	}

}

package unit04_기본추상자료형;
// 이중연결리스트 사용
public class 스택ADT {
	static class Node{
		int item ;
		Node next;
	}
	static class Stack{
		Node top;
		int size;
	}
	//초기화
	static void init (Stack s) {
		s.top=null;
		s.size=0;
	}
	//push
	static void push(Stack s, int n) {
		Node newNode = new Node();
		newNode.item = n;
		newNode.next = s.top;
		s.top = newNode;
		s.size++; // 앞에서부터 저장하고, 
	}
	//pop
	static void pop(Stack s) {
		int result;
		Node tmp;
		if(isEmpty(s)) {
			System.out.println("Empty");
			return;
		}
		tmp = s.top;
		result = tmp.item;
		s.top =tmp.next; //앞에서부터 뺌
		s.size--;
	}
	//printAll
	static void printAll(Stack s) {
		Node i;
		i=s.top;
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
	static boolean isEmpty(Stack s) {
		return s.top==null;
	}
	//getSize
	static int getSize(Stack s) {
		return s.size;
	}
	//top
	static void top(Stack s) {
		if(isEmpty(s)) {
			System.out.println("Stack Empty");
			return;
		}
		System.out.printf("top : %d", s.top.item);
		System.out.println();
	}
	public static void main(String[] args) {
		Stack s = new Stack();
		init(s);
		
		for(int i = 0 ; i< 10 ; i++) push(s,i);
		top(s);
		printAll(s);
		
		for(int i = 0 ; i< 5 ; i++) pop(s);
		top(s);
		printAll(s);
	}
}

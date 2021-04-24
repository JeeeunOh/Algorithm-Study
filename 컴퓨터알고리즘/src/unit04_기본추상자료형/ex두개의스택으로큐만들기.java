package unit04_기본추상자료형;
// 설명만 하고 구현 안해주심
import java.util.*;

public class ex두개의스택으로큐만들기 {
	static Scanner sc = new Scanner(System.in);
	static Stack st1 = new Stack();
	static Stack st2 = new Stack();
	static int num = sc.nextInt();
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
		s.size++;
	}
	//pop
	static int pop(Stack s) {
		int result;
		Node tmp;
		if(isEmpty(s)) {
			System.out.println("Empty");
			return -1;
		}
		tmp = s.top;
		result = tmp.item;
		s.top =tmp.next;
		s.size--;
		return tmp.item;
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
	//top
		static void enqueue(Stack s, int n) {
			push(st1, n);
			if(!isEmpty(st1)) System.out.printf("%d  ", s.top.item);
			if(n==num-1) {
				for(int j = 0 ; j< num-1 ; j++) {
					int ss = pop(st1);
					push(st2, ss);
				}
			} 
		}
		
		static void dequeue() {
			System.out.println();
			if(isEmpty(st2)) {
				System.out.println("Stack Empty");
				return;
			}
			for(int i = 1 ; i<= num -1; i++)
				System.out.printf("%d  ", pop(st2));
			System.out.println();
		}
	
	public static void main(String[] args) {
		init(st1); init(st2);
		for(int i = 1 ; i<= num ; i++) enqueue(st1, i);
		System.out.println();
		dequeue();
	}
}

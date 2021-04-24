package unit04_기본추상자료형;

// 이중연결리스트 사용
public class 큐ADT {
	static class Node{
		int item ;
		Node next;
	}
	static class Queue{
		Node front; // 제일 앞 노드
		Node rear; // 제일 끝 노드
		int size;
	}
	//초기화
	static void init (Queue q) {
		q.front=q.rear = null;
		q.size=0;
	}
	//push
	static void enqueue(Queue q, int n) { // 제일 끝에 push
		Node newNode = new Node();
		newNode.item = n;
		newNode.next = null;
		
		if(isEmpty(q)) q.front = newNode;
		else q.rear.next = newNode;
		
		q.rear = newNode;
		q.size++;
	}
	//pop
	static void dequeue(Queue q) { // 제일 앞에서 pop
		int result;
		Node tmp;
		if(isEmpty(q)) {
			System.out.println("Empty");
			return;
		}
		tmp = q.front;
		result = tmp.item;
		q.front =tmp.next;
		q.size--;
	}
	//printAll
	static void elements(Queue q) {
		Node i;
		i=q.front;
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
	static boolean isEmpty(Queue q) {
		return q.front==null;
	}
	//getSize
	static int getSize(Queue q) {
		return q.size;
	}
	//top
	static void front(Queue q) {
		if(isEmpty(q)) {
			System.out.println("Stack Empty");
			return;
		}
		System.out.printf("front : %d", q.front.item);
		System.out.println();
	}
	public static void main(String[] args) {
		Queue q = new Queue();
		init(q);
		
		for(int i = 0 ; i< 10 ; i++) enqueue(q,i);
		front(q);
		elements(q);
		System.out.println();
		
		for(int i = 0 ; i< 5 ; i++) dequeue(q);
		front(q);
		elements(q);
	}
}

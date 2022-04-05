package unit03_기초데이터구조;

public class 이중연결리스트{
	static class Node{
		Node pre;
		Node next;
		int data;
		int size=0;
	}
	static int size(Node head) {
		return head.size;
	}
	static boolean isEmpty(Node head) {
		if(head.size==0) return true;
		else return false;
	}
	static void addFirst(Node target, int data) {
		if(target==null) return;
		Node newNode = new Node();
		newNode.next = target.next;
		newNode.data = data;
		target.next = newNode;
	}
	static void removeFirst(Node target) {
		if(target == null) return;
		Node removed  = target.next; // 지울 노드는 target의 다음노드이다.
		target.next = removed.next; // target의 다음노드는 지울노드의 다음노드로 바꾼다 -> 지울노드 연결점 사라짐
	}
	static void printNode(Node head) {
		Node a = head.next;
		while(a!=null) {
			System.out.printf("%d ", a.data);
			a=a.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node head = new Node();
		head.next=null;
		addFirst(head,10);
		addFirst(head,20);
		addFirst(head,30);
		
		printNode(head);
		
		removeFirst(head);
		
		printNode(head);
	}
}

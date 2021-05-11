package unit03_���ʵ����ͱ���;

public class ���߿��Ḯ��Ʈ{
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
		Node removed  = target.next; // ���� ���� target�� ��������̴�.
		target.next = removed.next; // target�� �������� �������� �������� �ٲ۴� -> ������ ������ �����
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

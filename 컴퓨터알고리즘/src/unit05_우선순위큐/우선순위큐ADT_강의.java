package unit05_�켱����ť;
// https://youngminieo1005.tistory.com/27 ����
// �θ�Ű > �ڽ�Ű
public class �켱����ťADT_���� {
	static int MAX_SIZE = 10000;
	//(k,e) ���� ���
	static class Node{
		int key ;
		String element;
		Node next;
	}
	
	static void swap(Node a, Node b) {
		Node temp = a;
		a = b;
		b = a;
	}
	
	static class pq{
		Node[] heap = new Node[MAX_SIZE];
		int count=0;
	}
	
	static void insertItem(pq root, int key, String name) {
		Node a = new Node();
		a.element = name;
		a.key = key;
		if(root.count >= MAX_SIZE) return;
	    root.heap[root.count] = a; // �������� �߰�
	    int now = root.count;
	    int parent = (now - 1) / 2; // �߰��� data�� �θ�
	    while(now > 0 && root.heap[now].key > root.heap[parent].key){ 
		   // now > 0 ���ϴ� ���� ��ġ�� �ֻ�� ��Ʈ�� �ɶ����� �ݺ�, �θ��� data ������ ������ ���� �� ũ�� ����
		   swap(root.heap[now], root.heap[parent]); // �����ü�� �ٲٱ�
		   now = parent; // ������ �θ�Ž��
		   parent = (parent - 1) / 2;	
	   }
	   root.count++;
	}
	
	static Node removeMin(pq root) {
		Node res = new Node();
		if (root.count<=0) {
			return res = null;
		}
		res = root.heap[0];//  ��ȯ�� �ֻ�� ��Ʈ �� ���
		root.count--;
		root.heap[0] = root.heap[root.count]; // �ֻ�� ��Ʈ���� �� ������ ��尪�� ��
		int now = 0, leftChild = 1, rightChild = 2;
		int target = now;
		while(leftChild < root .count) {
			if(root.heap[target].key < root.heap[leftChild].key) target = leftChild;
			if(root.heap[target].key < root.heap[rightChild].key && rightChild < root.count) target = rightChild;
			if (target == now) break; // �� �̻� �������� �ʾƵ� �� �� ����
	        else {
	        	swap(root.heap[now], root.heap[target]);
			    now = target;
			    // ���� Ʈ�� �˻����� now�� ������Ŵ
			    leftChild = now * 2 + 1;
			    rightChild = now * 2 + 2;
			}
	  }
	  return res;
	}
	
	static int size(pq q) {
		return q.count;
	}
	
	static boolean isEmpty(pq q) {
		if(q.count>0) return false;
		else return true;
	}
	
	public static void main(String[] args) {
		pq p = new pq();
		insertItem(p, 20, "B"); 
		insertItem(p, 30, "C");
		insertItem(p, 10, "A"); 
		insertItem(p, 50, "E"); 
		insertItem(p, 40, "D");
		
		for(int i = 0 ; i< 5 ; i++) {
			Node a = new Node();
			a = p.heap[i];
			System.out.printf("key : %d , element : %s \n", a.key, a.element);
		}
		System.out.println();
		for(int i = 0 ; i< 5 ; i++) {
			Node a = new Node();
			a = removeMin(p);
			System.out.printf("key : %d , element : %s \n", a.key, a.element);
		}
	}
}

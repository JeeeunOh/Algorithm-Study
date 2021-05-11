package unit05_�켱����ť;
// https://youngminieo1005.tistory.com/27 ����
// �θ�Ű > �ڽ�Ű
// ���� ����
public class �켱����ťADT_���� {
	static int MAX_SIZE = 10000;
	static pq p = new pq();
	//(k,e) ���� ���
	static class Node{
		int key ;
		String element;
		Node next;
	}
	static void swap(int a, int b) {
		Node temp = p.heap[a];
		 p.heap[a] =  p.heap[b];
		 p.heap[b] = temp;
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
		   swap(now,parent); // �����ü�� �ٲٱ�
		   now = parent; // ������ �θ�Ž��
		   parent = (parent - 1) / 2;	
	   }
	   root.count++;
	}
	
	static Node removeMin() {
		Node res = new Node();
		if (p.count<=0) return res = null; 
		res = p.heap[0]; p.count--;//  ��ȯ�� �ֻ�� ��Ʈ �� ���
		p.heap[0] = p.heap[p.count]; // �ֻ�� ��Ʈ���� �� ������ ��尪�� ��
		int now = 0, leftChild = 1, rightChild = 2;
		int target = now;
		while(leftChild < p .count) {
			if(p.heap[target].key < p.heap[leftChild].key) target = leftChild;
			if(p.heap[target].key < p.heap[rightChild].key && rightChild < p.count) target = rightChild;
			if (target == now) break; // �� �̻� �������� �ʾƵ� �� �� ����
	        else {
	        	swap(now, target);
			    now = target;
			    // ���� Ʈ�� �˻����� now�� ������Ŵ
			    leftChild = now * 2 + 1; // ���� �ڽ� ����
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
		insertItem(p, 20, "B"); 
		insertItem(p, 30, "C");
		insertItem(p, 10, "A"); 
		insertItem(p, 50, "E"); 
		insertItem(p, 40, "D");
		
		for(int i = 0 ; i< 5 ; i++) {
			Node a = new Node(); a = p.heap[i];
			System.out.printf("key : %d , element : %s \n", a.key, a.element);
		}
		
		System.out.println();
		
		for(int i = 0 ; i< 5 ; i++) {
			Node a = new Node();
			a = removeMin();
			System.out.printf("key : %d , element : %s \n", a.key, a.element);
		}
	}
}

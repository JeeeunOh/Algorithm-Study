package unit05_우선순위큐;
// https://youngminieo1005.tistory.com/27 참고
// 부모키 > 자식키
public class 우선순위큐ADT_강의 {
	static int MAX_SIZE = 10000;
	//(k,e) 가진 노드
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
	    root.heap[root.count] = a; // 마지막에 추가
	    int now = root.count;
	    int parent = (now - 1) / 2; // 추가한 data의 부모값
	    while(now > 0 && root.heap[now].key > root.heap[parent].key){ 
		   // now > 0 비교하는 값의 위치가 최상단 루트가 될때까지 반복, 부모의 data 값보다 현재의 값이 더 크면 실행
		   swap(root.heap[now], root.heap[parent]); // 노드자체를 바꾸기
		   now = parent; // 다음은 부모탐색
		   parent = (parent - 1) / 2;	
	   }
	   root.count++;
	}
	
	static Node removeMin(pq root) {
		Node res = new Node();
		if (root.count<=0) {
			return res = null;
		}
		res = root.heap[0];//  반환할 최상단 루트 값 담기
		root.count--;
		root.heap[0] = root.heap[root.count]; // 최상단 루트에는 맨 마지막 노드값이 들어감
		int now = 0, leftChild = 1, rightChild = 2;
		int target = now;
		while(leftChild < root .count) {
			if(root.heap[target].key < root.heap[leftChild].key) target = leftChild;
			if(root.heap[target].key < root.heap[rightChild].key && rightChild < root.count) target = rightChild;
			if (target == now) break; // 더 이상 내려가지 않아도 될 때 종료
	        else {
	        	swap(root.heap[now], root.heap[target]);
			    now = target;
			    // 다음 트리 검사대상을 now에 참조시킴
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

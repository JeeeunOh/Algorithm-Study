package unit05_우선순위큐;
/*
 데이터 저장 시 우선순위 가진 데이터 저장하며
 데이터 꺼낼 때 우선순위가 높은 순으로 데이터를 가져온다.
 완전 이진트리 형태를 지니며, 최대 힙을 이용해 구현함
https://medium.com/@jjunpro/%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84-%ED%81%90-c%EC%96%B8%EC%96%B4-278a4d3d151e
*/
public class 우선순위큐ADT {
	static int MAX_SIZE  = 15;
	
	static void nodeChange(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	static class priorityQueue{
		int[] heap = new int[MAX_SIZE]; //heap의 배열형태
		int count; // heap의 갯수 & and 위치값을 나타내는 값
	}
	
	
	static void push(priorityQueue root, int data) {
		if(root.count >=MAX_SIZE) return;
		root.heap[root.count] = data;
		int now = root.count;
		int parent = (root.count-1)/2; // 추가한 데이터의 부모값
		while(now>0 && root.heap[now] > root.heap[parent]) {
			nodeChange(root.heap[now], root.heap[parent]);
			now = parent;
			parent = (parent-1)/2;
		}
		root.count++;
	}
	
	
	static int pop(priorityQueue root) {
		if (root.count<=0) return -9999;
		int res = root.heap[0];//  반환할 최상단 루트 값 담기
		root.count--;
		root.heap[0] = root.heap[root.count]; // 최상단 루트에는 맨 마지막 노드값이 들어감
		int now = 0, leftChild = 1, rightChild = 2;
		int target = now;
		while(leftChild < root .count) {
			if(root.heap[target] < root.heap[leftChild]) target = leftChild;
			if(root.heap[target] < root.heap[rightChild] && rightChild < root.count) target = rightChild;
			if (target == now) break; // 더 이상 내려가지 않아도 될 때 종료
	        else {
	        	nodeChange(root.heap[now], root.heap[target]);
			    now = target;
			    // 다음 트리 검사대상을 now에 참조시킴
			    leftChild = now * 2 + 1;
			    rightChild = now * 2 + 2;
			}
	  }
	  return res;
	}
	
	
	public static void main(String[] args) {
		int data;
		int n = 10;
		priorityQueue root = new priorityQueue();
		root.count = 0;
		for(int i = 10 ; i<60; i+=10)  push(root, i);
		for(int i = 0 ; i< n ; i++) {
			data = pop(root);
			System.out.printf("%d ", data);
		}
		return;
	}
}

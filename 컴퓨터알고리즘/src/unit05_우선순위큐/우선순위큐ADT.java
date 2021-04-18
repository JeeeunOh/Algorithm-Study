package unit05_�켱����ť;
/*
 ������ ���� �� �켱���� ���� ������ �����ϸ�
 ������ ���� �� �켱������ ���� ������ �����͸� �����´�.
 ���� ����Ʈ�� ���¸� ���ϸ�, �ִ� ���� �̿��� ������
https://medium.com/@jjunpro/%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84-%ED%81%90-c%EC%96%B8%EC%96%B4-278a4d3d151e
*/
public class �켱����ťADT {
	static int MAX_SIZE  = 15;
	
	static void nodeChange(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	static class priorityQueue{
		int[] heap = new int[MAX_SIZE]; //heap�� �迭����
		int count; // heap�� ���� & and ��ġ���� ��Ÿ���� ��
	}
	
	
	static void push(priorityQueue root, int data) {
		if(root.count >=MAX_SIZE) return;
		root.heap[root.count] = data;
		int now = root.count;
		int parent = (root.count-1)/2; // �߰��� �������� �θ�
		while(now>0 && root.heap[now] > root.heap[parent]) {
			nodeChange(root.heap[now], root.heap[parent]);
			now = parent;
			parent = (parent-1)/2;
		}
		root.count++;
	}
	
	
	static int pop(priorityQueue root) {
		if (root.count<=0) return -9999;
		int res = root.heap[0];//  ��ȯ�� �ֻ�� ��Ʈ �� ���
		root.count--;
		root.heap[0] = root.heap[root.count]; // �ֻ�� ��Ʈ���� �� ������ ��尪�� ��
		int now = 0, leftChild = 1, rightChild = 2;
		int target = now;
		while(leftChild < root .count) {
			if(root.heap[target] < root.heap[leftChild]) target = leftChild;
			if(root.heap[target] < root.heap[rightChild] && rightChild < root.count) target = rightChild;
			if (target == now) break; // �� �̻� �������� �ʾƵ� �� �� ����
	        else {
	        	nodeChange(root.heap[now], root.heap[target]);
			    now = target;
			    // ���� Ʈ�� �˻����� now�� ������Ŵ
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

package unit04_�⺻�߻��ڷ���;

public class Ʈ��ADT {
	static class Tree{
		int data;
		Tree left, right;
	}
	static void preOrder(Tree root) {
		if (root!=null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	static void inOrder(Tree root) {
		if (root!=null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	static void postOrder(Tree root) {
		if (root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}

	public static void main(String[] args) {
		Tree t1 = new Tree();
		Tree t2 = new Tree();
		Tree t3 = new Tree();
		t1.data = 1; t1.left = t2;
		t2.data = 2; t1.right = t3;
		t3.data = 3;
		
		preOrder(t1);
		inOrder(t1);
		postOrder(t1);
		

	}
}

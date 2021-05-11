package unit04_기본추상자료형;

public class 트리ADT {
	static class Tree{
		int data;
		Tree left, right;
	}
	static void preOrder(Tree root) {
		if (root!=null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	static void inOrder(Tree root) {
		if (root!=null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	static void postOrder(Tree root) {
		if (root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
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
		System.out.println();
		inOrder(t1);
		System.out.println();
		postOrder(t1);
		System.out.println();
		

	}
}

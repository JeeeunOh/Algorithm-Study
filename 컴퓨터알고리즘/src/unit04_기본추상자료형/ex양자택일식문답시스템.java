package unit04_�⺻�߻��ڷ���;
// �����ϰ� ���������ֽ�
public class ex�������ϽĹ���ý��� {
	static class Node{
		String str;
		Node left;
		Node right;
	}
	static Node buildDecisionTree() {
		System.out.println("Let's build...");
		return makeInternalNode();
	}
	static Node makeInternalNode() {
		Node n = new Node();
		
		return n;
	}
	public static void main(String[] args) {
		System.out.println("Let's build...");
		Node n1 = new Node(); 
		Node n2 = new Node();n1.str = "�����Ļ縦 ���ϼ���?"; n1.left = n2; n1.right = n2;
		Node n3 = new Node();n2.str = "��ĵ� ��������?";
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		Node n7 = new Node();

	}

}

package unit04_기본추상자료형;
// 설명하고 구현안해주심
public class ex양자택일식문답시스템 {
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
		Node n2 = new Node();n1.str = "빠른식사를 원하세요?"; n1.left = n2; n1.right = n2;
		Node n3 = new Node();n2.str = "양식도 좋으세요?";
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		Node n7 = new Node();

	}

}

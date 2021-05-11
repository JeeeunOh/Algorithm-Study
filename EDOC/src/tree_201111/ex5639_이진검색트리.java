package tree_201111;

import java.io.IOException;
import java.util.*;

public class ex5639_�����˻�Ʈ�� {
	
	public static class Node{ //��� Ŭ����
		Node left; //�� �ڽĳ��
		Node right;//�� �ڽĳ��
		int val;
		public Node(int v) { //�����ڴ� �ش��� �� �޾ƿ�
			this.val = val;
		}
	}
	
	public static Node insertNode(Node node, int N) {//������ȸ : ��Ʈ->��->��
		//node�� ���� �޾ƿ� ���, N�� val��
		Node current = null; //null���� ������ ���ο� current ��� �����
		if(node == null) { //�޾ƿ� node�� ����ٸ�
			return new Node(N); //N�� val�� ������ �� Node return
		}
		if(node.val > N) { //�޾ƿ� node�� val�� �� N���� ũ��
			current = insertNode(node.left, N); //current���� �޾ƿ� node�� ���� ����̰�, N���� val�� ����
			node.left = current;//node�� ���� ���� current�� ����
		}else { // �޾ƿ� node�� val�� �� N���� ������
			current = insertNode(node.right, N); //current���� �޾ƿ� node�� ������ ����̰�, N���� val�� ����
			node.right = current;//node�� ������ ���� current�� ����
		}
		return node; //����,�����ʳ�� �Ǵ� �ڱ��ڽ��� ������ node return
	}
	
	public static void postOrder(Node node) {
		if(node!= null) { //node�� null�� �ƴ϶��
			postOrder(node.left); //���� ���� ����
			postOrder(node.right); //�� ������ ����
			System.out.println(node.val); //�̶� ����κ� : �ش� node�� val �� ->> ��, �����ڽ�,�������ڽ�, �ڱ��ڽ� ������� ���
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10001];
		int N = sc.nextInt();
		Node root = new Node(N); // �� ��� �޾ƿ�
		while(sc.hasNext()) { // �Է°��� �ִٸ�
			try {
				N = sc.nextInt(); //N�� �� �� �޾ƿ���
				root = insertNode(root,N); //insertNode�Լ��� root��� �ڱ��ڽ�, �³��, ���� ����
			}catch(Exception e) { // �Է°��� ���ٸ�
				break;
			}
		}
		postOrder(root); // ���� �Լ� ���� �����ڽ�,�������ڽ�, �ڱ��ڽ� ������� ���
	}
}









package 트리;

import java.io.IOException;
import java.util.*;

public class ex5639_이진검색트리 {
	
	public static class Node{ //노드 클래스
		Node left; //좌 자식노드
		Node right;//우 자식노드
		int val;
		public Node(int v) { //생성자는 해당노드 값 받아옴
			this.val = val;
		}
	}
	
	public static Node insertNode(Node node, int N) {//전위순회 : 루트->왼->오
		//node는 새로 받아온 노드, N은 val값
		Node current = null; //null값을 가지는 새로운 current 노드 만들기
		if(node == null) { //받아온 node가 비었다면
			return new Node(N); //N을 val로 가지는 새 Node return
		}
		if(node.val > N) { //받아온 node의 val이 이 N보다 크면
			current = insertNode(node.left, N); //current노드는 받아온 node의 왼쪽 노드이고, N값을 val로 가짐
			node.left = current;//node의 왼쪽 노드는 current로 갱신
		}else { // 받아온 node의 val이 이 N보다 작으면
			current = insertNode(node.right, N); //current노드는 받아온 node의 오른쪽 노드이고, N값을 val로 가짐
			node.right = current;//node의 오른쪽 노드는 current로 갱신
		}
		return node; //왼쪽,오른쪽노드 또는 자기자신을 갱신한 node return
	}
	
	public static void postOrder(Node node) {
		if(node!= null) { //node가 null이 아니라면
			postOrder(node.left); //왼쪽 먼저 실행
			postOrder(node.right); //그 다음에 실행
			System.out.println(node.val); //이때 실행부분 : 해당 node의 val 값 ->> 즉, 왼쪽자식,오른쪽자식, 자기자신 순서대로 출력
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10001];
		int N = sc.nextInt();
		Node root = new Node(N); // 새 노드 받아옴
		while(sc.hasNext()) { // 입력값이 있다면
			try {
				N = sc.nextInt(); //N에 새 값 받아오고
				root = insertNode(root,N); //insertNode함수로 root노드 자기자신, 좌노드, 우노드 갱신
			}catch(Exception e) { // 입력값이 없다면
				break;
			}
		}
		postOrder(root); // 위의 함수 통해 왼쪽자식,오른쪽자식, 자기자신 순서대로 출력
	}
}









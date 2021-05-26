package ���ͽ�Ʈ���ÿ�;

import java.util.*;

public class ex18352{
	static int N,M,K,X;
	static boolean[] visit;
	static Node[] map;
	static List<Integer> result;
	static public class Node{
		int dist;
		Node next;
		public Node(int n) { // ���ðŸ���
			super();
			dist = n;
		}
		public Node(int n, Node next) {// ���絵�ðŸ��� ���� ����
			super();
			dist = n;
			this.next = next;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // ���� ����
		M = sc.nextInt(); // ���� ����
		K = sc.nextInt(); //�Ÿ�
		X = sc.nextInt(); //��ߵ���
		map = new Node[N+1]; visit = new boolean[N+1];
		result = new ArrayList<Integer>();
		
		for(int i = 0; i < M ; i++) { //�Է¹���
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from] = new Node(to, map[from]); // from ���ÿ� to ���ð� ����Ǿ�����
	}
	
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {X,0}); // ��ߵ���, �ش絵�� �Ÿ� 0 �Է�
		visit[X] = true; // X ���� Ž��
		int tempk = 0;
		while(!q.isEmpty()) { // ť�� Ž���� ���ð� �������� ���������� �ݺ�
			int[] cur = q.poll(); // Ž���� ���� cur ������
	
			if(cur[1] == K) break; // cur�� �Ÿ��� ��ǥ�Ÿ� K�� ���ٸ� �ݺ� ���
			
			if(tempk != cur[1]) { // �߰� ���� K�� ���� ���� �Ÿ� cur[1]�� �ٸ��ٸ�
				result.clear(); // �迭 �ʱ�ȭ
				tempk = cur[1]; // �߰����̸� cur[1]�� �ٲ���
			}
			for(Node temp = map[cur[0]]; temp!= null; temp = temp.next ) { // �߰���带 map���� �����´�
				if(!visit[temp.dist]) { // �ش� ���� �湮���� ���ٸ�
					result.add(temp.dist); // �ش� ���� result�� �ְ�
					visit[temp.dist] = true; // �ش� ���� �湮�ߴٰ� ǥ��
					q.offer(new int[] {temp.dist, cur[1]+1}); // ť�� �ش� ���� & �ش絵�� �Ÿ� ����ְ� ���� Ž���� ���
				}
			}
		}
		if(result.isEmpty())System.out.println(-1); // �迭�� ����ִٸ� ������ ���� �� ���ٴ� ���̹Ƿ� -1 ���
		else {
			Collections.sort(result); // result �迭 �������� ���� �� ���
			for (int i : result)  System.out.println(i);
		}
 	sc.close();
	}
}
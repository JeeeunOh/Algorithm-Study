package 다익스트라플와;

import java.util.*;

public class ex18352{
	static int N,M,K,X;
	static boolean[] visit;
	static Node[] adjMatrix;
	static List<Integer> result;
	static public class Node{
		int vertex;
		Node next;
		public Node(int n) { 
			super();
			vertex = n;
		}
		public Node(int n, Node next) {
			super();
			vertex = n;
			this.next = next;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 도시 개수
		M = sc.nextInt(); // 도로 개수
		K = sc.nextInt();//거리
		X = sc.nextInt(); //출발도시
		adjMatrix = new Node[N+1];
		visit = new boolean[N+1];
		result = new ArrayList<Integer>();
		
		for(int i = 0; i < M ; i++) { //입력받음
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from] = new Node(to, adjMatrix[from]);
	}
	
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {X,0});
		visit[X] = true;
		int tempk = 0;
		while(!q.isEmpty()) { 
			int[] cur = q.poll();
	
			if(cur[1] == K) break;
			
			if(tempk != cur[1]) {
				result.clear();
				tempk = cur[1];
			}
			for(Node temp = adjMatrix[cur[0]]; temp!= null; temp = temp.next ) {
				if(!visit[temp.vertex]) {
					result.add(temp.vertex);
					visit[temp.vertex] = true;
					q.offer(new int[] {temp.vertex, cur[1]+1});
				}
			}
		}
		if(result.isEmpty())System.out.println(-1);
		else {
			Collections.sort(result);
			for (int i : result) {
				System.out.println(i);
			}
		}
 	
	}
}
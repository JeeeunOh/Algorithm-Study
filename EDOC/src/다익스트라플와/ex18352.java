package 다익스트라플와;

import java.util.*;

public class ex18352{
	static int N,M,K,X;
	static boolean[] visit;
	static Node[] map;
	static List<Integer> result;
	static public class Node{
		int dist;
		Node next;
		public Node(int n) { // 도시거리만
			super();
			dist = n;
		}
		public Node(int n, Node next) {// 현재도시거리와 연결 도시
			super();
			dist = n;
			this.next = next;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 도시 개수
		M = sc.nextInt(); // 도로 개수
		K = sc.nextInt(); //거리
		X = sc.nextInt(); //출발도시
		map = new Node[N+1]; visit = new boolean[N+1];
		result = new ArrayList<Integer>();
		
		for(int i = 0; i < M ; i++) { //입력받음
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from] = new Node(to, map[from]); // from 도시와 to 도시가 연결되어있음
	}
	
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {X,0}); // 출발도시, 해당도시 거리 0 입력
		visit[X] = true; // X 기준 탐색
		int tempk = 0;
		while(!q.isEmpty()) { // 큐에 탐색할 도시가 남아있지 않을때까지 반복
			int[] cur = q.poll(); // 탐색할 도시 cur 꺼내옴
	
			if(cur[1] == K) break; // cur의 거리가 목표거리 K와 같다면 반복 취소
			
			if(tempk != cur[1]) { // 중간 길이 K가 현재 도시 거리 cur[1]과 다르다면
				result.clear(); // 배열 초기화
				tempk = cur[1]; // 중간길이를 cur[1]로 바꿔줌
			}
			for(Node temp = map[cur[0]]; temp!= null; temp = temp.next ) { // 중간노드를 map에서 가져온다
				if(!visit[temp.dist]) { // 해당 도시 방문한적 없다면
					result.add(temp.dist); // 해당 도시 result에 넣고
					visit[temp.dist] = true; // 해당 도시 방문했다고 표시
					q.offer(new int[] {temp.dist, cur[1]+1}); // 큐에 해당 도시 & 해당도시 거리 집어넣고 다음 탐색에 사용
				}
			}
		}
		if(result.isEmpty())System.out.println(-1); // 배열이 비어있다면 정답인 도시 가 없다는 뜻이므로 -1 출력
		else {
			Collections.sort(result); // result 배열 오름차순 정렬 후 출력
			for (int i : result)  System.out.println(i);
		}
 	sc.close();
	}
}
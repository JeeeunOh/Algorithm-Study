package DFS_BFS;

import java.util.*;

public class boj1260 {
	
	private static int N, M, V; 
	private static int[][] graph; 
	private static boolean[] check; 
	
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		V = sc.nextInt(); 
		graph = new int[N + 1][N + 1]; // 그래프 계산 위한 인접행렬
		check = new boolean[N + 1]; // 해당 정점 방문했는지 확인 위한 배열
		for (int i = 0; i < M; i++) { 
			int x = sc.nextInt(); //연결된 정점 x와 y 입력받고
			int y = sc.nextInt(); 
			graph[x][y] = 1; graph[y][x] = 1; // 둘이 연결되어있음을 graph배열에 저장
		}
		dfs(V); 
		System.out.println(); 
		Arrays.fill(check, false); // check 배열 초기화 
		bfs(V);
	}
	public static void dfs(int start) { 
		check[start] = true; // start점에 방문했음을 표시
		System.out.print(start + " "); 
		for (int i = 1; i < N + 1; i++) { // 1번부터 N-1번 정점까지 방문하면서
			if (graph[start][i] == 1 && !check[i]) dfs(i); 
			// 해당 정점이 start와 연결되어있고, 해당 점점을 방문한 적이 없다면, 해당 정점 기준 dfs 탐색
		}
	}
	// 여기서부터는 bfs탐색으로 후에 bfs특집에서 관련 내용을 참고해주세요
	public static void bfs(int start) { 
		Queue<Integer> q = new LinkedList<>();  // bfs 탐색 위해 큐를 하나 만들고
		q.offer(start); // 큐의 끝에 start점 추가
		check[start] = true;  // start점 방문했다고 체크
		while (!q.isEmpty()) { //큐 안의 정점이 소진될 때까지 반복
			int vertex = q.poll(); // 큐의 앞에서 정점 vertex 추출
			System.out.print(vertex + " "); 
			for (int i = 1; i < N + 1; i++) { // 1번부터 N-1번 정점까지 방문하면서
				if (graph[vertex][i] == 1 && !check[i]) { 
					q.offer(i); 
					check[i] = true;
				} // 해당 정점이 vertex와 연결되어있고, 해당 정점을 방문한 적이 없다면 방문했음을 체크하고 해당 정점을 큐에 추가한다.
			}
		}
	}
}

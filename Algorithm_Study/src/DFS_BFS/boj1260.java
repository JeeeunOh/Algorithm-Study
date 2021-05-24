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
		graph = new int[N + 1][N + 1]; 
		check = new boolean[N + 1];
		for (int i = 0; i < M; i++) { 
			int x = sc.nextInt(); 
			int y = sc.nextInt(); 
			graph[x][y] = 1; graph[y][x] = 1; 
			} 
		dfs(V); 
		System.out.println(); 
		Arrays.fill(check, false); 
		// check 배열 초기화 
		bfs(V); 
		} 
	public static void dfs(int start) { 
		check[start] = true; 
		System.out.print(start + " "); 
		for (int i = 1; i < N + 1; i++) { 
			if (graph[start][i] == 1 && !check[i]) dfs(i);
			} 
		} 
	public static void bfs(int start) { 
		Queue<Integer> q = new LinkedList<>(); 
		q.offer(start); 
		check[start] = true; 
		while (!q.isEmpty()) { 
			int vertex = q.poll(); 
			System.out.print(vertex + " "); 
			for (int i = 1; i < N + 1; i++) {
				if (graph[vertex][i] == 1 && !check[i]) { 
					q.offer(i); check[i] = true;
					}
			}
		}
	}
}

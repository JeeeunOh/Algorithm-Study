package 그래프;

/*
 푸는 방법)
 1. 2번의 dfs 필요 -> 임의의 노드(1)에서 가장 먼 노드 구하고, 이 구한 노드에서 가장 먼 노드를 구한다.
 */

import java.util.*;
import java.io.*;

public class ex1967 {
	
	public static ArrayList<Tree>[] adj;
	public static boolean[] visit;
	public static int[] distance;
	
	//트리 구성요소 넣기
	public static class Tree {
		int v, w;
		public Tree(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	// 탐색용 dfs 함수
	public static void dfs(int node, int weight) {
		visit[node] = true; // 노드 탐색한 것 표시하고
		for (int i = 0; i < adj[node].size(); i++) {
			Tree next = adj[node].get(i);
			if (!visit[next.v]) { // 다음 노드 중 방문 안한 노드 찾아서
				dfs(next.v, weight + next.w); // 현재 노드의 가중치를 최대 값으로 계속 업데이트를 함 
			}
		}
		distance[node] = weight;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		adj = new ArrayList[v + 1];
		visit = new boolean[v + 1];
		distance = new int[v + 1];
		for (int i = 1; i <= v; i++)
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < v - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken()),
				node2 = Integer.parseInt(st.nextToken()),
				weight = Integer.parseInt(st.nextToken());
			
			adj[node1].add(new Tree(node2, weight)); // 노드1,2는 가중치가 weight인 간선으로 연결되어 있다.
			adj[node2].add(new Tree(node1, weight));
		}
		
		dfs(1, 0);
		
		for (int i = 1; i < visit.length; i++)
			visit[i] = false; // 방문한 적 없음을 다시 표시해준다.
		
		int start = 1;
		for (int i = 2; i < distance.length; i++) 
			if (distance[start] < distance[i]) 
				start = i;
		
		dfs(start, 0);
		
		
		int ans = 0;
		for (int i = 1; i < distance.length; i++)
			ans = Math.max(ans, distance[i]); // 최대 거리 갱신해줌
		System.out.println(ans);
		
	}
}
 

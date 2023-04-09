package �׷���;

/*
 Ǫ�� ���)
 1. 2���� dfs �ʿ� -> ������ ���(1)���� ���� �� ��� ���ϰ�, �� ���� ��忡�� ���� �� ��带 ���Ѵ�.
 */

import java.util.*;
import java.io.*;

public class ex1967 {
	
	public static ArrayList<Tree>[] adj;
	public static boolean[] visit;
	public static int[] distance;
	
	//Ʈ�� ������� �ֱ�
	public static class Tree {
		int v, w;
		public Tree(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	// Ž���� dfs �Լ�
	public static void dfs(int node, int weight) {
		visit[node] = true; // ��� Ž���� �� ǥ���ϰ�
		for (int i = 0; i < adj[node].size(); i++) {
			Tree next = adj[node].get(i);
			if (!visit[next.v]) { // ���� ��� �� �湮 ���� ��� ã�Ƽ�
				dfs(next.v, weight + next.w); // ���� ����� ����ġ�� �ִ� ������ ��� ������Ʈ�� �� 
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
			
			adj[node1].add(new Tree(node2, weight)); // ���1,2�� ����ġ�� weight�� �������� ����Ǿ� �ִ�.
			adj[node2].add(new Tree(node1, weight));
		}
		
		dfs(1, 0);
		
		for (int i = 1; i < visit.length; i++)
			visit[i] = false; // �湮�� �� ������ �ٽ� ǥ�����ش�.
		
		int start = 1;
		for (int i = 2; i < distance.length; i++) 
			if (distance[start] < distance[i]) 
				start = i;
		
		dfs(start, 0);
		
		
		int ans = 0;
		for (int i = 1; i < distance.length; i++)
			ans = Math.max(ans, distance[i]); // �ִ� �Ÿ� ��������
		System.out.println(ans);
		
	}
}
 

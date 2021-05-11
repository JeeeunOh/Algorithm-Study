package �׷���;

import java.io.*;
import java.util.*;

public class ex1260 {
	static int N,M,V;
	static boolean[] visited;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]); // ������ ����
		M = Integer.parseInt(s[1]); // ������ ����
		V =Integer.parseInt(s[2]); // Ž�� ���� ���� ��ȣ
		
		visited = new boolean[1001];
		arr = new int[1001][1001];
		
		for (int i=0 ; i< 5 ; i ++) {
			s = br.readLine().split(" ");
			int x= Integer.parseInt(s[0]); // ������ ����
			int y = Integer.parseInt(s[1]); // ������ ����
			arr[x][y]=arr[y][x]=1;
		}
		DFS(V);
		System.out.println();
		visited = new boolean[1001];
		BFS();
	}
	public static void DFS(int start) {
		visited[start] = true;
		System.out.print(start+" ");
		for (int i=1 ; i<=N ; i ++) {
			if(arr[start][i]==1 && visited[i]==false) DFS(i);
		}
	}
	public static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(V);
		visited[V]=true;
		System.out.print(V+" ");
		while(!q.isEmpty()) {
			int temp = q.poll();
			for (int i=1 ; i<=N ; i++) 
				if(arr[temp][i]==1 && visited[i]==false) {
					q.offer(i);
					visited[i]=true;
					System.out.print(i + " ");
				}
		}
	}
}

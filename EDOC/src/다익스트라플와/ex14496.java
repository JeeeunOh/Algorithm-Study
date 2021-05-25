package 다익스트라플와;
import java.io.*;
import java.util.*;

public class ex14496{
	static int source, target;
	static int n,m;
	static int[][] map;
	static int answer = -1;
	static boolean[] visited;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		source = sc.nextInt();
		target = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		int a=0,b=0;
		
		for(int i=0;i<m;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
			
			if(a == source) {
				queue.add(new int[] {b,1});
				visited[b] = true;
			}if(b == source) {
				queue.add(new int[] {a,1});
				visited[a] = true;
			}
		}
		if(source!=target) bfs();
		else answer = 0;
		
		System.out.println(answer);
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0] == target) {
				answer = now[1];
				return;
			}
			for(int i=1;i<=n;i++) {
				if(map[now[0]][i] == 1 && visited[i] == false) {
					visited[i] = true;
					queue.add(new int[] {i,now[1]+1});
				}
			}
		}
	}
}
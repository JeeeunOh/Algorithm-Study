package 다익스트라;

import java.util.*;

public class ex20046 {
	public static final int[] dx = {0, 0, -1, 1};
	public static final int[] dy = {1, -1, 0, 0}; 
	public static int[][] d, grid;
	public static int m, n;
	
	static class Des implements Comparable<Des> {
		int x,y,w;
		public Des(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		// w기준 코드 짜기
		public int compareTo(Des p) {
			return this.w - p.w;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		
		grid = new int[m + 1][n + 1];
		d = new int[m + 1][n + 1];
		
		for (int i = 1; i <= m; i++) Arrays.fill(d[i], Integer.MAX_VALUE);
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++)
				grid[i][j] = sc.nextInt();
		}
		
		dijkstra(1, 1);
		
		System.out.println(d[m][n] == Integer.MAX_VALUE ? "-1" : d[m][n]);
	}
	
	public static void dijkstra(int x, int y) {
		PriorityQueue<Des> pq = new PriorityQueue<>();
		if (grid[x][y] != -1) {
			pq.add(new Des(x, y, grid[x][y]));
			d[x][y] = grid[x][y];
		}
		
		while (!pq.isEmpty()) {
			Des cur = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i],
					ny = cur.y + dy[i];
				
				if (nx < 1 || ny < 1 || nx > m || ny > n) continue;
				if (grid[nx][ny] == -1) continue;
				
				if (d[nx][ny] > cur.w + grid[nx][ny]) {
					d[nx][ny] = cur.w + grid[nx][ny];
					pq.add(new Des(nx, ny, d[nx][ny]));
				}
			}
		}
	}
}

package 다익스트라_플와_210217;

import java.io.*;
import java.util.*;

public class ex11780 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m = sc.nextInt();
		int[][] d = new int [n + 1][n + 1];
		int[][] next = new int[n + 1][n + 1];
		final int INF = 10000001;
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], INF);
			d[i][i] = 0;
		}
		
		for (int i = 0; i < m; i ++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int dist = sc.nextInt();
			
			d[start][end] = Math.min(d[start][end], dist);
			next[start][end] = end;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == INF) {
					d[i][j] = 0;
				}
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == 0) {
					System.out.println("0");
					continue;
				}
				ArrayList<Integer> path = new ArrayList<>();
				int cur = i;
				
				while (cur != j) {
					path.add(cur);
					cur = next[cur][j];
				}
				path.add(cur);
				
				System.out.print(path.size() + " ");
				for (int p : path) {
					System.out.print(p + " ");
				}
				System.out.println();
			}
		}
	}
}
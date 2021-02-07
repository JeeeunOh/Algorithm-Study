package ±×·¡ÇÁ;

import java.util.*;

public class ex5829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(),M = sc.nextInt(),K = sc.nextInt();
		
		int[][] p = new int[N + 1][2];
		int[] dt = new int[N + 1];
		int[] t = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
		}
		
		int[] dir = new int[M + 1];
		
		for (int i = 1; i <= M; i++) {
			char input = sc.next().charAt(0);
			if (input == 'R') dir[i] = 1;
			else dir[i] = 0; 
		}
		
		for (int i = 1; i <= N; i++) {
			int n = i;
			int l = 1;
			while(l <= M) {
				int next = p[n][dir[l]];
				n = next;
				l++;
			}
			dt[i] = n;
		}
		
		int now = 1;
		int period = 0;
		int start = 0;
		for(int i = 0; i <= N; i++) {
			if(visit[now]) {
				period = i;
				start = now;
				break;
			}
			t[i] = now;
			visit[now] = true;
			now = dt[now];
		}
		for(int i = 0; i <= N; i++) {
			if(t[i] == start) {
				period -= i;
				start = i;
				break;
			}
			if(K == 0) {
				System.out.println(t[i]);
				return;
			}
			K--;
		}
		K %= period;
		System.out.println(t[start + K]);
	}
}
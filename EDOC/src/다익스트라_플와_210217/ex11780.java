package ���ͽ�Ʈ��_�ÿ�_210217;

import java.util.*;

public class ex11780 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ���� ����
		int m = sc.nextInt(); // ���� ����
		int[][] d = new int [n + 1][n + 1];
		int[][] next = new int[n + 1][n + 1];
		final int INF = 10000001; // ��� �ִ�ġ �����س���
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], INF); // �� �������� �� ������ ���� ��� �ִ�� ����
			d[i][i] = 0; // i���� i�� ���� ��� 0
		}
		
		for (int i = 0; i < m; i ++) {
			int start = sc.nextInt(),end = sc.nextInt(),cost = sc.nextInt();
			// start ���ÿ��� end���ñ��� ��� ��� cost
			d[start][end] = Math.min(d[start][end], cost); //start���� end�� ���� �ּ� ��� ����
			next[start][end] = end; 
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					//�������� ���� ��찡 ���°��, ��ȸ�ؼ� ���°� �� ������� ����
					if (d[i][j] > d[i][k] + d[k][j]) { 
						d[i][j] = d[i][k] + d[k][j]; 
						next[i][j] = next[i][k]; 
					}
				}
			}
		}
		
		/*
		�� �������� n��n���� ���� ����ؾ� �Ѵ�.
		 -> �� ����, ���� i���� ���� j�� ���� ��θ� �������� ������ ����Ѵ�. 
		  -> �̶�, ���� i�� ���� j�� ����ؾ� �Ѵ�. ����, i���� j�� �� �� ���� ��쿡�� 0�� ����Ѵ�.
		 */
		
		// ���� i���� j�� ���µ� �ʿ��� �ּ� ��� ���
		// ó�� �ʱ�ȭ �� �״�� �� ���� ��ΰ� ���ٴ� ���̹Ƿ� 0���� �ٲ��ش�.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == INF)  d[i][j] = 0; 
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		} 
		
		 // i��n+j��° �ٿ��� ���� i���� ���� j�� ���� �ּ� ��뿡 ���ԵǾ� �ִ� ������ ���� k�� ����Ѵ�. 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == 0) { // i���� i�� ���� ��� x -> 0 ���
					System.out.println("0");
					continue;
				}
				ArrayList<Integer> path = new ArrayList<>();
				int cur = i; // i���� ����
				while (cur != j) { // �� ������ j�� �����ϱ� ������
					path.add(cur); // ���� ���� �߰��ϰ�
					cur = next[cur][j]; // ���� cur ����
				}
				path.add(cur); // ������ ���� ���� �־��ְ�
				System.out.print(path.size() + " "); // �迭 ������ ����� ��
				for (int p : path)  System.out.print(p + " ");  // �߰������� �� ���
				System.out.println();
			}
		}
	}
}
package ���ͽ�Ʈ���ÿ�;

import java.util.*;

public class ex���ͽ�Ʈ�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		int[] D = new int[V];
		Arrays.fill(D, Integer.MAX_VALUE);
		boolean[] check = new boolean[V];

		D[0] = 0;
		for (int i = 0; i < V - 1; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < V; j++) {
				// ���� ó������ �ʾ����鼭, ���� ª�� �Ÿ����
				if (!check[j] && min > D[j]) {
					index = j;
					min = D[j];
				}
			}

			for (int j = 0; j < V; j++) {
				// ���� ó������ �ʾ����鼭 ��ΰ� �����ϰ�, index������ �Ÿ� + index���� j������ �Ÿ��� D[j]���� �۴ٸ�
				if (!check[j] && adj[index][j] != 0 && D[index] != Integer.MAX_VALUE
						&& D[index] + adj[index][j] < D[j]) {
					D[j] = D[index] + adj[index][j];
				}
			}
			check[index] = true;
		}
		System.out.println(Arrays.toString(D));
	}

}
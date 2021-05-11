package ��Ʈ��ŷ;

import java.util.Scanner;

public class ex15649_N��M_1 {
	public static int N , M ; 
	public static int[] arr;
	public static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];// ����� ���� �Է��ϴ� �迭
		visited = new int[N+1];
		dfs(N,M,0);
	}
	
	public static void dfs(int n,int m, int dep) { // a���� ����, ���̰� dep
		if (dep == m) { // ���̰� M �̸� �������� ������ ���� ��� ���
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println(); // ��� ������ �� �ǳʶٱ�
			return;
		}
        
		for (int i = 1; i <= n; i++) {
				if (visited[i]==0) {
					visited[i]=1;
					arr[dep]=i;
					dfs(n,m,dep + 1); 
				}// �湮�� ���� ���ٸ�, �������� �Ѿ
			}
		}
}
package 백트래킹;

import java.util.Scanner;

public class ex15649_N과M_1 {
	public static int N , M ; 
	public static int[] arr;
	public static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visited = new int[N+1];
		dfs(N,M,0);
	}
	
	public static void dfs(int n,int m, int dep) { // a에서 시작, 깊이가 dep
		if (dep == m) { // 깊이가 M 이면 이제까지 저장한 수열 모두 출력
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println(); // 출력 끝나면 줄 건너뛰기
			return;
		}
        
		for (int i = 1; i <= n; i++) {
				if (visited[i]==0) {
					visited[i]=1;
					arr[dep]=i;
					dfs(n,m,dep + 1); 
					visited[i]=0;
				}// 방문한 적이 없다면, 다음으로 넘어감
			}
		}
}
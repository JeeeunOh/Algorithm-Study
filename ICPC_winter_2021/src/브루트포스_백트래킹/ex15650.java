package 브루트포스_백트래킹;

import java.util.*;

public class ex15650 {
	public static int N , M ; 
	public static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		dfs(1,0);
	}
	public static void dfs(int a, int dep) { // a에서 시작, 깊이가 dep
		if (dep == M) { // 깊이가 M 이면 이제까지 저장한 수열 모두 출력
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println(); // 출력 끝나면 줄 건너뛰기
			return;
		}
        
		for (int i = a; i <= N; i++) {
			arr[dep] = i; // 해당 깊이에 수열 저장하고
			dfs(i + 1, dep + 1); // 다음으로 넘어감
 
		}
	}
}








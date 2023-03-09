package 동적계획법;

import java.util.*;

public class ex7579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =  sc.nextInt(), M = sc.nextInt();
		
		int[] bt= new int[N]; //바이트수,
		int[] ct= new int[N]; //비활성화 비용
		int min=Integer.MAX_VALUE; // 최소값을 정수의 최대값으로 설정해놓는다.
		int[][] dp = new int[N][100001]; // dp[바이트][비용]
		
		for(int i=0;i<N;i++) bt[i]=sc.nextInt(); // 바이트 수
		for(int i=0;i<N;i++) ct[i]=sc.nextInt(); // 비용
		
		dp[0][ct[0]] = bt[0];
		for(int i=1;i<N;i++) {
			int m = bt[i], val=ct[i];
			for(int j = 0 ; j <= 10000 ; j++ ) {
                if (j >= val) dp[i][j] = Math.max(dp[i - 1][j - val] + m, dp[i][j]);
                else dp[i][j] =Math.max(dp[i][j], dp[i - 1][j]);
                if(dp[i][j] >= M) min = Math.min(min, j);
			}
		}
		System.out.println(min);
	}
}

package 동적계획법;

import java.util.*;

public class ex12865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt();
		int W = sc.nextInt();
		int[][] input = new int[N+1][2];
		int[][] dp = new int[N+1][W+1]; // dp[무게][가치]
		for(int i=1;i<=N;i++) {
			input[i][0]=sc.nextInt();
			input[i][1]=sc.nextInt();
		}
		for(int i=1;i<=N;i++) {
			int w = input[i][0], val=input[i][1];
			for(int j=1;j<=W;j++) {
				if(j<w) dp[i][j]=dp[i-1][j];
				else dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w]+val);
			}
		}
		System.out.println(dp[N][W]);
	}
}

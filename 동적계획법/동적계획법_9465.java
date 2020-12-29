package 悼利拌裙过;

import java.util.*;

public class 悼利拌裙过_9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i=0 ; i <num ; i++) {
			int n = sc.nextInt();
			int[][] dp = new int[2][n+1];
			int[][] arr = new int[2][n+1];
			for (int j=1;j<=n;j++) {
				arr[0][j]=sc.nextInt();
			}
			for (int j=1;j<=n;j++) {
				arr[1][j]=sc.nextInt();
			}
			dp[0][1]=arr[0][1];
			dp[1][1]=arr[1][1];
			dp[0][2]=dp[1][1]+arr[0][2];
			dp[1][2]=dp[0][1]+arr[1][2];
			for (int  j = 2 ;  j <= n ; j++) {
				if (j>=3) {
					dp[0][j]=Math.max(dp[1][j-1],dp[1][j-2])+arr[0][j];
		            dp[1][j]=Math.max(dp[0][j-1],dp[0][j-2])+arr[1][j];
				}
			}
			System.out.println(Math.max(dp[0][n],dp[1][n]));
		}
		
	}

}

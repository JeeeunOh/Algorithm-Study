package 悼利拌裙过;

import java.util.*;

public class 悼利拌裙过_2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] dp =new int[91][2];
		dp[1][0]=0;
		dp[1][1]=1;
		if (num>1) {
			for (int i=2; i<=90; i++) {
					dp[i][0]=dp[i-1][0]+dp[i-1][1];
					dp[i][1]=dp[i-1][0];
			}
		}
		System.out.println(dp[num][0]+dp[num][1]);
		sc.close();
	}
}

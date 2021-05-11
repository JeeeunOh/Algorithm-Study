package ������ȹ��;

import java.util.*;

public class ������ȹ��_1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			dp[i]=i;
			for(int j=1;j*j<=i;j++) {
				dp[i]=Math.min(dp[i-j*j]+1, dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}

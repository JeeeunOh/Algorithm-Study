package ������ȹ��;

import java.util.*;

public class ������ȹ��_1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		int max=-1000;
		for(int i=1 ; i<=n ; i++) {
			arr[i]=sc.nextInt();
			dp[i]=arr[i];
			dp[i]=Math.max(dp[i-1]+arr[i], dp[i]);
			max=Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}

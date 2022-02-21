package 悼利拌裙过;

import java.util.*;

public class 悼利拌裙过_11054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int[] dp1 = new int[n+1];
		int[] dp2 = new int[n+1];
		int[] arr = new int[n+1];
		int max=0;
		
		for(int i=1;i<=n;i++) {
			arr[i]=sc.nextInt();
			dp[i]=dp1[i]=dp2[i]=1;
		}
		
		for(int  i=1; i<=n; i++) {
				for(int j=1; j<i; j++) {
					if(arr[j]<arr[i]) dp1[i] = Math.max(dp1[i], dp1[j]+1);
					if(arr[n-j+1]<arr[i]) dp2[i]=Math.max(dp2[i], dp2[n-j+1]+1);
					dp[i]=dp1[i]+dp2[i]-1;
					max=Math.max(max,dp[i]);
				}
			}
		System.out.println(max-1);
	}
}

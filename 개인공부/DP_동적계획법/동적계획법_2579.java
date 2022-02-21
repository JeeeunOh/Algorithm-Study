package 悼利拌裙过;

import java.util.Scanner;

public class 悼利拌裙过_2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		int max=0;
		for (int i=1;i<=n;i++) {
			arr[i]=sc.nextInt();
			dp[i]=0;
			if(i==1)
				dp[1]=arr[1];
			else if(i==2)
				dp[2]=arr[1]+arr[2];
			else if(i==3)
				dp[3]=Math.max(arr[1]+arr[3], arr[2]+arr[3]);
			else {
				dp[i]=Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
			}
		}
		System.out.println(dp[n]);
	}
}

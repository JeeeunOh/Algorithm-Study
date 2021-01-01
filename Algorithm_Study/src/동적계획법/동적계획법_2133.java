package 悼利拌裙过;

import java.util.*;

public class 悼利拌裙过_2133 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		for (int i=1;i<=n;i++) {
			if(i%2==1) dp[i]=0;
			else {
				if(i==2) dp[2]=3;
				else if(i==4) dp[2]=11;
				else dp[i]=dp[i-2]*3+dp[i-4]*2;
			}
		}
		System.out.println(dp[n]);
	}
}

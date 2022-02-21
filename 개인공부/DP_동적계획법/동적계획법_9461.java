package 悼利拌裙过;

import java.util.*;

public class 悼利拌裙过_9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp=new int[101];
		
		for(int i=1;i<101;i++) {
			if(i <= 3) dp[i] = 1;
			else if(i <= 5) dp[i] = 2;
			else dp[i] = dp[i-5] + dp[i-1];
		}
		
		int n = sc.nextInt();
		int num;
		for(int i=0 ; i<n ; i++) {
			num = sc.nextInt();
			System.out.println(dp[num]);
		}
	}
}




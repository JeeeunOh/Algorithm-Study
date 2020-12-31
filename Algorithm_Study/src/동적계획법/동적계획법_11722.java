package 悼利拌裙过;

import java.util.*;

public class 悼利拌裙过_11722 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int[] arr = new int[n+1];
		int min=0;
		
		for (int i=1; i< n+1 ; i++) {
			arr[i]=sc.nextInt();
			dp[i]=1;
			if(i>1) {
				for(int j=1;j<i;j++) {
					if(arr[j]>arr[i])
						dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			min=Math.max(min, dp[i]);
		}
		System.out.println(min);
	}
}

package 동적계획법;

import java.util.*;

public class ex11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int[] arr = new int[n+1];
		int max=0;
		
		for (int i=1; i< n+1 ; i++) {
			arr[i]=sc.nextInt();
			dp[i]=1;
			if(i>1) {
				for(int j=1;j<i;j++) {
					if(arr[j]<arr[i])
						dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}

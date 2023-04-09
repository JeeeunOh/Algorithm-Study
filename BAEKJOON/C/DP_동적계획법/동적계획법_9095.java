package 悼利拌裙过;

import java.util.Scanner;

public class 悼利拌裙过_9095 {
	
	public static void main(String[] args) {
        int[] dp = new int[12];
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i=0; i<num; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n+1];
			if (n == 1) {
	            System.out.println(1);
	        } else if( n == 2){
	            System.out.println(2);
	        } else if (n==3){
	        	System.out.println(4);
	        } else {
	            dp[1] = 1;
	            dp[2] = 2;
	            dp[3] = 4;
	            for (int j = 4; j < dp.length; j++) {
	                dp[j] = dp[j-1]+dp[j-2]+dp[j-3];
	            }
	            System.out.println(dp[n]);
	        }
		}
	}	
}
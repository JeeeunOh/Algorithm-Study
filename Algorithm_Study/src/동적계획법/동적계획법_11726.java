package 悼利拌裙过;

import java.util.*;

public class 悼利拌裙过_11726 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		if (n == 1) {
            System.out.println(1);
        }else if( n == 2){
            System.out.println(2);
        } else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
            }
            System.out.println(dp[n] % 10007);
        }
    }
}
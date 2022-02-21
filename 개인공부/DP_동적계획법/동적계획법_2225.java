package 悼利拌裙过;

import  java.util.*;

public class 悼利拌裙过_2225 {
	static int mod = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int K = sc.nextInt();
		int[][] dp = new int[201][201];
		
		for(int i=0;i<=N;i++) dp[1][i]=1;
	    for(int k=2;k<=K;k++){
	        for(int n=0;n<=N;n++){
	            for(int l=0;l<=n;l++) dp[k][n]+=dp[k-1][l];
	            dp[k][n]%=mod;
	        }
	    }
		System.out.println(dp[K][N]);
	}
}
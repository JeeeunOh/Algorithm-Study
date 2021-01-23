package 동적계획법_초급;
/*
 * 15배수 : 각 자리의 합이 3의 배수이면서 일의자리가 0또는5 -> 일의자리 5
- N : 4
 ->   - - - 5
 - N : 5
 ->   - - - - 5 
 */
import java.util.*;

public class ex20500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[1516];
		dp[0]=dp[1]=0;
		dp[2]=dp[3]=1;
		for (int i=1 ; i<=N ; i++) {
			dp[i]=0;
		}
	}
}

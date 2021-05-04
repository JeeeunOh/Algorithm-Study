package ������ȹ��;

import java.util.Scanner;

public class ex1003{
 
	static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		dp[0][0] = 1;	// N=0 �� ���� 0 ȣ�� Ƚ��
		dp[0][1] = 0;	// N=0 �� ���� 1 ȣ�� Ƚ��
		dp[1][0] = 0;	// N=1 �� ���� 0 ȣ�� Ƚ��
		dp[1][1] = 1;	// N=1 �� ���� 1 ȣ�� Ƚ��
		
		int T = in.nextInt();
        
		while(T-- > 0){
			int N = in.nextInt();
			fibonacci(N);
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
		
	}
	
	static Integer[] fibonacci(int N) {
		// N�� ���� 0, 1�� ȣ�� Ƚ���� ���� ��(Ž������ ���� ���� ��)
		if(dp[N][0] == null || dp[N][1] == null) {
			// �� N�� ���� 0 ȣ�� Ƚ���� 1 ȣ�� Ƚ���� ���ȣ���Ѵ�.
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
		// N�� ���� 0�� 1, �� [N][0]�� [N][1] �� ����ִ� [N]�� ��ȯ�Ѵ�.
		return dp[N];
 
	}
 
}
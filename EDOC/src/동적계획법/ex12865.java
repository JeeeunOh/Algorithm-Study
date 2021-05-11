package ������ȹ��;

import java.util.*;

public class ex12865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt(); // ��ǰ ��
		int W = sc.nextInt(); //��ƿ �� �ִ� ����
		int[][] input = new int[N+1][2];
		
		for(int i=1;i<=N;i++) { //i��° ������
			input[i][0]=sc.nextInt(); // ����
			input[i][1]=sc.nextInt(); // ��ġ
		}
		
		int[][] dp = new int[N+1][W+1]; // dp[N��°���� Ž������ �� ][�ش� ���Կ�����] = �ִ� ��ġ
		for(int i=1;i<=N;i++) {//i��° ������ �������� dp ����
			int w = input[i][0], val=input[i][1]; //���Կ� ��ġ�� ���� i��° ����, ��ġ�� ������
			for(int j=1;j<=W;j++) { //��ƿ �� �ִ� ���Ա��� ���Ը� �ø��鼭 �ش� ���Կ����� �ִ� ��ġ�� ã��
				if(j<w) dp[i][j]=dp[i-1][j]; //��ƿ�� �ִ� ���Ժ��� �־�� �ϴ� ������ ���̴ٸ�, ���� ����
				else dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w]+val); // ������ �ʴٸ�, �ִ� ���� ���� �ʴ� ��� �� �� ū ��ġ�� ���� dp�� ������
			}
		}
		System.out.println(dp[N][W]);
	}
}
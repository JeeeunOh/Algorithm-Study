package ������ȹ��_�ʱ�;
/*
 * 15��� : �� �ڸ��� ���� 3�� ����̸鼭 �����ڸ��� 0�Ǵ�5 -> �����ڸ� 5
- N : 4
 ->   - - - 5
 - N : 5
 ->   - - - - 5 
 */
import java.util.*;

public class ex20500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 1000000007;
		int N = sc.nextInt();
		long[][] arr = new long[3][1516]; //[3���� ������ �� ������][���ڱ���]
		arr[1][1]=1;arr[2][1]=1; //1%3==1, 5%3==2;
		for(int i=2 ; i<N ; i++) {
			arr[0][i]=(arr[1][i-1]+arr[2][i-1])%mod;
			arr[1][i]=(arr[0][i-1]+arr[2][i-1])%mod;
			arr[2][i]=(arr[0][i-1]+arr[1][i-1])%mod;
		}
		System.out.println(arr[1][N-1]);
	}
}

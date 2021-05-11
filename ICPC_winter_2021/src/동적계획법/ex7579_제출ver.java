package ������ȹ��;
import java.util.*;

public class ex7579_����ver{
	static int N, M;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] bt = new int[N];
		int[] ct = new int[N];
		for(int i=0; i<N; i++) bt[i] = sc.nextInt();
		for(int i=0; i<N; i++) ct[i] = sc.nextInt();

		// dp �迭 �ʱ�ȭ
		int[] dp = new int[10001];
		Arrays.fill(dp, -1);
		
		// dp[i]: i cost�� �Ἥ Ȯ���� �� �ִ� �ִ� �޸�
		for(int i=0; i<N; i++){
			int cost = ct[i];
			for(int j=10000; j>=cost; j--){
				if(dp[j-cost] != -1){ 
					if(dp[j-cost] + bt[i] > dp[j]) dp[j] = dp[j-cost] + bt[i]; // ���� j-cost ������ �ִ� ���� ����bt�� ���ϴ°� �� ũ�ٸ� update
				}
			}
			if(dp[cost] < bt[i]) dp[cost] = bt[i]; //�޸� ������Ʈ�� �ȵǾ��ִ� ��� ������Ʈ( �� �޸𸮰� �� ū ��쿡�� ������Ʈ ���� )
		}
		for(int i=0; i<10001; i++){
			if(dp[i] >= M){
				System.out.println(i);
				break;
			}
		}
	}
}
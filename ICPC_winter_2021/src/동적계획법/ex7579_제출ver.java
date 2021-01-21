package 동적계획법;
import java.util.*;

public class ex7579_제출ver{
	static int N, M;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] bt = new int[N];
		int[] ct = new int[N];
		for(int i=0; i<N; i++) bt[i] = sc.nextInt();
		for(int i=0; i<N; i++) ct[i] = sc.nextInt();

		// dp 배열 초기화
		int[] dp = new int[10001];
		Arrays.fill(dp, -1);
		
		// dp[i]: i cost를 써서 확보할 수 있는 최대 메모리
		for(int i=0; i<N; i++){
			int cost = ct[i];
			for(int j=10000; j>=cost; j--){
				if(dp[j-cost] != -1){ 
					if(dp[j-cost] + bt[i] > dp[j]) dp[j] = dp[j-cost] + bt[i]; // 이전 j-cost 까지의 최대 값에 현재bt을 더하는게 더 크다면 update
				}
			}
			if(dp[cost] < bt[i]) dp[cost] = bt[i]; //메모리 업데이트가 안되어있는 경우 업데이트( 단 메모리가 더 큰 경우에만 업데이트 가능 )
		}
		for(int i=0; i<10001; i++){
			if(dp[i] >= M){
				System.out.println(i);
				break;
			}
		}
	}
}
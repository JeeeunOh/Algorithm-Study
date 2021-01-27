package 동적계획법;

import java.util.*;

public class ex12865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt(); // 물품 수
		int W = sc.nextInt(); //버틸 수 있는 무게
		int[][] input = new int[N+1][2];
		
		for(int i=1;i<=N;i++) { //i번째 물건의
			input[i][0]=sc.nextInt(); // 무게
			input[i][1]=sc.nextInt(); // 가치
		}
		
		int[][] dp = new int[N+1][W+1]; // dp[N번째까지 탐색했을 때 ][해당 무게에서의] = 최대 가치
		for(int i=1;i<=N;i++) {//i번째 물건을 기준으로 dp 설정
			int w = input[i][0], val=input[i][1]; //무게와 가치를 각각 i번째 무게, 가치로 설정함
			for(int j=1;j<=W;j++) { //버틸 수 있는 무게까지 무게를 올리면서 해당 무게에서의 최대 가치를 찾음
				if(j<w) dp[i][j]=dp[i-1][j]; //버틸수 있는 무게보다 넣어야 하는 물건이 무겁다면, 넣지 못함
				else dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w]+val); // 무겁지 않다면, 넣는 경우와 넣지 않는 경우 중 더 큰 가치를 가진 dp를 저장함
			}
		}
		System.out.println(dp[N][W]);
	}
}
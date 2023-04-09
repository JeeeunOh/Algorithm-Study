package 벨만포드_플로이드와샬;

import java.util.*;

public class ex1389 {
	    static int N,M;
	    static int dp[][];
	    static int[][] map;
	    static Queue<Integer> q = new LinkedList<>();
	    static int minCnt = Integer.MAX_VALUE;
	    static int min;
	    
	    public static void main (String[] args) {
	    	Scanner sc = new Scanner(System.in);
	        N = sc.nextInt(); // 유저 수
	        M = sc.nextInt(); // 친구 수
	        dp = new int[N+1][N+1]; // 몇번만에 연결되는지
	        map = new int[N+1][N+1]; // 누구랑 누가 연결되어 있는지
	        // 배열 초기화
	        for (int i = 1; i <= N; i++)  Arrays.fill(dp[i], -1); 
	        // 연결관계 1 표시
	        for (int i = 0; i < M; i++) {
	            int p1 = sc.nextInt(), p2 = sc.nextInt();
	            map[p1][p2] = map[p2][p1] = 1;
	        }
	        for (int i = N; i >= 1; i--)  solve(i); 
	        System.out.println(min);
	    }
	    static void solve(int start) {
	        dp[start][start] = 0;
	        q.add(start);
	        while(!q.isEmpty()) {
	            int cur = q.poll(); // 현재 계산할 사람 뽑아냄
	            for (int i = 1; i <= N; i++) {
	                if(map[cur][i] == 0 || dp[start][i] != -1) continue; // 만약 연결되어 있지 않은 사람이면 넘김
	                dp[start][i] = dp[start][cur] +1; // 아니라면 사실관계 하나 더함
	                q.add(i); // 계산 끝난 사람 큐에 집어넣음
	            }
	        }
	        int sum = 0;
	        for (int i = 1; i <= N; i++)  sum += dp[start][i];
	        if(minCnt >= sum ) {
	            minCnt = sum;
	            min = start;
	        }
	    }
	}
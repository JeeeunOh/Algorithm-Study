package ��������_�÷��̵�ͼ�;

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
	        N = sc.nextInt(); // ���� ��
	        M = sc.nextInt(); // ģ�� ��
	        dp = new int[N+1][N+1]; // ������� ����Ǵ���
	        map = new int[N+1][N+1]; // ������ ���� ����Ǿ� �ִ���
	        // �迭 �ʱ�ȭ
	        for (int i = 1; i <= N; i++)  Arrays.fill(dp[i], -1); 
	        // ������� 1 ǥ��
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
	            int cur = q.poll(); // ���� ����� ��� �̾Ƴ�
	            for (int i = 1; i <= N; i++) {
	                if(map[cur][i] == 0 || dp[start][i] != -1) continue; // ���� ����Ǿ� ���� ���� ����̸� �ѱ�
	                dp[start][i] = dp[start][cur] +1; // �ƴ϶�� ��ǰ��� �ϳ� ����
	                q.add(i); // ��� ���� ��� ť�� �������
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
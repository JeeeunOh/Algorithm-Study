package ������ȹ��;

	import java.io.*;
	import java.util.*;

	public class ex1949 {
		static int N;
		static int[][] dp;
		static int[] citizen;
		static boolean[] visit;
		static ArrayList<Integer>[] edgeList;
		
		public static void main(String[] args) throws IOException {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			citizen = new int[N+1];
			edgeList = new ArrayList[N+1];
			visit = new boolean[N+1];
			
			for (int i = 1; i <= N; ++i) {
				citizen[i] = sc.nextInt(); 
				edgeList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N-1; ++i) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				edgeList[from].add(to);
				edgeList[to].add(from);
			}
			
			dp = new int[N+1][2];
			/* 
			    dp[i][0] = i��° ������ ��� ����O -> ��� ������ �ֹ� �� Max
			             =>  i+1��° ������ ��� ���� x
			              
			    dp[i][1] = i��° ������ �������X -> ��� ������ �ֹ� �� Max
			             =>  i+1��° ������ ��� ���� O or X
			*/
			
			visit[1] = true;
			getMaxCitizen(1);
			System.out.println(Math.max(dp[1][0], dp[1][1]));
		}
		
		public static void getMaxCitizen(int v) { //DFS
			for (int i = 0; i < edgeList[v].size(); ++i) { // ����Ʈ ����� ��� Ž��
				int nv = edgeList[v].get(i); //����Ʈ���� ���� ������
				
				if (visit[nv]) continue; // �湮�� �� ������ �ѱ��
				visit[nv] = true; // �湮�� �� ������ ����ϱ�

				getMaxCitizen(nv); //���� ��� ���� Ž��
				
				dp[v][0] += dp[nv][1];
				dp[v][1] += Math.max(dp[nv][0], dp[nv][1]);
			}
	        //v��° ������ ��� ������ ������ ��� �ù��� ���� ����
			dp[v][0] += citizen[v];
		}
	}
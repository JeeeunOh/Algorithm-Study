package 동적계획법;

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
			    dp[i][0] = i번째 마을이 우수 마을O -> 우수 마을의 주민 수 Max
			             =>  i+1번째 마을은 우수 마을 x
			              
			    dp[i][1] = i번째 마을이 우수마을X -> 우수 마을의 주민 수 Max
			             =>  i+1번째 마을은 우수 마을 O or X
			*/
			
			visit[1] = true;
			getMaxCitizen(1);
			System.out.println(Math.max(dp[1][0], dp[1][1]));
		}
		
		public static void getMaxCitizen(int v) { //DFS
			for (int i = 0; i < edgeList[v].size(); ++i) { // 리스트 사이즈를 계속 탐색
				int nv = edgeList[v].get(i); //리스트에서 원소 꺼내옴
				
				if (visit[nv]) continue; // 방문한 적 있으면 넘기고
				visit[nv] = true; // 방문한 적 없으면 계속하기

				getMaxCitizen(nv); //다음 노드 가서 탐색
				
				dp[v][0] += dp[nv][1];
				dp[v][1] += Math.max(dp[nv][0], dp[nv][1]);
			}
	        //v번째 마을을 우수 마을로 선정할 경우 시민의 수를 더함
			dp[v][0] += citizen[v];
		}
	}
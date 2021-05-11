package 다익스트라_플와_210217;

import java.util.*;

public class ex11780 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 도시 개수
		int m = sc.nextInt(); // 버스 개수
		int[][] d = new int [n + 1][n + 1];
		int[][] next = new int[n + 1][n + 1];
		final int INF = 10000001; // 비용 최대치 설정해놓기
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], INF); // 한 마을에서 한 마을로 가는 비용 최대로 설정
			d[i][i] = 0; // i에서 i로 가는 비용 0
		}
		
		for (int i = 0; i < m; i ++) {
			int start = sc.nextInt(),end = sc.nextInt(),cost = sc.nextInt();
			// start 도시에서 end도시까지 드는 비용 cost
			d[start][end] = Math.min(d[start][end], cost); //start에서 end로 가는 최소 비용 갱신
			next[start][end] = end; 
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					//직선으로 가는 경우가 없는경우, 우회해서 가는게 더 빠른경우 갱신
					if (d[i][j] > d[i][k] + d[k][j]) { 
						d[i][j] = d[i][k] + d[k][j]; 
						next[i][j] = next[i][k]; 
					}
				}
			}
		}
		
		/*
		그 다음에는 n×n개의 줄을 출력해야 한다.
		 -> 그 다음, 도시 i에서 도시 j로 가는 경로를 공백으로 구분해 출력한다. 
		  -> 이때, 도시 i와 도시 j도 출력해야 한다. 만약, i에서 j로 갈 수 없는 경우에는 0을 출력한다.
		 */
		
		// 도시 i에서 j로 가는데 필요한 최소 비용 출력
		// 처음 초기화 값 그대로 일 떄는 경로가 없다는 것이므로 0으로 바꿔준다.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == INF)  d[i][j] = 0; 
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		} 
		
		 // i×n+j번째 줄에는 도시 i에서 도시 j로 가는 최소 비용에 포함되어 있는 도시의 개수 k를 출력한다. 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == 0) { // i에서 i로 가는 비용 x -> 0 출력
					System.out.println("0");
					continue;
				}
				ArrayList<Integer> path = new ArrayList<>();
				int cur = i; // i부터 시작
				while (cur != j) { // 끝 지점인 j에 도착하기 전까지
					path.add(cur); // 현재 지점 추가하고
					cur = next[cur][j]; // 다음 cur 지정
				}
				path.add(cur); // 마지막 지점 마저 넣어주고
				System.out.print(path.size() + " "); // 배열 사이즈 출력한 후
				for (int p : path)  System.out.print(p + " ");  // 중간지점들 다 출력
				System.out.println();
			}
		}
	}
}
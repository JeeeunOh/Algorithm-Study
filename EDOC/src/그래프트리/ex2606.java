package 그래프트리;

import java.io.*;
import java.util.*;
// 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
public class ex2606 {
	private static int N;
	private static int arr[][];
	private static boolean visit[];
	private static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int com;
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		com = Integer.parseInt(br.readLine()); // 네트워크 상 연결된 컴퓨터 쌍
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<=com; i++) { // 어떤 컴퓨터들 끼리 연결되어 있는지 확인
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 1번 컴퓨터 바이러스 걸린 것 표현 -> 큐에 1번 컴 집어넣기
		queue.offer(1);
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			// 큐가 비어있지 않다면 큐에서 하나 꺼냄 -> 현재 탐색 컴 번호 설정해줌
			int cur = queue.poll();
			
			for(int i=1; i<=N; i++) {
				// 현재 컴과 방문 컴이 연결되어있고, 방문 컴
				if(arr[cur][i]==1 && !visit[i]) {
					queue.offer(i); // 큐에 바이러스 걸린 컴 번호 넣어줌
					visit[i]=true;
					result++; // 바이러스 컴 갯수 추가해줌
				}
			}
		}
		System.out.println(result);
	}
}

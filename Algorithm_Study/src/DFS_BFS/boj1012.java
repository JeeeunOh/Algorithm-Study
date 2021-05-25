package DFS_BFS;

import java.util.*;

public class boj1012{
	static int M, N, K;
	static int[][] arr;
	static boolean[][] visit;
	static int count;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void dfs(int x, int y) {
		visit[x][y] = true;//(x,y)좌표 방문했음을 체크

		for (int i = 0; i < 4; i++) { //(x,y)좌표 기준 상하좌우 네 방향 체크 ( 문제 조건)
			int cx = x + dx[i]; // 해당 좌표를 (cx, cy)라고 가정
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < M && cy < N) // 해당 cx, cy 좌표가 밭의 면적 안에 있고
				if (!visit[cx][cy] && arr[cx][cy] == 1) // 해당 (cx, cy)좌표를 방문한 적이 없고 해당 좌표에 배추가 있다면
					dfs(cx, cy);// 해당 좌표 기준 탐색
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // 테스트케이스 개수 입력

		for (int i = 0; i < tc; i++) { // 해당 개수만큼 케이스 입력 받음
			count = 0; // 정답으로 출력할 count 0으로 초기화
			M = sc.nextInt(); N = sc.nextInt(); // 가로길이와 세로길이 입력 받음
			arr = new int[M][N]; // 입력받은 가로세로 길이 만큼 땅 배열 생성
			visit = new boolean[M][N]; // 해당 땅 방문여부 확인 배열

			K = sc.nextInt();
			for (int j = 0; j < K; j++) {
				int x = sc.nextInt(); 
				int y = sc.nextInt();
				arr[x][y] = 1; //(x,y)좌표에 배추가 심어져있음
			}

			for (int x = 0; x < M; x++) { // 모든 좌표 탐색하면서
				for (int y = 0; y < N; y++) {
					if (arr[x][y] == 1 && !visit[x][y]) { //(x,y)좌표에 배추가 심어져 있고 해당 좌표에 방문하지 않았다면
						dfs(x, y); // 해당 좌표 기준 dfs 탐색
						count++; // 지렁이 수 ++
					}
				}
			}
			System.out.println(count); // 최종적인 배추흰지렁이 수 출력
		}
	}
}

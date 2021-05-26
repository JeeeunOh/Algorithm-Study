package 다익스트라플와;

import java.util.*;

public class ex14496{
	static int start, end,N,M;
	static int[][] map;
	static int answer = -1; // 치환 불가능한 경우로 세팅해놓기
	static boolean[] visited;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		start = sc.nextInt(); end = sc.nextInt();// 시작점 끝점
		N = sc.nextInt(); M = sc.nextInt(); // 전체문자의 수, 치환가능 문자쌍 수
		
		map = new int[N+1][N+1]; // 서로 치환 가능한지 확인 배열
		visited = new boolean[N+1]; // 방문 확인 배열
		
		int a=0,b=0;
		
		for(int i=0;i<M;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			map[a][b] = map[b][a] = 1; // a와 b가 연결되어있음 저장
			
			if(a == start) { // 입력받은 a가  start 점이면
				queue.add(new int[] {b,1}); // 연결된 b를 큐에 집어넣고
				visited[b] = true; // b기준 탐색할테니 b 방문했다고 표시
			}if(b == start) {
				queue.add(new int[] {a,1});
				visited[a] = true;
			}
		}
		if(start!=end) bfs(); 
		else answer = 0; //start==end 이면 치환할 필요가 없으므로 0
		
		System.out.println(answer);
		sc.close();
	}
	static void bfs() {
		while(!queue.isEmpty()) { // 큐가 비어있지 않으면 탐색할 것이 있으므로 반복문 계속한다.
			int[] now = queue.poll(); // 탐색할 것을 큐에서 빼냄
			// 여기서 now[0]은 탐색할 것, now[1]은 탐색횟수 의미
			if(now[0] == end) { //탐색한 숫자가 now[0]이면
				answer = now[1]; // 탐색횟수로 answer 정하고 리턴
				return;
			}
			for(int i=1;i<=N;i++) { // //탐색한 숫자가 now[0]이 아니면 계속 탐색
				if(map[now[0]][i] == 1 && visited[i] == false) { // 현재 탐색 숫자와 i가 치환가능하고, i를 방문한적이 없다면
					visited[i] = true; //i 탐색시작
					queue.add(new int[] {i,now[1]+1}); // 큐에 i와 i탐색횟수+1해서 집어넣음 -> 다음 탐색때 사용하기 위해
				}
			}
		}
	}
}
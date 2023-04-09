package 그래프;

// 한 노드 봤을 떄, 연결된 인접 노드의 절반 이상이 루머 믿고 있다면, 해당 노드도 루머 믿고
// 노드별로 루머를 믿게 된 시간 출력

import java.io.*;
import java.util.*;

public class ex19538_루머 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list[] = new LinkedList[N + 1]; // N번 사람과 연결된 사람들
		int[] rumor = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			int idx = 0;
			String[] input = br.readLine().split(" ");
			int temp = Integer.parseInt(input[idx]); // n번 사람과 연결된 idx번째 사람 temp 에 넣음
			list[i] = new LinkedList<Integer>();
			while(temp != 0) {
				list[i].addFirst(temp); // i번째 사람과 연결된 사람들 하나씩 리스트에 집어넣음
				temp = Integer.parseInt(input[++idx]);
			}
			rumor[i] = -1; // 루머시간초기화
		}
		int M = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		Queue<Calc> queue = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			int temp = Integer.parseInt(input[i]);
			queue.offer(new Calc(temp, 0));
			rumor[temp] = 0; // temp 가 루머 믿는 시간 저장
		}
		while (!queue.isEmpty()) { // 큐가 비어있지 않다면
			Calc temp = queue.poll(); // 큐의 제일 앞에서 빼내와서
			for (Integer j : list[temp.num]) { // temp와 연결된 노드 개수만큼 밑의 작업 반복함
				if (rumor[j] == -1) {
					int cnt = 0;
					for (Integer i : list[j]) {
						if (rumor[i] != -1 && rumor[i] < temp.time + 1) // 루머믿는 시간이 현재시간보다 작으면
							cnt++; // 카운트 더해줌
					}
					if ((list[j].size() + 1) / 2 <= cnt) { 
						rumor[j] = temp.time + 1;
						queue.offer(new Calc(j, temp.time + 1));
					}
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1; i <= N; i++)
			bw.write(rumor[i]+" ");
		bw.flush();
		return;
	}

	static class Calc{
		int num;
		int time;
		public Calc(int num, int level) {
			this.num = num;
			this.time = level;
		}
	}
}
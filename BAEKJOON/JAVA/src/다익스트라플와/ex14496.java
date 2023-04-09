package ���ͽ�Ʈ���ÿ�;

import java.util.*;

public class ex14496{
	static int start, end,N,M;
	static int[][] map;
	static int answer = -1; // ġȯ �Ұ����� ���� �����س���
	static boolean[] visited;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		start = sc.nextInt(); end = sc.nextInt();// ������ ����
		N = sc.nextInt(); M = sc.nextInt(); // ��ü������ ��, ġȯ���� ���ڽ� ��
		
		map = new int[N+1][N+1]; // ���� ġȯ �������� Ȯ�� �迭
		visited = new boolean[N+1]; // �湮 Ȯ�� �迭
		
		int a=0,b=0;
		
		for(int i=0;i<M;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			map[a][b] = map[b][a] = 1; // a�� b�� ����Ǿ����� ����
			
			if(a == start) { // �Է¹��� a��  start ���̸�
				queue.add(new int[] {b,1}); // ����� b�� ť�� ����ְ�
				visited[b] = true; // b���� Ž�����״� b �湮�ߴٰ� ǥ��
			}if(b == start) {
				queue.add(new int[] {a,1});
				visited[a] = true;
			}
		}
		if(start!=end) bfs(); 
		else answer = 0; //start==end �̸� ġȯ�� �ʿ䰡 �����Ƿ� 0
		
		System.out.println(answer);
		sc.close();
	}
	static void bfs() {
		while(!queue.isEmpty()) { // ť�� ������� ������ Ž���� ���� �����Ƿ� �ݺ��� ����Ѵ�.
			int[] now = queue.poll(); // Ž���� ���� ť���� ����
			// ���⼭ now[0]�� Ž���� ��, now[1]�� Ž��Ƚ�� �ǹ�
			if(now[0] == end) { //Ž���� ���ڰ� now[0]�̸�
				answer = now[1]; // Ž��Ƚ���� answer ���ϰ� ����
				return;
			}
			for(int i=1;i<=N;i++) { // //Ž���� ���ڰ� now[0]�� �ƴϸ� ��� Ž��
				if(map[now[0]][i] == 1 && visited[i] == false) { // ���� Ž�� ���ڿ� i�� ġȯ�����ϰ�, i�� �湮������ ���ٸ�
					visited[i] = true; //i Ž������
					queue.add(new int[] {i,now[1]+1}); // ť�� i�� iŽ��Ƚ��+1�ؼ� ������� -> ���� Ž���� ����ϱ� ����
				}
			}
		}
	}
}
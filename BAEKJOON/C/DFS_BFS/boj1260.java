package DFS_BFS;

import java.util.*;

public class boj1260 {
	
	private static int N, M, V; 
	private static int[][] graph; 
	private static boolean[] check; 
	
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		V = sc.nextInt(); 
		graph = new int[N + 1][N + 1]; // �׷��� ��� ���� �������
		check = new boolean[N + 1]; // �ش� ���� �湮�ߴ��� Ȯ�� ���� �迭
		for (int i = 0; i < M; i++) { 
			int x = sc.nextInt(); //����� ���� x�� y �Է¹ް�
			int y = sc.nextInt(); 
			graph[x][y] = 1; graph[y][x] = 1; // ���� ����Ǿ������� graph�迭�� ����
		}
		dfs(V); 
		System.out.println(); 
		Arrays.fill(check, false); // check �迭 �ʱ�ȭ 
		bfs(V);
	}
	public static void dfs(int start) { 
		check[start] = true; // start���� �湮������ ǥ��
		System.out.print(start + " "); 
		for (int i = 1; i < N + 1; i++) { // 1������ N-1�� �������� �湮�ϸ鼭
			if (graph[start][i] == 1 && !check[i]) dfs(i); 
			// �ش� ������ start�� ����Ǿ��ְ�, �ش� ������ �湮�� ���� ���ٸ�, �ش� ���� ���� dfs Ž��
		}
	}
	// ���⼭���ʹ� bfsŽ������ �Ŀ� bfsƯ������ ���� ������ �������ּ���
	public static void bfs(int start) { 
		Queue<Integer> q = new LinkedList<>();  // bfs Ž�� ���� ť�� �ϳ� �����
		q.offer(start); // ť�� ���� start�� �߰�
		check[start] = true;  // start�� �湮�ߴٰ� üũ
		while (!q.isEmpty()) { //ť ���� ������ ������ ������ �ݺ�
			int vertex = q.poll(); // ť�� �տ��� ���� vertex ����
			System.out.print(vertex + " "); 
			for (int i = 1; i < N + 1; i++) { // 1������ N-1�� �������� �湮�ϸ鼭
				if (graph[vertex][i] == 1 && !check[i]) { 
					q.offer(i); 
					check[i] = true;
				} // �ش� ������ vertex�� ����Ǿ��ְ�, �ش� ������ �湮�� ���� ���ٸ� �湮������ üũ�ϰ� �ش� ������ ť�� �߰��Ѵ�.
			}
		}
	}
}

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
		visit[x][y] = true;//(x,y)��ǥ �湮������ üũ

		for (int i = 0; i < 4; i++) { //(x,y)��ǥ ���� �����¿� �� ���� üũ ( ���� ����)
			int cx = x + dx[i]; // �ش� ��ǥ�� (cx, cy)��� ����
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < M && cy < N) // �ش� cx, cy ��ǥ�� ���� ���� �ȿ� �ְ�
				if (!visit[cx][cy] && arr[cx][cy] == 1) // �ش� (cx, cy)��ǥ�� �湮�� ���� ���� �ش� ��ǥ�� ���߰� �ִٸ�
					dfs(cx, cy);// �ش� ��ǥ ���� Ž��
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // �׽�Ʈ���̽� ���� �Է�

		for (int i = 0; i < tc; i++) { // �ش� ������ŭ ���̽� �Է� ����
			count = 0; // �������� ����� count 0���� �ʱ�ȭ
			M = sc.nextInt(); N = sc.nextInt(); // ���α��̿� ���α��� �Է� ����
			arr = new int[M][N]; // �Է¹��� ���μ��� ���� ��ŭ �� �迭 ����
			visit = new boolean[M][N]; // �ش� �� �湮���� Ȯ�� �迭

			K = sc.nextInt();
			for (int j = 0; j < K; j++) {
				int x = sc.nextInt(); 
				int y = sc.nextInt();
				arr[x][y] = 1; //(x,y)��ǥ�� ���߰� �ɾ�������
			}

			for (int x = 0; x < M; x++) { // ��� ��ǥ Ž���ϸ鼭
				for (int y = 0; y < N; y++) {
					if (arr[x][y] == 1 && !visit[x][y]) { //(x,y)��ǥ�� ���߰� �ɾ��� �ְ� �ش� ��ǥ�� �湮���� �ʾҴٸ�
						dfs(x, y); // �ش� ��ǥ ���� dfs Ž��
						count++; // ������ �� ++
					}
				}
			}
			System.out.println(count); // �������� ������������ �� ���
		}
	}
}

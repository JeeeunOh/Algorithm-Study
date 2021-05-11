package �׷���Ʈ��_210210;

import java.io.*;
import java.util.*;
// 1�� ��ǻ�Ͱ� �� ���̷����� �ɷ��� ��, 1�� ��ǻ�͸� ���� �� ���̷����� �ɸ��� �Ǵ� ��ǻ���� ��
public class ex2606 {
	private static int N;
	private static int arr[][];
	private static boolean visit[];
	private static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int com;
		
		N = Integer.parseInt(br.readLine()); // ��ǻ�� ��
		com = Integer.parseInt(br.readLine()); // ��Ʈ��ũ �� ����� ��ǻ�� ��
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<=com; i++) { // � ��ǻ�͵� ���� ����Ǿ� �ִ��� Ȯ��
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 1�� ��ǻ�� ���̷��� �ɸ� �� ǥ�� -> ť�� 1�� �� ����ֱ�
		queue.offer(1);
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			// ť�� ������� �ʴٸ� ť���� �ϳ� ���� -> ���� Ž�� �� ��ȣ ��������
			int cur = queue.poll();
			
			for(int i=1; i<=N; i++) {
				// ���� �İ� �湮 ���� ����Ǿ��ְ�, �湮 ��
				if(arr[cur][i]==1 && !visit[i]) {
					queue.offer(i); // ť�� ���̷��� �ɸ� �� ��ȣ �־���
					visit[i]=true;
					result++; // ���̷��� �� ���� �߰�����
				}
			}
		}
		System.out.println(result);
	}
}

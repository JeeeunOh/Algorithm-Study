package �׷���;

// �� ��� ���� ��, ����� ���� ����� ���� �̻��� ��� �ϰ� �ִٸ�, �ش� ��嵵 ��� �ϰ�
// ��庰�� ��Ӹ� �ϰ� �� �ð� ���

import java.io.*;
import java.util.*;

public class ex19538_��� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list[] = new LinkedList[N + 1]; // N�� ����� ����� �����
		int[] rumor = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			int idx = 0;
			String[] input = br.readLine().split(" ");
			int temp = Integer.parseInt(input[idx]); // n�� ����� ����� idx��° ��� temp �� ����
			list[i] = new LinkedList<Integer>();
			while(temp != 0) {
				list[i].addFirst(temp); // i��° ����� ����� ����� �ϳ��� ����Ʈ�� �������
				temp = Integer.parseInt(input[++idx]);
			}
			rumor[i] = -1; // ��ӽð��ʱ�ȭ
		}
		int M = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		Queue<Calc> queue = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			int temp = Integer.parseInt(input[i]);
			queue.offer(new Calc(temp, 0));
			rumor[temp] = 0; // temp �� ��� �ϴ� �ð� ����
		}
		while (!queue.isEmpty()) { // ť�� ������� �ʴٸ�
			Calc temp = queue.poll(); // ť�� ���� �տ��� �����ͼ�
			for (Integer j : list[temp.num]) { // temp�� ����� ��� ������ŭ ���� �۾� �ݺ���
				if (rumor[j] == -1) {
					int cnt = 0;
					for (Integer i : list[j]) {
						if (rumor[i] != -1 && rumor[i] < temp.time + 1) // ��ӹϴ� �ð��� ����ð����� ������
							cnt++; // ī��Ʈ ������
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
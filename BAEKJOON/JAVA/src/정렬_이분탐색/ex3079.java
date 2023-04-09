package ����_�̺�Ž��;
/* https://maivve.tistory.com/145 ����
 * �ɻ�� ����ٰ� �ٷ� �ɻ� x, ���������� ���鼭 �ٷ� �Ȱ��� �ȴ�.
 �̺�Ž�� : �ذ��� ���丷 ���鼭 ���� ���� ������ ���
 = ��Ȯ�� �� �˻� & ���簪 �˻�
 */
import java.io.*;
import java.util.*;

public class ex3079 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int[] times = new int[n];
		for (int i = 0; i < n; i++) {
			times[i] = Integer.valueOf(br.readLine());
		}
		System.out.println(solution(m, times));
	}

	public static long solution(int n, int[] times) {
		long min = 1; // �ּ� �ð�
		long max = (long) times[times.length - 1] * n; // �ִ�ð� (int*int �̱� ������ long ��ȯ �ʿ�)

		while (min <= max) {
			long mid = (min + max) / 2;
			long sum = 0;
			for (int i = 0; i < times.length; i++) 
				sum += (mid / times[i]); // mid�ð��� �� �Ѹ�� ���� �� �ִ� ����� ��

			if (sum >= n) max = mid - 1; 
			else min = mid + 1;
		}
		return min;
	}
}





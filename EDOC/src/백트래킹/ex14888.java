package ��Ʈ��ŷ;

import java.util.Scanner;
 
public class ex14888{
	public static int MAX = Integer.MIN_VALUE;	// �ִ� 
	public static int MIN = Integer.MAX_VALUE;	// �ּڰ� 
	public static int[] operator = new int[4];	// ������ ���� 
	public static int[] number;					// ���� 
	public static int N;						// ���� ���� 
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		number = new int[N];
		
		// ���� �Է�
		for (int i = 0; i < N; i++) {
			number[i] = in.nextInt();
		}
 
		// ������ �Է�
		for (int i = 0; i < 4; i++) operator[i] = in.nextInt();
 
		dfs(number[0], 1);
 
		System.out.println(MAX);
		System.out.println(MIN);
 
	}
 
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			// ������ ������ 1�� �̻��� ���
			if (operator[i] > 0) {
 
				// �ش� �����ڸ� 1 ���ҽ�Ų��.
				operator[i]--;
 
				switch (i) {
 
				case 0:	dfs(num + number[idx], idx + 1);	break;
				case 1:	dfs(num - number[idx], idx + 1);	break;
				case 2:	dfs(num * number[idx], idx + 1);	break;
				case 3:	dfs(num / number[idx], idx + 1);	break;
 
				}
				// ���ȣ���� ����Ǹ� �ٽ� �ش� ������ ������ �����Ѵ�.
				operator[i]++;
			}
		}
	}
 
}
package ���Ʈ����_��Ʈ��ŷ;

import java.util.*;

public class ex15650 {
	public static int N , M ; 
	public static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		dfs(1,0);
	}
	public static void dfs(int a, int dep) { // a���� ����, ���̰� dep
		if (dep == M) { // ���̰� M �̸� �������� ������ ���� ��� ���
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println(); // ��� ������ �� �ǳʶٱ�
			return;
		}
        
		for (int i = a; i <= N; i++) {
			arr[dep] = i; // �ش� ���̿� ���� �����ϰ�
			dfs(i + 1, dep + 1); // �������� �Ѿ
 
		}
	}
}








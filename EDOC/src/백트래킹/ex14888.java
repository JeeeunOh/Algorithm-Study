package ��Ʈ��ŷ;

import java.util.*;
public class ex14888 {
	static int[] num, op;
	static int n, min= 1000000000, max=-1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		num = new int[n]; // ������� ����
		for(int i=0 ; i<n ; i++) num[i] = sc.nextInt();
		
		op = new int[4]; // ������ ���� ����
		for (int i=0 ; i<n ; i++)  op[i] = sc.nextInt();
		
		calc(0,0); // ���� ����� ���� 0,  �����߰���� 0
		
		System.out.println(max);
		System.out.println(min);
	}
	public static int calc(int idx, int temp) {
		int res=0;
		
		return res;
	}
}

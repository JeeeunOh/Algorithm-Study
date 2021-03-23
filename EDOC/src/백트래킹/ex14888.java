package 백트래킹;

import java.util.*;
public class ex14888 {
	static int[] num, op;
	static int n, min= 1000000000, max=-1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		num = new int[n]; // 연산숫자 저장
		for(int i=0 ; i<n ; i++) num[i] = sc.nextInt();
		
		op = new int[4]; // 연산자 개수 저장
		for (int i=0 ; i<n ; i++)  op[i] = sc.nextInt();
		
		calc(0,0); // 현재 진행된 절차 0,  연산중간결과 0
		
		System.out.println(max);
		System.out.println(min);
	}
	public static int calc(int idx, int temp) {
		int res=0;
		
		return res;
	}
}

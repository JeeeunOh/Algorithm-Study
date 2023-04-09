package 동적계획법;

import java.util.*;

public class ex12995_트리나라 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K =sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		int result=0;
		int mid_sum=1;
		for(int i=1 ; i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b]=arr[b][a]=1;
		}
	}
}

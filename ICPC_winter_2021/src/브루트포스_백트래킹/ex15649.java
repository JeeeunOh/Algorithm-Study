package 브루트포스_백트래킹;

import java.util.Scanner;

public class ex15649{
	static int answer = 0;
	static int N =0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int[] arr = new int[N+1];

		for(int i = 1; i<N+1;i++) {
			arr[1] = i;
			dfs(arr, 1);
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int[] arr, int row) {
		if(row == N) answer++;
		else {
			for(int i = 1;i<N+1;i++) {
				arr[row+1] = i;
				if(ispossible(arr,row+1)) {
					dfs(arr,row+1);
				}
			}
		}
		
	}
	static boolean ispossible(int[] arr, int row) {
		for(int i = 1; i<row; i++) {
			if(arr[row]==arr[i] + (row - i) || arr[row] == arr[i] - (row - i)||arr[row]==arr[i]) 
				return false;
		}
		return true;
	}
}


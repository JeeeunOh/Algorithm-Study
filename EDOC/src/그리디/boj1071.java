package 그리디;
// https://www.acmicpc.net/problem/1071
import java.util.*;

public class boj1071 {
	static int[] arr;
	public static void swap(int a, int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for(int i=0 ; i<n ; i++) arr[i]=sc.nextInt();
		Arrays.sort(arr);  // 오름차순 배열
		
		int k;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1] == arr[i] + 1) { // 연속된 수 일때
				// 배열 내 다음  index부터 탐색
				for (k = i + 2; k < n; k++) if (arr[k] != arr[i + 1]) break; // arr[i]+1과 같지 않은 수를 찾는다.
				if (k == n) { //arr[i]+1과 같지 않은 수가 없다면
					for (k = i; k >= 0; k--) if (arr[k] != arr[i]) break; //현재 index밑의 수를 탐색해서 현재수와 같지 않은 수를 찾는다
					swap(i+1, k + 1); 
				}
				else swap(i+1, k); //두 수를 바꿈
			}
		}
	
		for(int i=0 ; i<n ; i++) System.out.println(arr[i]); //출력
	}
}

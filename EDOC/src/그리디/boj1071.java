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
		
		Arrays.sort(arr);  // 사전순으로 가장 앞에있는 것 최종 출력 위해 오름차순 배열
		
		int k;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1] == arr[i] + 1) { // arr[i]과  arr[i+1]이 연속된 수 일때
				// arr[i], arr[i+1]을 비교했으므로, 문제의 조건에 위배되지 않는 arr[k]값을 찾기 위해 그 다음 index부터 탐색
				// 그 전 index부터 탐색하면 사전순으로 가장 앞에 있는 경우에 위배되므로 뒤부터 탐색함
				for (k = i + 2; k < n; k++) if (arr[k] != arr[i + 1]) break; // arr[i]+1과 같지 않은 수 arr[k]를 찾고 반복문 종료
				if (k == n) { //k==n이라는 것은 기준점 i의 뒤에서 문제의 조건을 만족하는 k찾지 못한 것임 arr[i]+1과 같지 않은 수가 없다면
					for (k = i; k >= 0; k--) if (arr[k] != arr[i]) break; //i의 앞을 탐색해서 현재수와 같지 않은 수를 찾는다
					swap(i+1, k + 1); // 찾아낸 수를 서로 바꿈
				}
				else swap(i+1, k); // k!=n이면 
			}
		}
	
		for(int i=0 ; i<n ; i++) System.out.println(arr[i]); //출력
	}
}

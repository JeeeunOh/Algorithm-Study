package 정렬_이분탐색;

/* https://maivve.tistory.com/145 참조
 * 심사대 비었다고 바로 심사 x, 자율적으로 쉬면서 바로 안가도 된다.
 이분탐색 : 해공간 반토막 내면서 해의 범위 좁히는 기법
 = 정확한 값 검색 & 유사값 검색
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
		long min = 1; // 최소 시간
		long max = (long) times[times.length - 1] * n; // 최대시간 (int*int 이기 때문에 long 변환 필요)

		while (min <= max) {
			long mid = (min + max) / 2;
			long sum = 0;
			for (int i = 0; i < times.length; i++) 
				sum += (mid / times[i]); // mid시간일 때 한명당 맡을 수 있는 사람의 수

			if (sum >= n) max = mid - 1; 
			else min = mid + 1;
		}
		return min;
	}
}





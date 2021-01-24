package 정렬_이분탐색;

	import java.util.*;

	// 16401 과자 나눠주기
	public class ex16401_이분탐색 {

		static int M, N, result;
		static int[] arr;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			M = sc.nextInt();
			N = sc.nextInt();
			arr = new int[N];
			
			for(int i=0; i<N; i++) arr[i] = sc.nextInt();
			Arrays.sort(arr);
			
			bs(1, arr[N-1]);
			System.out.println(result);
		}
		
		public static void bs(int s, int e) {
			if(s > e) return;
			int mid = (s+e)/2;
			int cnt = 0;
			
			for(int i=0; i<N; i++) cnt += arr[i]/mid;
			if(cnt >= M) {
				if(result < mid) result = mid;
				bs(mid+1, e);
			}
			else bs(s, mid-1);
		}
	}
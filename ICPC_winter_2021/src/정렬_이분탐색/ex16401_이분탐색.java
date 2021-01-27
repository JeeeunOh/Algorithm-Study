package 정렬_이분탐색;

import java.util.*;

public class ex16401_이분탐색 {
		static int M, N, result;
		static int[] arr;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			M = sc.nextInt();
			N = sc.nextInt();
			arr = new int[N];
			
			for(int i=0; i<N; i++) arr[i] = sc.nextInt();
			Arrays.sort(arr); // 입력받고 정렬
			
			bs(1, arr[N-1]);
			System.out.println(result);
		}
		
		public static void bs(int s, int e) { // 시작과 끝 입력 받고
			if(s > e) return; // 시작이 끝보다 크면 종료
			int mid = (s+e)/2; // 중간값 설정하고
			int cnt = 0;
			
			for(int i=0; i<N; i++) cnt += arr[i]/mid; //중간값보다 큰 arr값 세고
			if(cnt >= M) { //앞에서 구한 cnt값이 조카의수보다 크다면,
				if(result < mid) result = mid;
				bs(mid+1, e); //시작점+1을 하고
			}
			else bs(s, mid-1); //아니면 끝점 -1
			}
}
package 누적합_이중포인터;

import java.util.*;

public class ex11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		sum[0]=0;
		for (int i=1 ; i<= N ; i ++) {
			arr[i]=sc.nextInt();
			sum[i]=sum[i-1]+arr[i];
		}
		for (int i=0 ; i< M ; i ++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println(sum[e]-sum[s-1]);
		}
	}
}
	
	
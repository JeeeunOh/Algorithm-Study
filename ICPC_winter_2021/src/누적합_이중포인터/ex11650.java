package 누적합_이중포인터;

import java.util.*;

public class ex11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[][] arr = new long[1025][1025];
		long[][] sum = new long[1025][1025];
		for (int i=1 ; i<=N ; i ++) 
			for (int j=1 ; j<=N ; j++) {
				arr[i][j]=sc.nextInt();
				sum[i][j] = sum[i-1][j] +sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
			}
		for (int i=0 ; i<M ; i ++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int res=0;
			System.out.println(sum[x2][y2]- sum[x2][y1-1]- sum[x1-1][y2]+ sum[x1-1][y1-1]);
		}
	}
}

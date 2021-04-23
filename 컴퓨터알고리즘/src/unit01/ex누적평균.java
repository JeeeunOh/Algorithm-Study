package unit01;
// 누적평균값을 2차시간에 구한다.
import java.util.*;

public class ex누적평균 {
	static int[] X, A;
	static int n;
	
	public static int Alg() {
		for(int i = 0 ; i< n ; i++) {
			int sum=0;
			for (int j = 0 ; j < i ; j++) {
				sum+=X[j];
				System.out.print(sum+" ");
			}
			 System.out.println();
			A[i]=sum/(i+1);
			System.out.println(A[i]);
		}
		
		return A[n-1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		A = new int[n];
		X = new int[n];
		
		for (int i =0 ; i < n ; i++) X[i] = i;
		
		System.out.println(Alg());
	}

}

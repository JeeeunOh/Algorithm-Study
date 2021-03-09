package EPPER;

import java.util.*;

public class ex11_7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double[] arr = new double[num];
		for(int i=0 ; i<num ; i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		double ans=0;
		int k=0;
		for(double i : arr) {
			if(k==0) ans = i;
			else ans=(ans+i)/ 2;
			k++;
		}
		System.out.printf("%.6f",ans);
	}
}

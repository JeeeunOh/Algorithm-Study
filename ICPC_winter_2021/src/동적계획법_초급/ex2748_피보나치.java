package 동적계획법_초급;

import java.util.*;

public class ex2748_피보나치 {
	static long [] arr;
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		arr = new long[101];
		for (int i=0 ; i<=num ; i++) arr[i]=-1;
		arr[0]=0;arr[1]=1;
		System.out.println(Pibo(num));
		}
	public static long Pibo(int n) {
		if(arr[n]!=-1) return arr[n];
		if (n < 2 ) return arr[n]=n;
		return arr[n]=Pibo(n-1)+Pibo(n-2);
	}
}

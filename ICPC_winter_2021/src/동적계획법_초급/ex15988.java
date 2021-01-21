package 동적계획법_초급;

import java.util.*;

public class ex15988 {
	static int num;
	static long arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new long [1000000];
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		for (int i=0 ; i < n ; i++){
			num = sc.nextInt();
			if (num<=3) System.out.println(arr[num]%1000000009);
			else {
				for (int j=4 ; j<=num ; j++)
					arr[j]=arr[j-1]+arr[j-2]+arr[j-3];
				System.out.println(arr[num]%1000000009);
			}
		}
	}
}

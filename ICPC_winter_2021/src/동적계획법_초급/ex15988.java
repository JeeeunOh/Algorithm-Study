package 동적계획법_초급;

import java.util.*;

public class ex15988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num;
		long[] arr = new long [1000000];
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		for (int i=0 ; i < n ; i++){
			num = sc.nextInt();
			if (num>3) {
				for (int j=4 ; j<=num ; j++)
					arr[j]=(arr[j-1]%1000000009)+(arr[j-2]%1000000009)+(arr[j-3]%1000000009);
			}
			System.out.println(arr[num]%1000000009);
		}
	}
}

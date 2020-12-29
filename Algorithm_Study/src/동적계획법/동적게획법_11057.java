package 悼利拌裙过;

import java.util.*;

public class 悼利霸裙过_11057 {
	static int mod = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] arr = new int[num+1][10];
		int sum=0;
		for (int i=0 ; i<10 ; i++)
			arr[1][i]=1;
		if (num>1) {
			for (int i=2 ; i<=num ; i++)
				for (int j=0 ; j<10 ; j++) {
					for (int k=0;k<=j;k++) {
						arr[i][j]+=arr[i-1][k];
					}
				}
		}
		for (int i=0;i<10;i++)
			sum+=arr[num][i];
		System.out.println(sum%mod);
			
	}

}

package 悼利拌裙过;

import java.util.*;

public class 悼利拌裙过_10844 {
	static int mod = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] arr = new int[101][10];
		int sum=0;
		arr[1][0]=0;
		for(int i=1 ; i<=9 ; i++) 
			arr[1][i] = 1;
		if (num>1)
			for (int i=2 ; i<=9 ; i++) {
				for (int j=0; j<=9 ; j++) {
					if (j==0)
						arr[i][0]=arr[i-1][1];
					else if (j == 9)
						arr[i][9]=arr[i-1][8];
					else
						arr[i][j]=(arr[i-1][j-1]+arr[i-1][j+1]);
					arr[i][j]%=mod;
				}
			}
		for (int i=0;i<10;i++)
			sum+=arr[num][i];
		System.out.printf("%d\n",sum%mod);
	}
}

package map_set_Á¤¼ö·Ð;

import java.util.Scanner;

public class ex16563_sol {
	static int[] check;
	static StringBuilder sb = new StringBuilder();
	public static void Calc(int n) {
		while(n>1) {
			sb.append(check[n]+" ");
			n /= check[n];
		}
		sb.append("\n");
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] k = new int[N];
		for(int i=0; i<N; i++) k[i] = s.nextInt();
		
		check = new int[5000001];
		check[0] = check[1] = -1;
		for(int i=2; i<=5000000; i++) check[i] = i;
		for(int i=2; i<=Math.sqrt(5000000); i++) {
			if(check[i] == i) {
				for(int j=i*2; j<=5000000; j+=i)
					if(check[j] == j) check[j] = i; 
			}
		}
		for(int i=0; i<N; i++) Calc(k[i]);
		System.out.println(sb);
	}
}



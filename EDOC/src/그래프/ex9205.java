package ±×·¡ÇÁ;

import java.util.*;

public class ex9205 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w=1,h=1;
		int result=0;
		
		w = sc.nextInt();
		h = sc.nextInt();
		
		while(w!=0 && h!=0) {
			int n[][]= new int[51][51];
			for (int i=0 ; i<=w ; i++)
				for (int j=0 ; j<=h ; j++)
					n[i][j]=0;
			for (int i=1 ; i<= h ; i++)
				for (int j=1 ; j<=w ; j++) {
					n[i][j]=sc.nextInt();
				}
			for (int i=1 ; i<= h ; i++)
				for (int j=1 ; j<=w ; j++) {
					if (n[i][j]==1) {
						if(n[i-1][j]==0 && n[i-1][j-1]==0 && n[i-1][j+1]==0
								&& n[i][j-1]==0 && n[i][j+1]==0
								&& n[i+1][j]==0 && n[i+1][j-1]==0 && n[i+1][j+1]==0 )
							result++;
					}
				}
			System.out.println(result);
			result=0;
			w = sc.nextInt();
			h = sc.nextInt();
		}
	}
}

package ÇØ½Ã;

import java.util.*;

public class ex2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int n = sc.nextInt();
		int[] nw = new int[w+1];
		int[] nh = new int[h+1];
		nw[w]=w;
		nh[h]=h;
		for (int i=0 ; i< n ; i++) {
			int num = sc.nextInt();
			if (num ==0) {
				int s = sc.nextInt();
				nh[s]=s;
			}
			if (num ==1) {
				int s = sc.nextInt();
				nw[s]=s;
			}
		}
		
		Arrays.sort(nh);
		Arrays.sort(nw);
		
		int max1=0,max2=0;
		
		for(int i=1;i<h;i++) {
			if (max1<nh[i+1]-nh[i])
				max1=nh[i+1]-nh[i];
		}
		for(int i=1;i<w;i++) {
			if (max2<nw[i+1]-nw[i])
				max2=nw[i+1]-nw[i];
		}
		System.out.println(max1*max2);
	}
}











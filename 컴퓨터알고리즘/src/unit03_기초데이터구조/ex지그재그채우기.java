package unit03_기초데이터구조;

import java.util.*;

public class ex지그재그채우기 {
	static void Zigzag(int n) {
		for(int i = 0 ; i<n ; i++) {
			if(i%2==0) {
				for(int j = 0 ; j < n ; j++) {
					int ans = 5*i + (j+1);
					System.out.printf("%3d ", ans);
				}
			} else {
				for(int j = 0 ; j < n ; j++) {
					int ans = 5*i  + (5-j);
					System.out.printf("%3d ", ans);
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Zigzag(n);
	}
}

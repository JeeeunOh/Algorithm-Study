package EPPER;

import java.util.*;

public class ex16_2 {
	static String solution(int num) {
		String ans="";
		int temp=0;
		int[] arr = new int [50];
		Arrays.fill(arr, 0);
		if(num==1) return "NO";
		int calc=num;
		for(int i = 2 ; i <=num/2 ; i++) {
			if(calc%i==0) { System.out.println(i);calc/=i; temp+=i; }
		}
		if(temp+1==num) ans="YES";
		else ans = "NO";
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		for (int i = 0 ; i< n ; i++) {
			int num = sc.nextInt();
			System.out.println(solution(num));
		}
	}

}

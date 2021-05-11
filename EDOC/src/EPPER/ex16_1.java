package EPPER;

import java.util.*;

public class ex16_1 {
	static int num;
	public static int solution() {
		int arr[] = new int[3];
		int cnt=0;
		arr[0]=3600;arr[1]=60;arr[2]=1;
		for(int i=0 ; i<3 ; i++) {
			cnt+= num/arr[i];
			num%=arr[i];
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		System.out.println(solution());
	}
}

package EPPER;

import java.util.*;

public class ex11_9 {
	public static int solution(int left, int right) {
		if(left==0 && right ==0) return 1;
		else {
			if(left==0) return 1;
			else if (left<right) return solution(left - 1, right) + solution(left, right - 1);
			else return solution(left-1, right);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n,n));
	}
}

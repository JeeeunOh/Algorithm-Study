package 누적합_이중포인터;

import java.util.*;

public class ex1484{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();
		
		int current = 1 ; 
		int old = 1;
		int flag=0;
		
		while(old<G) {
			if (current*current - old*old == G) {
				System.out.println(current);
				flag=1;
				old++;
			} else if (current*current - old*old< G) current++;
			else if (current*current - old*old> G) old++;
		}
		if(flag==0) System.out.println(-1);
	}
}

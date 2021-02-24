package 팀대항전_21Winter;

import java.util.*;

public class ex15500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Stack<Integer>[] h = new Stack[3];
		for (int i=1 ; i<= n ; i++) h[0].push(sc.nextInt()); // 0번째 탑에 집어넣기
		
		for(int i=n ; i>0 ; i--) // 제일 큰 수부터 탐색한다.
			if(h[0].peek()!=i) {
				h[1].push(h[0].pop());
			}
		
	}

}

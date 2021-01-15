package 스택_큐_덱;

import java.util.*;

public class ex9012_해설 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		while(n-->0) {
			boolean isVps=true;
			String input = sc.next();
			Stack<Character> stk = new Stack<Character>();
			char temp;
			for (int i=0 ; i<input.length();i++) {
				temp = input.charAt(i);
				if (temp == '(') stk.push(temp);
				else if (temp == ')') {
					if(!stk.isEmpty()) stk.pop();
					else {
						isVps = false;
						break;
					}
				}
			}
			if (!stk.isEmpty()) isVps = false;
			if(isVps) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}

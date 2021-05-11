package ����_ť_��;

import java.util.*;
 
public class ex9012_��ȣ {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++)  System.out.println(solve(sc.next())); 
	}
 
	public static String solve(String s) {
 
		Stack<Character> stack = new Stack<>();
 
		for (int i = 0; i < s.length(); i++) {
 
			char c = s.charAt(i);
			// ���� ��ȣ�� ��� ���ÿ� �ִ´�.
			if (c == '(')  stack.push(c); 
 
			// �Ʒ��� ��� �ݴ� ��ȣ �� �����̴�.
 
			// ������ ����ִ� ���. ��, �ݴ� ��ȣ�� �Է¹޾����� pop�� ���Ұ� ���� ���
			else if (stack.empty())  return "NO"; 
			// �� ���� ��� stack ���Ҹ� pop �Ѵ�.
			else stack.pop(); 
		}
		/*
		 * ��� �˻� ��ġ�� ���ÿ� �ܿ� ��Ұ� ������ ���� ��ȣ�� ���� ���� "NO" 
		 * ������ ��������� ������ �����̹Ƿ� "YES" �̴�.
		 */
		if (stack.empty()) return "YES"; 
		else  return "NO"; 
	}
}
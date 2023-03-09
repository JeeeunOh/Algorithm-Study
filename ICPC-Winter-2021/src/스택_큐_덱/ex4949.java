package ����_ť_��;

import java.io.*;
import java.util.*;

public class ex4949 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) { // �������� ǥ�� .
				bw.flush();
				return;
			}
			bw.write(yn(s));
		}
	}
	static String yn(String s) {
		Stack<Character> stack = new Stack<>();
		boolean result = true;
		for(char one : s.toCharArray()) { /* String toCharArray() : ���ڿ�-> char �� �迭 */
			 if (one == '(' || one == '[') {
	                stack.push(one);
	            } else if (one == ')') {
	                if (stack.isEmpty() || stack.pop() != '(') {
	                    result = false;
	                    break;
	                }
	            } else if (one == ']') {
	                if (stack.isEmpty() || stack.pop() != '[') {
	                    result = false;
	                    break;
	                }
	            }
	        }
		 if (!stack.isEmpty()) {
	            result = false;
	        }
	        return result ? "yes\n" : "no\n";
		}
}


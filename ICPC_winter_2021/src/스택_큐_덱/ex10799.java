package ����_ť_��;
/*
 * Stack<Integer>�� ���ڿ����� " ( "�� ������  �ε����� ���ÿ� �ִ´�.
*(�׸��� " ) " �� ������ ������ top( peek() )�� �ִ� ������ ���� �ε����� -1��° ���� Ȯ���ϰ� �������� ����Ѵ�. 
 * �������� ������ �� pop() �� �ѹ� �ϰ� ������ ����� ���信 ������
 */
import java.util.*;

public class ex10799 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.substring(i,i+1).equals("(")) stack.push(i);
            else {
                if(stack.peek() == i-1) {
                    stack.pop();
                    count+=stack.size();
                }
                else {
                    stack.pop();
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
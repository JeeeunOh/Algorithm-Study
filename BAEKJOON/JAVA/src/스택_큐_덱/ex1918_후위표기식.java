package ����_ť_��;

import java.util.*;

public class ex1918_����ǥ��� {
    static int precedence(char ch) {
        if (ch == '(') return 0;
        if (ch == '+' || ch == '-') return 1;
        else return 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = "";
        Stack<Character> ops = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if ('A' <= ch && ch <= 'Z')  ans += ch;
            else if (ch == '(')  ops.push(ch);
            else if (ch == ')') {
                while (!ops.isEmpty()) {
                    char op = ops.pop();
                    if (op == '(') break;
                    ans += op;
                }
            } 
            else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) ans += ops.pop(); 
                ops.push(ch);
            }
        }
        
        while (!ops.isEmpty()) ans += ops.pop(); 
        System.out.println(ans);
    }
}
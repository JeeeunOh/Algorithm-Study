package ½ºÅÃ_Å¥_µ¦;

import java.util.*;
import java.io.*;

public class ex4949_index¹öÀü {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();

            if (input.equals(".")) {
                bw.flush();
                return;
            }

            bw.write(isBalanced(input));
        }
    }

    // use char[] array and cursor
    static String isBalanced(String s) {
        char[] stack = new char[s.length()];
        int cursor = 0;
        boolean result = true;

        for (char one : s.toCharArray()) {
            switch (one) {
                case '(':
                case '[':
                    stack[cursor++] = one;
                    break;
                case ')':
                    if (cursor == 0 || stack[--cursor] != '(') {
                        return "no\n";
                    }
                    break;
                case ']':
                    if (cursor == 0 || stack[--cursor] != '[') {
                        return "no\n";
                    }
                    break;
            }
        }

        if (cursor > 0) {
            result = false;
        }

        return result ? "yes\n" : "no\n";
    }
}

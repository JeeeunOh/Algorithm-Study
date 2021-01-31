package 스택_큐_덱;
// 후위 표기법 : 연산자가 피연산자들 뒤에 위차하는 것
//중위 표기식 ( A + B ) * ( C + D )  ->  A B + C D + *
// https://ryulth.com/devnote/2019/06/17/java-io-tips/
// StringBuilder, Scanner. StringBufffer, StringBuilder 잘 정리해놓은 블로그

// 해당 문제는 아스키코드가 핵심***
import java.util.*;
import java.io.*;

public class ex1935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		double num1, num2, result=0;
		Stack<Double> stack = new Stack<>();
		
		int count = Integer.parseInt(br.readLine());
		String s = br.readLine(); // 후위표기식 먼저 받고
		
		double[] num = new double[27]; // 알파벳 순서대로 숫자를 받음
		for (int i=0 ; i<count ; i++) {
			int input = Integer.parseInt(br.readLine());
			num[i]= (double)input;
		}
		
		//아스키 코드에서 A : 65, B : 66,,, 이용
		for(int i=0 ; i<s.length(); i++) {
			char c = (s.charAt(i));
			if(c!='*' && c!='/' && c!='+' && c!='-' ) {
				stack.push(num[(int)c-65]);
			}else {
				num1 = stack.pop();
				num2 = stack.pop();
				switch(c) {
				case '*' :
					result = num2*num1;
					break;
				case '+' :
					result = num2+num1;
					break;
				case '/' :
					result = num2/num1;
					break;
				case '-' :
					result = num2-num1;
					break;
				}
				stack.push(result);
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}







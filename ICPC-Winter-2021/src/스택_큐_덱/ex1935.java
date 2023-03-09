package ����_ť_��;
// ���� ǥ��� : �����ڰ� �ǿ����ڵ� �ڿ� �����ϴ� ��
//���� ǥ��� ( A + B ) * ( C + D )  ->  A B + C D + *
// https://ryulth.com/devnote/2019/06/17/java-io-tips/
// StringBuilder, Scanner. StringBufffer, StringBuilder �� �����س��� ��α�

// �ش� ������ �ƽ�Ű�ڵ尡 �ٽ�***
import java.util.*;
import java.io.*;

public class ex1935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		double num1, num2, result=0;
		Stack<Double> stack = new Stack<>();
		
		int count = Integer.parseInt(br.readLine());
		String s = br.readLine(); // ����ǥ��� ���� �ް�
		
		double[] num = new double[27]; // ���ĺ� ������� ���ڸ� ����
		for (int i=0 ; i<count ; i++) {
			int input = Integer.parseInt(br.readLine());
			num[i]= (double)input;
		}
		
		//�ƽ�Ű �ڵ忡�� A : 65, B : 66,,, �̿�
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







package EPPER;

import java.io.*;
//프로그래머스에서는 main함수 및 입출력문이 필요하지 않습니다. 대신 solution함수만 작성하면 됩니다.
public class ex15_3 {
	static void solution(String input){
		String answer="";
		int i=0;
		int len = input.length();
		char pre = input.charAt(i);
		// 1로 시작했을 경우
		if(pre=='1') answer.concat("1");
		// 문자열 하나인 경우
		if(len==1) answer.concat("A");
		i++;
		// 이미 하나 받았으므로
		int num=1;
		while(true) {
			char now = input.charAt(i);
			if(pre==now) num++;
			else {
				char out = (char)(num+64);
				System.out.print(out);
				String s = Character.toString(out);
				if(num>26) answer.concat("Z");
				else answer.concat(s);
				num=1;
			}
			// 다음연산 위해 pre 초기화
			pre=now;
			if(i==len-1) {
				char out = (char)(num+64);
				System.out.print(out);
				String s = Character.toString(out);
				if(num>26) answer.concat("Z");
				else answer.concat(s);
				break;
			}
			else i++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		solution(input);
	}
}
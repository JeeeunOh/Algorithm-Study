package EPPER;

import java.io.*;
//���α׷��ӽ������� main�Լ� �� ����¹��� �ʿ����� �ʽ��ϴ�. ��� solution�Լ��� �ۼ��ϸ� �˴ϴ�.
public class ex15_3 {
	static void solution(String input){
		String answer="";
		int i=0;
		int len = input.length();
		char pre = input.charAt(i);
		// 1�� �������� ���
		if(pre=='1') answer.concat("1");
		// ���ڿ� �ϳ��� ���
		if(len==1) answer.concat("A");
		i++;
		// �̹� �ϳ� �޾����Ƿ�
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
			// �������� ���� pre �ʱ�ȭ
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
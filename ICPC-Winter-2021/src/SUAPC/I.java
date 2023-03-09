package SUAPC;
//“u”, “xyx”, “krrk” ; 같이 뒤집어 읽어도 같음
//  “z”, “pqpq”, “astoast” ; 같이 앞쪽 절반이 뒤쪽 절반과 같음
// abab

import java.io.*;

public class I {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder s = new StringBuilder("");
		// n이 짝수라면
		if (n%2==0)
			for(int i=0 ; i<n/2 ; i++) s.append("aa");
		else {
			for(int i=0 ; i<n/2 ; i++) s.append("aa");
			s=s.append("a");
		}
		bw.close();//스트림을 닫음
	}
}

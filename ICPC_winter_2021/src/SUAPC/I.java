package SUAPC;
//��u��, ��xyx��, ��krrk�� ; ���� ������ �о ����
//  ��z��, ��pqpq��, ��astoast�� ; ���� ���� ������ ���� ���ݰ� ����
// abab

import java.io.*;

public class I {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder s = new StringBuilder("");
		// n�� ¦�����
		if (n%2==0)
			for(int i=0 ; i<n/2 ; i++) s.append("aa");
		else {
			for(int i=0 ; i<n/2 ; i++) s.append("aa");
			s=s.append("a");
		}
		bw.close();//��Ʈ���� ����
	}
}

package ������ȹ��_�ʱ�;

import java.io.*;

public class ex15988 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long mod = 1000000009L;
		int lim = 1000000;
		int num;
		long[] arr = new long [lim+1];
		arr[0]=1;
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		for (int i=4 ; i <=lim; i++){
					arr[i]=((arr[i-1]%mod)+(arr[i-2]%mod)+(arr[i-3]%mod))%mod;
		}
		int n = Integer.parseInt(br.readLine());
		for (int i=0 ; i<n ; i++) {
			num = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(arr[num]));
			bw.write('\n');
			bw.flush(); // flush() : ���� ���ۿ� ����Ǿ� �ִ� ������ Ŭ���̾�Ʈ�� �����ϰ� ���۸� ����.
		}
	}
}

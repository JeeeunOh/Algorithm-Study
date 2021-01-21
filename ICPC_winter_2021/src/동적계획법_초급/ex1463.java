package 동적계획법_초급;

import java.io.*;

public class ex1463 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int lim = 1000000;
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[lim+1]; // new long[lim] -> new long[lim+1] 런타임에러 해결
		arr[1]=0;
		arr[2]=arr[3]=1;
		if(N>=4) {
			for(int i=3 ; i<=N ; i++) {
				arr[i]=arr[i-1]+1;
				if (i%3==0) arr[i]=Math.min(arr[i], arr[i/3]+1);
				if (i%2==0) arr[i]=Math.min(arr[i], arr[i/2]+1);
			}
		}
		bw.write(String.valueOf(arr[N]));
		bw.flush();
	}

}

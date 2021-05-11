package 정렬_이분탐색;

import java.io.*;
import java.util.*;

public class ex11931 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Integer[] arr = new Integer[ Integer.parseInt(br.readLine())];
		for (int i=0 ; i<arr.length ; i++) arr[i]=Integer.parseInt(br.readLine());
		Arrays.sort(arr, Collections.reverseOrder());
		for(Integer i : arr) bw.write(i+"\n");
		bw.flush();
	}
}


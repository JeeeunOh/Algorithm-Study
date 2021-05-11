package 누적합_이중포인터;

import java.io.*;
import java.util.*;

public class ex2003{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		// 입력값 받기 
		for(int i = 0; i < N; i++)  
			arr[i] = Integer.valueOf(st.nextToken());
		
		System.out.println(twoPointer(arr, M));
	}
	
	static int twoPointer(int[] arr, int m) {
		int count = 0;
		int startPoint = 0, endPoint = 0;
		int len = arr.length;
		int sum = 0;
		
		while(true) {
			// M 보다 sum이 크면 값을 줄여서 M을 맞춰야 하므로 
			//현재 startIndex의 값을 빼고 한 칸 앞으로 이동해야 한다.
			if(sum >= m)   sum -= arr[startPoint++];
			else if(endPoint >= len)   break;
			else sum += arr[endPoint++];
				// M 보다 sum이 작으면 값을 늘려서 M을 맞춰야 하므로 
				//현재 endIndex를 한 칸 앞으로 이동시키고 그인덱스의 원소 값을 더해줘야 한다.
			if(sum == m) count++;
		}
		return count;
	}
}
package ������_����������;

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
		
		// �Է°� �ޱ� 
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
			// M ���� sum�� ũ�� ���� �ٿ��� M�� ����� �ϹǷ� 
			//���� startIndex�� ���� ���� �� ĭ ������ �̵��ؾ� �Ѵ�.
			if(sum >= m)   sum -= arr[startPoint++];
			else if(endPoint >= len)   break;
			else sum += arr[endPoint++];
				// M ���� sum�� ������ ���� �÷��� M�� ����� �ϹǷ� 
				//���� endIndex�� �� ĭ ������ �̵���Ű�� ���ε����� ���� ���� ������� �Ѵ�.
			if(sum == m) count++;
		}
		return count;
	}
}
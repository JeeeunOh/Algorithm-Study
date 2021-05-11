package ����_�̺�Ž��;
// dp, �׸���, �̺�Ž��, �������� ��� ���� -> ���⼭�� ��������
// �� ���
import java.util.*;
import java.io.*;

public class ex2470 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		// �Է� �ް� �����ϱ�
		String[] arr = br.readLine().split(" ");
		for(int i=0 ; i<N ; i++)  A[i] = Integer.parseInt(arr[i]); 
		Arrays.sort(A);
		
		int start=0, end = A.length-1;
		long result = Integer.MAX_VALUE;
		int answer1=0,answer2=0;
		
		while(start!=end) { // �������Ϳ����� �׻� ���� ���� �߿���
			if(result>Math.abs(A[end]+A[start])) {
				result=Math.abs(A[end]+A[start]);
				answer1=A[start];
				answer2=A[end];
			}
			if(Math.abs(A[start]+A[end-1])<Math.abs (A[start+1] + A[end])) end--; // ����+(��-1) < (����+1) �� -> ��--;
			else start++;
		}
		System.out.println(answer1 + " " + answer2);
	}
}






package ����_�̺�Ž��;

import java.util.*;

public class ex16401_�̺�Ž�� {
		static int M, N, result;
		static int[] arr;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			M = sc.nextInt();
			N = sc.nextInt();
			arr = new int[N];
			
			for(int i=0; i<N; i++) arr[i] = sc.nextInt();
			Arrays.sort(arr); // �Է¹ް� ����
			
			bs(1, arr[N-1]);
			System.out.println(result);
		}
		
		public static void bs(int s, int e) { // ���۰� �� �Է� �ް�
			if(s > e) return; // ������ ������ ũ�� ����
			int mid = (s+e)/2; // �߰��� �����ϰ�
			int cnt = 0;
			
			for(int i=0; i<N; i++) cnt += arr[i]/mid; //�߰������� ū arr�� ����
			if(cnt >= M) { //�տ��� ���� cnt���� ��ī�Ǽ����� ũ�ٸ�,
				if(result < mid) result = mid;
				bs(mid+1, e); //������+1�� �ϰ�
			}
			else bs(s, mid-1); //�ƴϸ� ���� -1
			}
}
package unit04_�⺻�߻��ڷ���;

import java.util.*;

public class ex����_�迭 {
	static int SIZE=5;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[SIZE];
		int[] B = new int[SIZE];
		int[] ans = new int[2*SIZE];
		int k=5;
		// �迭 �Է� �ޱ�
		System.out.print("A ������ ���� 5�� �Է� : ");
		for(int i = 0 ; i < SIZE ; i++)  A[i] = sc.nextInt();
		
		System.out.print("B ������ ���� 5�� �Է� : ");
		for(int i = 0 ; i < SIZE  ; i++)  B[i] = sc.nextInt();
		
		// ������
		for(int i = 0 ; i < SIZE  ; i++) ans[i]= A[i];
		
		for(int i = 0 ; i < SIZE  ; i++) {
			for(int j=0 ; j<SIZE  ; j++) {
				if(B[i]==A[j]) break;
				if(j==SIZE -1) {
					ans[k]=B[i];
					k++; }
			}
		}
		System.out.print("A�� B�� ������ : ");
		for(int i = 0 ; i < k ; i++) System.out.printf("%d ", ans[i]);
		System.out.println();
		
		// ������
		k = 0;
		for(int i = 0 ; i < 5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				if(A[i] ==B[j]) {
					ans[k] = A[i];
					k++;
				}
			}
		}
		System.out.print("A�� B�� ������ : ");
		for(int i = 0 ; i < k ; i++) System.out.printf("%d ", ans[i]);
		System.out.println();
		
		//������
		k=0;
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				if(A[i] ==B[j]) break;
				if(j==4) {
					ans[k] = A[i];
					k++;
				}
			}
		}
		System.out.print("A�� B�� ������ : ");
		for(int i = 0 ; i < k ; i++) System.out.printf("%d ", ans[i]);
		System.out.println();
	}
}





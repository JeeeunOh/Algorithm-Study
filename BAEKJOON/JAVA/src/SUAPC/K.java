package SUAPC;

import java.util.*;

public class K {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		int num=0, pre = 0, now=0;

        for (int i = 2; i <= N; i++) {
                while (N % i == 0) {
                    arr[now]=i ;
                    now++; // ���μ� ������� �迭�� ����
                    N = N/i;
                    num++;
                }
        }
        
        Arrays.sort(arr);

        now=0; // arr[j] �������� ��
        int check=0;
        if(num<=3)  System.out.println("-1"); 
        else { // �ռ����μ� ���� �� ���� ��
        	if(num%2==0 && N%2==0) { // num�� ¦��, N ¦��
        		while(check!=num) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0�̸� �н�
        			}
        			
        			if(now%2!=0) pre = arr[now]; // index�� Ȧ���� �� * ¦���� ��
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        	}else if(num%2!=0 && N %2==0) { // num�� Ȧ��, N ¦��
        		while(check!=num-2) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0�̸� �н�
        			}
        			
        			if(now%2==0) pre = arr[now]; // index�� ¦�� * Ȧ��
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        		int ans = arr[now]*arr[now+1]*arr[now+2];
        		System.out.print(ans+" ");
        	}else if (num%2==0 && N %2!=0) { // num�� ¦��, N Ȧ��
        		while(check!=num) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0�̸� �н�
        			}
        			
        			if(now%2==0) pre = arr[now]; // index ¦�� * Ȧ��
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        	} else if (num%2!=0 && N %2!=0) { // num�� Ȧ��, N Ȧ��
        		while(check!=num-2) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0�̸� �н�
        			}
        			
        			if(now%2!=0) pre = arr[now]; // index�� Ȧ���� �� * ¦���� ��
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        		int ans = arr[now]*arr[now+1]*arr[now+2];
        		System.out.print(ans+" ");
        	} 
        }
	}
}

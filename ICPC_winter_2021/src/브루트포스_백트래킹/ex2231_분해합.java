package ���Ʈ����_��Ʈ��ŷ;

import java.util.*;

public class ex2231_������ {
	static int N;
	public static int divide_sum(int N) {
		int i;
		int tmp = N;
		int sum=0,flag=0;
		for( i=N-54;i<N;i++) { // �����ڸ� �� -> 9 9 9 9 9 9 �� �ִ� -> i=N-54
			sum=tmp=i;
			while(tmp>0) {
				sum+=tmp%10;
				tmp/=10;
			}
			if(sum==N) {
				flag=1;
				break;
			}
		}
		if (flag == 1 ) return i;
		else return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(divide_sum(N));
	}

}

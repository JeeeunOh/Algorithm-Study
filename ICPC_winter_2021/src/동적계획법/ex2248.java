package ������ȹ��;

import java.util.*;
import java.util.stream.*;

public class ex2248 {
	    static long[][] dp;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();  // 0< n < 32
	        int l = sc.nextInt(); // �Ӱ��� 1�� ����
	        long i = sc.nextLong(); // n�� ���������� �ִ� 2^31(int���� �ʰ�)

	        dp = new long[n + 1][l + 1];
	        dp[0][0] = 1; // �Ŀ� for������ �������� 1����
	        
	        for (int y = 1; y <= n; y++) {
	            dp[y][0] = 1; // �������� y���� �ڸ��� ������ �ְ� 1�� 0�� �ִٸ� ����� �� 1
	            for (int x = 1; x <= l; x++) { // �� �� y���� �ڸ��� x���� 1�� ������ �ִٸ�
	                dp[y][x] = dp[y - 1][x - 1] + dp[y - 1][x]; 
	                // dp[y][x]= y-1���� �ڸ��� x-1���� 1�� ���� ���� 1�߰� or
	                // y-1���� �ڸ��� x���� 1�� ���� ���� 0 �߰��� ���Ѵ�.
	            }
	        }
	        
	        StringBuilder result = new StringBuilder();  
	        // ��Ʈ�� ���� ��� �ٲ� �� �ְ� StringBuilder ���
	        for (int pos = n; pos > 0; pos--) { // n���� 1��° �ڸ� Ž��
	            final int tempPos = pos; 
	            long count = IntStream.range(0, l + 1). // ī��Ʈ������ ���� ���� 1bit ���� ����
	            		mapToLong(k -> dp[tempPos - 1][k]). //���⼭����
	                    sum(); //������� ���Ҹ���,, �Ƹ� ������������ Ž���� ��
	            //���� Ž�� ���� ���� �� ���� ��
	            int digit;
	            if (count < i) { //count�� �־��� i���� ������,
	                digit = 1; // i��° �������� ���� ��Ʈ�� 1�� �� ���� (count���� ũ�� 1, ������ 0����)
	                i -= count; //i-count�� ���ָ鼭 ���� Ž���� ��
	                l--;
	            } else digit = 0;
	            result.append(digit); // ������ ���� digit�� �ڿ� �߰�����.
	        }
	        System.out.print(result.toString());
	    }
	}


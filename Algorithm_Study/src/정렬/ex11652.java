package ����;

import java.util.*;
import java.math.*;

public class ex11652 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] card = new long[n];
		
		for(int i=0;i<n;i++) { 
			card[i] = sc.nextLong(); // �������� �Է¿��� nextLong()�� ����ؾ� �Ѵ�.
		}
			
		if(n==1) { // n�� 1�� ���� 0�� �ε����� ������ָ� �ȴ�.
			System.out.println(card[0]);
			return;
		}
		Arrays.sort(card); // �Է¹��� �����͸� �������� ����
		
		int cnt =1 , a_cnt=0; // cnt�� �����Ϳ� ���� �����ϴ� ����, a_cnt�� �ִ� ������ ���� �� ����
		long ans=0; // ������ ��� �� ����, �� ���� long���� �����ؾ� �Ѵ�.
		
		for(int i=0;i<n-1;i++) { // Ž���� n-2���� Ž���Ѵ�.
			
			if(i ==n-2) { // n-2�� ���
				
				if(card[i] == card[i+1]) // ������ ���Ұ� ���ٸ� cnt ���� 
					cnt++;
                // ������ ���Ұ� �ٸ��ٸ� ����� �� �ʿ䰡 ����.
				if(a_cnt<cnt) { // �ִ� ī��Ʈ ���� ���� ī��Ʈ�� ������ �۴ٸ�
					a_cnt = cnt; // �ִ� ī��Ʈ �� ����
					ans = card[i]; // �ش� ������ ans������ ����
					cnt =1;
				}else if(a_cnt == cnt) { // ���ٸ� �̹� ����� ���� ���Ͽ� �ּڰ��� ����
					ans = Math.min(ans, card[i]);
				}
			}
			else if(card[i] == card[i+1]) { // ���� ������ ���� ������ ���ٸ� cnt����
				cnt++;
			}
			else { // ���� ������ ���� ������ �ٸ��ٸ�
				
				if(a_cnt<cnt) { // ���� ���ǹ��� ����
					a_cnt = cnt;
					ans = card[i];
					cnt =1;
					
				}else if(a_cnt == cnt) {
					ans = Math.min(ans, card[i]);
					a_cnt = cnt;
					cnt=1;
				}else { // �� �� ���ǿ� �ɸ��� ������ cnt������ �ʱ�ȭ ���ش�.
					cnt =1;
				}
			}
		}
		
		
		System.out.println(ans);
		
		
	}

}

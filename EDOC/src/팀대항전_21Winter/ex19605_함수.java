package ��������_21Winter;


import java.util.*;

public class ex19605_�Լ� {
	static int len1, len2, res;
	static String t,s;
	static String[] T,S;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = sc.next();
		s = sc.next();
		T = t.split("");
		S = s.split("");
		
		res=0 ; // 0�� ���ٸ� �ǹ�
		len1 =  S.length;
		len2 =  T.length;
		
		bool();
		
		if(res==1) System.out.println("yes");
		else System.out.println("no");
	}
	public static int bool() {
		for (int i=0 ; i< len1; i++) { // len1���� ���ο� ���ڿ��� �������
			
			String[] news = new String[len1]; // ���̰� len1 �� ���ο� ��Ʈ�� ���� ����
			
			for (int j=0 ; j<len1 ; j++) { //news 0~ len1-1 �ε����� ����ֱ�
				if (j+i>=len1) news[j]=S[j+i-len1];
				else news[j]=S[j+i];
			}
			for (int j=0 ; j< len2-len1; j++) { // T ���ο���
				for(int k=0 ; k<len1 ; k++) { // len1�� ���̸�ŭ Ž��
					if(!T[j+k].equals(news[k])) break; // ��Ʈ�� ���� �ٸ��� break
					//���� �����鼭 ������ �ε����� �����ϸ� res=1
					if(k==len1-1 && T[j+k].equals(news[k])) return 1; 
				}
			}
		}
		return 0;
	}
}

package ��������_21Winter;
//Ž������ �ϳ� ���� ��Ƽ� Ʋ�Ⱦ��� ����
import java.util.*;

public class ex19605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t = sc.next();
		String s = sc.next();
		String []T = t.split("");
		String []S = s.split("");
		
		int res=0 ; // 0�� ���ٸ� �ǹ�

		int len1 =  S.length;
		int len2 =  T.length;
		
		for (int i=0 ; i< len1; i++) { // len1���� ���ο� ���ڿ��� �������
			
			String[] news = new String[len1]; // ���̰� len1 �� ���ο� ��Ʈ�� ���� ����
			for (int j=0 ; j<len1 ; j++) { //news 0~ len1-1 �ε����� ����ֱ�
				if (j+i>=len1) news[j]=S[j+i-len1];
				else news[j]=S[j+i];
			} // ������� ��� �� ��
			
			for (int j=0 ; j< len2-len1+1; j++) { // T ���ο���
				for(int k=0 ; k<len1 ; k++) { // len1�� ���̸�ŭ Ž��
					if(!T[j+k].equals(news[k])) break; // ��Ʈ�� ���� �ٸ��� break
					//���� �����鼭 ������ �ε����� �����ϸ� res=1
					if(k==len1-1 && T[j+k].equals(news[k])) {
						res=1;
						break;
					}
				}
			}
		}
		if(res==1) System.out.println("yes");
		else System.out.println("no");
	}
}

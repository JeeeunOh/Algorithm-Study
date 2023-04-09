package SUAPC;

import java.util.*;

public class new_L {
	static char[][] in;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // ����ũ��
		in = new char[n][n];
		// .  ��ĭ / O �ǹ� / X �ǹ�����
		for (int i=0; i<n ; i++) {
			String s = new String();
			
			s = sc.next();
			for (int j=0; j<n ; j++) in[i][j]=s.charAt(j); 
		}
		// ���ĵ� �ǹ� ����
		for (int i=0; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(in[i][j]!='X' && in[i][j]!='O' &&TF(i,j)) in[i][j]='B';
				System.out.print(in[i][j]);
			}
			System.out.println();
		}
		
	}
	public static boolean TF(int i, int j) {
		//����
		if(i>=1) {
			for(int k=i-1; k>0 ; k--) {
				if(in[k][j]=='X' || in[k][j]=='B') break;
				else if ( in[k][j] =='O') return false;
			}
		}
		//�Ʒ���
		if(i<=n-2) {
			for(int k=i+1; k<n ; k++) {
				if(in[k][j]=='X' || in[k][j]=='B') break;
				else if ( in[k][j] =='O') return false;
			}
		}
		//��������
		if(j>=1) {
			for(int k=j-1; k>0 ; k--) {
				if(in[i][k]=='X' || in[i][k]=='B') {
					System.out.println("find X");
					break;
				}
				else if (in[i][k] =='O') {
					return false;
				}
			}
		}
		//����������
		if(j<=n-2) {
			for(int k=j+1; k<n ; k++) {
				if(in[i][k]=='X' || in[i][k]=='B') break;
				else if (in[i][k] =='O') return false;
			}
		}
		return true;
	}
}

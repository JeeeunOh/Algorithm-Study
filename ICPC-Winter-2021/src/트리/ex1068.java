package Ʈ��;

import java.util.*;

public class ex1068 {
	static int[][] nodes;
	static int N ; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nodes = new int[N][2]; // 0 : �θ��� , 1 :�ڽĳ��
		
		for(int i=0 ; i< N ; i ++ ) // ��� i�� �θ��� �ޱ�
			nodes[i][0] = sc.nextInt();
		
		// �ڽ� �޾ƿ�
		for(int i=0 ; i< N ; i++ )
			for(int j=0 ; j < N ; j++ ) // ��� j�� �θ��尡 i �̸� i�� �ڽĳ�� ���� �߰����ֱ�
				if (nodes[j][0]== i ) nodes[i][1]++;
		
		// ��� �����
		remove(sc.nextInt());
		
		int cnt=0;
		for(int i=0; i<N; i++)
			if(nodes[i][0]!=-2 &&nodes[i][1]==0)  cnt++; //  ��尡 �������� �ʾҰ�, �ڽ� ��尡 ������ cnt++
		System.out.println(cnt);
	}
	
	private static void remove(int num) {
		if(nodes[num][0]!=-1)// ��Ʈ���ƴϸ�
			nodes[nodes[num][0]][1]--; // �θ����� �ڽļ� ���̱�
		
		nodes[num][0]=-2; // ������ ��� ǥ��
		if(nodes[num][1]>0) //�ڽ��� ������
			for(int i=0; i<N; i++) 
				if(nodes[i][0]==num)  remove(i);
	}
}

package ��������_�÷��̵�ͼ�;

import java.util.*;

public class ex11403 {
	
	static int[][] arr;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tmp;
		int n = sc.nextInt();
		arr=new int[n][n];	//������� 
		
		for(int i=0; i<n; i++) {	//�Է� 
			for(int j=0; j<n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) { //ù��° ����� �� �� �ִ� ����� ť�� �߰� 
				if(arr[i][j]==1) {	//���� �ִ� �� 
					q.add(j);	//ť�� �߰� 
				}
			}
			while(!q.isEmpty()) {	//ť�� ���� �ʾ����� 
				tmp=q.poll();		//ť�� �ִ� �����͸� ���� �� ��� ���� 
				BFS(i,tmp);		//BFS�޼ҵ� ȣ�� 
			}
		}
			
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)  System.out.print(arr[i][j]+" ");		 
			System.out.println();
		}
	}
	
	public static void BFS(int i,int tmp) {	//������ ���� i, ť���� ���� ���� tmp 
			arr[i][tmp]=1;	// i���� tmp�� �� �� �����Ƿ� 1�� ���� 
			for(int j=0; j<arr[0].length; j++) {//matrix[0].length==n 
				if(arr[tmp][j]==1&&arr[i][j]!=1) {
					//matrix[i][j]==1�ε� ť�� ������ ���ѷ����� ���� �� �� �����Ƿ� ���� �߰� 
					q.add(j);	//�� �� �ִ� ���̹Ƿ� ť�� �߰� 
				}
			}	
	}
}



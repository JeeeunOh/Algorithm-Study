package SUAPC;

import java.util.*;

public class L {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 도시크기
		char [][] in = new char[n][n];
		int[][] arr = new int[n][n];
		// .  빈칸 / O 건물 / X 건물잔해
		for (int i=0; i<n ; i++) {
			String s = new String();
			s = sc.next();
			for (int j=0; j<n ; j++) in[i][j]=s.charAt(j); 
		}
		// 폭파된 건물 기준
		for (int i=0; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				
				if(in[i][j]=='X') {
					//위로
					if(i>=1) {
						for(int k=i-1; k>0 ; k--) {
							if(in[k][j]=='O' || in[k][j]=='X') break;
							else arr[k][j]+=1;
						}
					}
					//아래로
					if(i<=n-2) {
						for(int k=i+1; k<n ; k++) {
							if(in[k][j]=='O' || in[k][j]=='X') break;
							else arr[k][j]+=1;
						}
					}
					//왼쪽으로
					if(j>=1) {
						for(int k=j-1; k>0 ; k--) {
							if(in[i][k]=='O' || in[i][k]=='X') break;
							else arr[i][k]+=1;
						}
					}
					//오른쪽으로
					if(j<=n-2) {
						for(int k=j+1; k<n ; k++) {
							if(in[i][k]=='O' || in[i][k]=='X') break;
							else arr[i][k]+=1;
						}
					}
				}
				
			}
		}
		// 멀쩡한 건물 기준
		for (int i=0; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				
				if(in[i][j]=='O') {
					//위로
					if(i>=1) {
						for(int k=i-1; k>0 ; k--) {
							if(in[k][j]==('X') || in[k][j]==('O')) break;
							else arr[k][j]=0;
						}
					}
					//아래로
					if(i<=n-2) {
						for(int k=i+1; k<n ; k++) {
							if(in[k][j]==('X') || in[k][j]==('O')) break;
							else arr[k][j]=0;
						}
					}
					//왼쪽으로
					if(j>=1) {
						for(int k=j-1; k>0 ; k--) {
							if(in[i][k]==('X') || in[i][k]==('O')) break;
							else arr[i][k]=0;
						}
					}
					//오른쪽으로
					if(j<=n-2) {
						for(int k=j+1; k<n ; k++) {
							if(in[i][k]==('X') || in[i][k]==('O')) break;
							else arr[i][k]=0;
						}
					}
				}
				
			}
		}
		for (int i=0; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(arr[i][j]>0) System.out.print("B ");
				else System.out.print(in[i][j]+" ");
			}
			System.out.println();
		}
	}
}

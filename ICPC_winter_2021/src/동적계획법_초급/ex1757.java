package ������ȹ��_�ʱ�;
//�л����� ���� �����ϸ� ��ħ������ 0�� �Ǳ� �������� �ٽ� �޸� ���� ����
// 0�϶� �ø� ��ħ������ �״�� 0�̴�. 

import java.util.*;

public class ex1757 {
    public static void main(String args[]){
    	Scanner sc=new Scanner(System.in);
    	
    	int [][][] dp=new int[10005][505][2];
    	int [] arr=new int[10001];
    	int n,m;
    	
    	n=sc.nextInt();
    	m=sc.nextInt();
    	
    	for(int i=1;i<=n;i++)
    		arr[i]=sc.nextInt();
    	
    	for(int i=1;i<=n;i++) {
    		for(int j=0;j<=m;j++) {
    			if(j!=1) { //j�� 0�̶�� dp[i-1][j-1]�� �������� ���Ѵ�.
    				if(j!=0) {
    					dp[i][j][1]=dp[i-1][j-1][1]+arr[i];
    					dp[i][j][0]=Math.max(dp[i-1][j+1][1],dp[i-1][j+1][0]);
    				}
    				else {
    					//j�� 0�̸鼭 �޸��� ���� ����.
    					dp[i][j][0]=Math.max(dp[i-1][j+1][0],Math.max(dp[i-1][j+1][1],dp[i-1][j][0]));
    					//j�� 0�� �� ���� �ٽ� j�� 0�� ���� ����������. ��ħ������ 0���� ������ �� x.
    				}
    			}
    			else {
    				dp[i][j][1]=Math.max(dp[i-1][j-1][1],dp[i-1][j-1][0])+arr[i];
    				dp[i][j][0]=Math.max(dp[i-1][j+1][1],dp[i-1][j+1][0]);
    			}
    		}
    	}
    	System.out.println(dp[n][0][0]);
    			
    }
}
package ��������_�÷��̵�ͼ�;

import java.util.*;
 
public class ex11404 {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int ct_num = sc.nextInt();
        int b_num = sc.nextInt();
        int[][] dist = new int[ct_num+1][ct_num+1];
        int INF = 1000000000;
        
        //�ִ� �Ÿ��� �ʱ�ȭ �� ��
        for(int i=1; i <= ct_num; i++) {
            for(int j=1; j <= ct_num; j++) {
                if(i == j) continue;
                dist[i][j] = INF;
            }
        }
        
        while(b_num-- > 0) {
            int start =sc.nextInt(), end = sc.nextInt(), time = sc.nextInt();
            dist[start][end] = Math.min(dist[start][end], time);    
        }
        
        // �÷��̵� �ͼ�
        for(int k = 1; k <= ct_num; k++) {
            // ����ϴ� ��� i
            for(int i=1; i <= ct_num; i++) {
                // �����ϴ� ��� j
                for(int j=1; j <= ct_num; j++) {
                    //i���� k�� ���ƴٰ� k���� j ���� ���� �Ÿ��� i���� j ���� ���� �Ÿ��� ���ؼ� ���� ���� �ּҰŸ��̴�.
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        //���
        for(int i=1; i <= ct_num; i++) {
            for(int j=1; j <= ct_num; j++) {
                if(dist[i][j] >= INF) System.out.print("0 ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}

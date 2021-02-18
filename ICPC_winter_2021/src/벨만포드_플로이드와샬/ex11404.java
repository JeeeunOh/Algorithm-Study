package 벨만포드_플로이드와샬;

import java.util.*;
 
public class ex11404 {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int ct_num = sc.nextInt();
        int b_num = sc.nextInt();
        int[][] dist = new int[ct_num+1][ct_num+1];
        int INF = 1000000000;
        
        //최대 거리로 초기화 해 줌
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
        
        // 플로이드 와샬
        for(int k = 1; k <= ct_num; k++) {
            // 출발하는 노드 i
            for(int i=1; i <= ct_num; i++) {
                // 도착하는 노드 j
                for(int j=1; j <= ct_num; j++) {
                    //i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리이다.
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        //출력
        for(int i=1; i <= ct_num; i++) {
            for(int j=1; j <= ct_num; j++) {
                if(dist[i][j] >= INF) System.out.print("0 ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}

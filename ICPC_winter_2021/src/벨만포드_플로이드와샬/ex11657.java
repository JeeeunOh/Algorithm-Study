package 벨만포드_플로이드와샬;

import java.util.*;

public class ex11657 {
    static class Bus{
        // 시작점, 도착점, 걸리는 시간
        int start, end, weight;

        public Bus(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static int n, m;
    static int d[];
    static Bus B_arr[];
    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        m =sc.nextInt();
        B_arr = new Bus[m + 1];
        d = new int[n + 1];
        int start, end, time;
        // 최단거리 배열 무한대로 초기화
        for(int i = 1 ; i <= n; i++) d[i] = Integer.MAX_VALUE;

        // 입력값 초기화
        for(int i = 0; i < m; i++){
            start = sc.nextInt();end = sc.nextInt();time = sc.nextInt();
            B_arr[i] = new Bus(start, end, time);
        }
        // 음의 cycle이 없는 경우
        if(bellmanFord()){
            for(int i = 2; i <= n; i++){
            	if(d[i] == Integer.MAX_VALUE) System.out.println(-1);
            	else System.out.println(d[i]);
            } 
        }else{ // 음의 cycle이 있는 경우
        	System.out.println(-1);
        }
    }
    // 음의 cycle이 있다면 false리턴 없다면 true리턴
    // 벨만포드 알고리즘
    private static boolean bellmanFord() {
        // 시작점 최단거리 0 갱신
        d[1] = 0;
        // v - 1번 수행
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                Bus bus = B_arr[j];
                // 더 작은 최단거리 가 있는 경우 갱신
                if(d[bus.start] != Integer.MAX_VALUE&& d[bus.end] > d[bus.start] + bus.weight){
                    d[bus.end] = d[bus.start] + bus.weight;
                }
            }
        }
        // 음수 cycle 확인
        // 갱신되는게 있다면 음수 cycle이 있다는 뜻
        for(int i = 0; i < m; i++){
            Bus bus = B_arr[i];
            if(d[bus.start] != Integer.MAX_VALUE  && d[bus.end] > d[bus.start] + bus.weight) return false;
        }
        return true;
    }
}
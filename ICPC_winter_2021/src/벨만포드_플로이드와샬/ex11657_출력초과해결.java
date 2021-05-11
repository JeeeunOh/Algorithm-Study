package ��������_�÷��̵�ͼ�;

import java.util.*;

public class ex11657_����ʰ��ذ� {
    static class Bus{
        // ������, ������, �ɸ��� �ð�
        int start, end, weight;

        public Bus(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static int n, m;
    static long d[];
    static Bus B_arr[];
    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        m =sc.nextInt();
        B_arr = new Bus[m + 1];
        d = new long[n + 1];
        int start, end, time;
        // �ִܰŸ� �迭 ���Ѵ�� �ʱ�ȭ
        for(int i = 1 ; i <= n; i++) d[i] = Integer.MAX_VALUE;

        // �Է°� �ʱ�ȭ
        for(int i = 0; i < m; i++){
            start = sc.nextInt();end = sc.nextInt();time = sc.nextInt();
            B_arr[i] = new Bus(start, end, time);
        }
        // ���� cycle�� ���� ���
        if(bellmanFord()){
            for(int i = 2; i <= n; i++){
            	if(d[i] == Integer.MAX_VALUE) System.out.println(-1);
            	else System.out.println(d[i]);
            } 
        }else{ // ���� cycle�� �ִ� ���
        	System.out.println(-1);
        }
    }
    // ���� cycle�� �ִٸ� false���� ���ٸ� true����
    // �������� �˰���
    private static boolean bellmanFord() {
        // ������ �ִܰŸ� 0 ����
        d[1] = 0;
        // v - 1�� ����
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                Bus bus = B_arr[j];
                // �� ���� �ִܰŸ� �� �ִ� ��� ����
                if(d[bus.start] != Integer.MAX_VALUE&& d[bus.end] > d[bus.start] + bus.weight){
                    d[bus.end] = d[bus.start] + bus.weight;
                }
            }
        }
        // ���� cycle Ȯ��
        // ���ŵǴ°� �ִٸ� ���� cycle�� �ִٴ� ��
        for(int i = 0; i < m; i++){
            Bus bus = B_arr[i];
            if(d[bus.start] != Integer.MAX_VALUE  && d[bus.end] > d[bus.start] + bus.weight) return false;
        }
        return true;
    }
}
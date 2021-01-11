package 우선순위큐_201118;

import java.util.*;

public class ex2075{
    public static void main(String args[]){
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        
        for(int i = 0; i< count; i++){
        	for(int j = 0; j< count; j++){
        		q.add(sc.nextInt());
        	}
        }       
        for(int i = 0; i< count-1; i++){
        	q.poll();
        }
        System.out.print(q.peek());
    }
}
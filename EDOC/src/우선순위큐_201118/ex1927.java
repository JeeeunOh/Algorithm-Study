package �켱����ť_201118;

import java.util.*;

public class ex1927 {

    static int N;
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0; i<N; i++){
            int input = sc.nextInt();
            if(input == 0)
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            else {
                pq.add(input);
            }
        }
    }
}

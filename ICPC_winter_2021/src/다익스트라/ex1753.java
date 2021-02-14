package 다익스트라;

import java.io.*;
import java.util.*;

class Node implements Comparable <Node> {
      int end, weight;

      public Node (int end, int weight){
            this.end = end;
            this.weight = weight;
      }

      public int compareTo(Node o){ // 가중치 더 큰 것이 앞으로 온다.
    	  // 양수인 것이 앞에, 음수인 것은 뒤에
            return weight - o.weight;
      }
}

public class ex1753 {
      private static final int INF = 100_000_000;
      static int v, e, k;
      static List<Node>[] list;
      static int[] dist;
     
      public static void main(String[] args) {
    	  Scanner sc = new Scanner(System.in);
            v = sc.nextInt();
            e =sc.nextInt();
            k =sc.nextInt();
           
            list = new ArrayList[v+1];
            dist = new int[v+1];
           
            Arrays.fill(dist, INF);
           
            for (int i=1; i <= v; i++){
                list[i] = new ArrayList<>();
            }
            
            for(int i = 0; i < e; i++){
                int start =sc.nextInt();
                int end =sc.nextInt();
                int weight = sc.nextInt();
                list[start].add(new Node(end, weight));
            }
            
            dijkstra(k);
           
            for(int i=1; i <= v; i++){
                if(dist[i] == INF) System.out.println("INF");
                else System.out.println(dist[i]);
            }
      }
      
      private static void dijkstra(int start){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            boolean[] check = new boolean[v+1];
            queue.add(new Node(start, 0));
            dist[start] = 0;
           
            while(!queue.isEmpty()){
               Node curNode = queue.poll(); // 가중치가 작은것부터
               int cur = curNode.end;
               
               if(check[cur] == true) continue;
               check[cur] = true;
               
               for (Node node: list[cur]){
                    if(dist[node.end] > dist[cur] + node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        queue.add(new Node(node.end, dist[node.end]));
                    }
               }
            }    
      }
}
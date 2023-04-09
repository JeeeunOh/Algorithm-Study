package 다익스트라;

import java.util.*;
 
public class ex1916 {
    static int N, M;
    static ArrayList<ArrayList<Node>> a; // 인접리스트.
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
    static boolean[] visit; // 방문 확인.
    
 // 다익스트라 알고리즘
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;
 
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;
 
            if (!check[cur]) {
                check[cur] = true;
 
                for (Node node : a.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
    
    static class Node implements Comparable<Node> {
        int end;
        int weight;
     
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
     
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
     
    }
 
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
 
        a = new ArrayList<>();
        dist = new int[N + 1];
        visit = new boolean[N + 1];
 
        Arrays.fill(dist, Integer.MAX_VALUE);
 
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }
 
        // 단방향 인접 리스트 구현.
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end =sc.nextInt();
            int weight = sc.nextInt();
 
            // start에서 end로 가는 weight (가중치)
            a.get(start).add(new Node(end, weight));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        
        System.out.println(dijkstra(start, end));

    }
}

	
	
	
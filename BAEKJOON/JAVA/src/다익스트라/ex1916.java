package ���ͽ�Ʈ��;

import java.util.*;
 
public class ex1916 {
    static int N, M;
    static ArrayList<ArrayList<Node>> a; // ��������Ʈ.
    static int[] dist; // ���������� �� �������� ���� �ִܰŸ�.
    static boolean[] visit; // �湮 Ȯ��.
    
 // ���ͽ�Ʈ�� �˰���
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
 
        // �ܹ��� ���� ����Ʈ ����.
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end =sc.nextInt();
            int weight = sc.nextInt();
 
            // start���� end�� ���� weight (����ġ)
            a.get(start).add(new Node(end, weight));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        
        System.out.println(dijkstra(start, end));

    }
}

	
	
	
package ���ͽ�Ʈ��_�ÿ�_210217;

// �ִܰ��
import java.util.*;

class Node implements Comparable <Node> {
      int end, weight;
      public Node (int end, int weight){
            this.end = end;
            this.weight = weight;
      }
      public int compareTo(Node o){ // ����ġ �� ū ���� ������ �´�.
    	  // ����� ���� �տ�, ������ ���� �ڿ�
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
            v = sc.nextInt(); // ���� ����
            e =sc.nextInt(); // ���� ����
            k =sc.nextInt(); // ���� ���� ��ȣ
            list = new ArrayList[v+1];
            dist = new int[v+1]; // �ִܰ�ΰ�
           
            Arrays.fill(dist, INF); // �迭�� �ִ밪���� �ʱ�ȭ����
            
            // �ش� ������ ����� ����, �� ����ġ�� �����ϴ� ���Ḯ��Ʈ ������ش�.
            for (int i=1; i <= v; i++) list[i] = new ArrayList<>(); 
            
            // �� ���Ḯ��Ʈ�� ���� �Է¹޾� �����Ѵ�.
            for(int i = 0; i < e; i++){
                int start =sc.nextInt(),end =sc.nextInt(),weight = sc.nextInt();
                list[start].add(new Node(end, weight));
            }
            dijkstra(k);
            
            for(int i=1; i <= v; i++){
                if(dist[i] == INF) System.out.println("INF");
                else System.out.println(dist[i]);
            }
      }
      
      private static void dijkstra(int start){
            PriorityQueue<Node> q = new PriorityQueue<>();
            boolean[] check = new boolean[v+1];
            q.add(new Node(start, 0)); // �������� ����ְ� ���� ����
            dist[start] = 0;
           
            while(!q.isEmpty()){
            	Node curNode = q.poll(); // ����ġ�� �����ͺ���
               int cur = curNode.end;
               if(check[cur] == true) continue; // �湮�� �� ������ �ѱ��
               check[cur] = true; // �ƴϸ� ���� �湮����
               for (Node node: list[cur]){ // ���� ���� ����� ���� ���ʷ� �湮�ϱ�
            	   // end��� �湮�ϴ� ����ġ�� ���� ��� �湮�ؼ� ���� �ͺ��� ũ�� ���� �������ش�.
                    if(dist[node.end] > dist[cur] + node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        q.add(new Node(node.end, dist[node.end])); // ť���ٰ� ���� ��� ��������, �ű���� ���µ� �ɸ� ����ġ?����
                    }
               }
            }    
      }
}

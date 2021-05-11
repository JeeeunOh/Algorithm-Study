package 다익스트라플와;

// 최단경로
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
            v = sc.nextInt(); // 정점 개수
            e =sc.nextInt(); // 간선 개수
            k =sc.nextInt(); // 시작 정점 번호
            list = new ArrayList[v+1];
            dist = new int[v+1]; // 최단경로값
           
            Arrays.fill(dist, INF); // 배열을 최대값으로 초기화해줌
            
            // 해당 정점과 연결된 정점, 그 가중치를 저장하는 연결리스트 만들어준다.
            for (int i=1; i <= v; i++) list[i] = new ArrayList<>(); 
            
            // 위 연결리스트의 값을 입력받아 저장한다.
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
            q.add(new Node(start, 0)); // 시작정점 집어넣고 연산 시작
            dist[start] = 0;
           
            while(!q.isEmpty()){
            	Node curNode = q.poll(); // 가중치가 작은것부터
               int cur = curNode.end;
               if(check[cur] == true) continue; // 방문한 적 있으면 넘기고
               check[cur] = true; // 아니면 지금 방문하자
               for (Node node: list[cur]){ // 현재 노드와 연결된 노드들 차례로 방문하기
            	   // end노드 방문하는 가중치가 현재 노드 방문해서 가는 것보다 크면 새로 갱신해준다.
                    if(dist[node.end] > dist[cur] + node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        q.add(new Node(node.end, dist[node.end])); // 큐에다가 현재 노드 도착점과, 거기까지 가는데 걸린 가중치?저장
                    }
               }
            }    
      }
}

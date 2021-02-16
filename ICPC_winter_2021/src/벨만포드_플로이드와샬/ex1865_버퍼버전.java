package 벨만포드_플로이드와샬;
	import java.io.*;
	import java.util.Arrays;
	import java.util.StringTokenizer;

	public class ex1865_버퍼버전 {
	    // 길 정보를 저장하기 위한 클래스
	    // static으로 선언한 이유는 단지 편리함을 위해서.
	    static class Road{
	        // 출발노드
	        int start;
	        // 도착노드
	        int end;
	        // 걸리는 시간
	        int cost;

	        public Road(int start, int end, int cost){
	            this.start = start;
	            this.end = end;
	            this.cost = cost;
	        }
	    }

	    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    private static final int INF = 500 * 10_000;
	    static int n, m, w;
	    static Road[] roads;
	    static int[] dist;

	    public static void main(String[] args) throws IOException {
	        int testCnt = Integer.parseInt(br.readLine());
	        StringBuilder sb = new StringBuilder();

	        // 테스트 개수만큼 반복
	        for(int i = 0 ; i < testCnt; i++){
	            // 입력값을 변수에 초기화한다.
	            init();
	            // 음수 사이클이 있는 경우
	            if(bellmanFord())
	                sb.append("YES\n");
	            // 음수 사이클이 없는 경우
	            else
	                sb.append("NO\n");
	        }

	        bw.write(sb.toString());

	        br.close();
	        bw.close();
	    }

	    private static void init() throws IOException {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());
	        w = Integer.parseInt(st.nextToken());

	        dist = new int[n + 1];
	        roads = new Road[2 * m + w];

	        // roads[]의 인덱스를 나타낸다.
	        int index = 0;

	        for(int i = 0 ; i < m + w; i++){
	            st = new StringTokenizer(br.readLine());
	            int start = Integer.parseInt(st.nextToken());
	            int end = Integer.parseInt(st.nextToken());
	            int cost = Integer.parseInt(st.nextToken());

	            // 무방향이기 때문에 반대방향도 추가한다.
	            if(i < m){
	                roads[index++] = new Road(start, end, cost);
	                roads[index++] = new Road(end, start, cost);
	            // 웜홀은 유방향이기 때문에 시간만 * -1 해주어서 추가한다.
	            }else{
	                roads[index++] = new Road(start, end, cost * -1);
	            }
	        }
	    }

	    private static boolean bellmanFord(){
	        // dist배열을 INF로 초기화
	        Arrays.fill(dist, INF);
	        // 시작점을 1번 노드로 지정하고 dist[1]값을 0으로 초기화
	        dist[1] = 0;

	        // v - 1번 relax해준다.
	        for (int i = 1; i < n; i++) {
	            // edge개수 만큼 확인을 한다.
	            for (int j = 0; j < roads.length; j++) {
	                Road road = roads[j];

	                if (dist[road.start] != INF && dist[road.start] + road.cost < dist[road.end]){
	                    dist[road.end] = dist[road.start] + road.cost;
	                }
	            }
	        }

	        // 음수 사이클 유무 판정
	        for(int i = 0 ; i < roads.length; i++){
	            Road road = roads[i];
	            // 갱신이 또 된 경우
	            if (dist[road.start] != INF && dist[road.start] + road.cost < dist[road.end])
	                return true;
	        }

	        // 갱신이 되지 않고 for문을 빠져나온 경우
	        return false;
	    }
	}
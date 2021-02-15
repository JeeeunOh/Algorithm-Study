package 벨만포드_플로이드와샬;

	import java.io.*;
	import java.util.StringTokenizer;

	public class ex11657_solution { 
		
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
	    static int dist[];
	    static Bus busArr[];
	    
	    public static void main(String[] args) throws IOException {
	    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());

	        // 입력값 초기화
	        int s, e, T;
	        busArr = new Bus[m + 1];
	        for(int i = 0; i < m; i++){
	            st = new StringTokenizer(br.readLine());
	            s = Integer.parseInt(st.nextToken());  e = Integer.parseInt(st.nextToken());
	            T = Integer.parseInt(st.nextToken());
	            busArr[i] = new Bus(s, e, T);
	        }
	        // 결과 출력을 위한 객체
	        StringBuilder sb = new StringBuilder();

	        dist = new int[n + 1];
	        // 최단거리 배열 무한대로 초기화
	        for(int i = 1 ; i <= n; i++) dist[i] = Integer.MAX_VALUE;
	        // 음의 cycle이 없는 경우
	        if(bellmanFord()){
	            for(int i = 2; i <= n; i++){
	                sb.append(dist[i] ==Integer.MAX_VALUE ? "-1\n" : dist[i] + "\n");
	            }
	        // 음의 cycle이 있는 경우
	        }else sb.append("-1\n"); 

	        bw.write(sb.toString());
	        bw.close();
	        br.close();
	    }
	    // 음의 cycle이 있다면 false리턴 없다면 true리턴
	    // 벨만포드 알고리즘
	    private static boolean bellmanFord() {
	        // 시작점 최단거리 0 갱신
	        dist[1] = 0;
	        // v - 1번 수행
	        for(int i = 1; i < n; i++){
	            for(int j = 0; j < m; j++){
	                Bus bus = busArr[j];
	                // 더 작은 최단거리 가 있는 경우 갱신
	                if(dist[bus.start] != Integer.MAX_VALUE && dist[bus.end] > dist[bus.start] + bus.weight){
	                    dist[bus.end] = dist[bus.start] + bus.weight;
	                }
	            }
	        }
	        // 음수 cycle 확인
	        // 갱신되는게 있다면 음수 cycle이 있다는 뜻
	        for(int i = 0; i < m; i++){
	            Bus bus = busArr[i];
	            if(dist[bus.start] != Integer.MAX_VALUE &&dist[bus.end] > dist[bus.start] + bus.weight) 
	            	return false;
	        }
	        return true;
	    }
	}
package ��������_�÷��̵�ͼ�;

	import java.io.*;
	import java.util.StringTokenizer;

	public class ex11657_solution { 
		
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
	    static int dist[];
	    static Bus busArr[];
	    
	    public static void main(String[] args) throws IOException {
	    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());

	        // �Է°� �ʱ�ȭ
	        int s, e, T;
	        busArr = new Bus[m + 1];
	        for(int i = 0; i < m; i++){
	            st = new StringTokenizer(br.readLine());
	            s = Integer.parseInt(st.nextToken());  e = Integer.parseInt(st.nextToken());
	            T = Integer.parseInt(st.nextToken());
	            busArr[i] = new Bus(s, e, T);
	        }
	        // ��� ����� ���� ��ü
	        StringBuilder sb = new StringBuilder();

	        dist = new int[n + 1];
	        // �ִܰŸ� �迭 ���Ѵ�� �ʱ�ȭ
	        for(int i = 1 ; i <= n; i++) dist[i] = Integer.MAX_VALUE;
	        // ���� cycle�� ���� ���
	        if(bellmanFord()){
	            for(int i = 2; i <= n; i++){
	                sb.append(dist[i] ==Integer.MAX_VALUE ? "-1\n" : dist[i] + "\n");
	            }
	        // ���� cycle�� �ִ� ���
	        }else sb.append("-1\n"); 

	        bw.write(sb.toString());
	        bw.close();
	        br.close();
	    }
	    // ���� cycle�� �ִٸ� false���� ���ٸ� true����
	    // �������� �˰���
	    private static boolean bellmanFord() {
	        // ������ �ִܰŸ� 0 ����
	        dist[1] = 0;
	        // v - 1�� ����
	        for(int i = 1; i < n; i++){
	            for(int j = 0; j < m; j++){
	                Bus bus = busArr[j];
	                // �� ���� �ִܰŸ� �� �ִ� ��� ����
	                if(dist[bus.start] != Integer.MAX_VALUE && dist[bus.end] > dist[bus.start] + bus.weight){
	                    dist[bus.end] = dist[bus.start] + bus.weight;
	                }
	            }
	        }
	        // ���� cycle Ȯ��
	        // ���ŵǴ°� �ִٸ� ���� cycle�� �ִٴ� ��
	        for(int i = 0; i < m; i++){
	            Bus bus = busArr[i];
	            if(dist[bus.start] != Integer.MAX_VALUE &&dist[bus.end] > dist[bus.start] + bus.weight) 
	            	return false;
	        }
	        return true;
	    }
	}
package 벨만포드_플로이드와샬;

import java.io.*;
import java.util.*;

public class ex1865 {
	static final int INF = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(st.nextToken());

		while (TC-->0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			List<Edge> edgeList = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(S, E, T));
				edgeList.add(new Edge(E, S, T));
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(S, E, (-1) * T));
			}

			int[] nodes = new int[N+1];
			Arrays.fill(nodes, INF);
			nodes[1] = 0;
			boolean isUpdated = false;

			// N-1 Edge Relaxation
			outerloop:
			for(int i = 1; i <= N; i++) {
				isUpdated = false;
				for(Edge edge : edgeList) {
					if(nodes[edge.end] > nodes[edge.start] + edge.time) {
						nodes[edge.end] = nodes[edge.start] + edge.time;
						isUpdated = true;
						// Negative Cycle
						if (i == N) {
							isUpdated = true;
							break outerloop;
						}
					}
				}
				if(!isUpdated) break;
			}
			sb.append((isUpdated ? "YES" : "NO") + "\n");
		}
		System.out.println(sb);
	}
}

class Edge {
	int start, end, time;

	Edge(int start, int end, int time) {
		this.start = start;
		this.end = end;
		this.time = time;
	}
}
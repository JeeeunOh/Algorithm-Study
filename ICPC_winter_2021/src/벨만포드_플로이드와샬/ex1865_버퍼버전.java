package 벨만포드_플로이드와샬;

import java.util.*;

public class ex1865_버퍼버전 {
	static class World {
		int start, end, time;
		World(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
	static final int INF = 1000000000;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		while (TC-->0) {
			int N =  sc.nextInt(), M =  sc.nextInt(), W =  sc.nextInt();
			List<World> line = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				int S =  sc.nextInt(),  E =  sc.nextInt(), T =  sc.nextInt();
				line.add(new World(S, E, T));
				line.add(new World(E, S, T));
			}
			for (int i = 0; i < W; i++) {
				int S =  sc.nextInt(), E =  sc.nextInt(), T =  sc.nextInt();
				line.add(new World(S, E, (-1) * T));
			}
			int[] wols = new int[N+1];
			Arrays.fill(wols, INF);
			wols[1] = 0;
			boolean isBool = false;
			// N-1 Edge Relaxation
			outerloop:
			for(int i = 1; i <= N; i++) {
				isBool = false;
				for(World w : line) {
					if(wols[w.end] > wols[w.start] + w.time) {
						wols[w.end] = wols[w.start] + w.time;
						isBool = true;
						// Negative Cycle
						if (i == N) {
							isBool = true;
							break outerloop;
						}
					}
				}
				if(!isBool) break;
			}
			if(isBool) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
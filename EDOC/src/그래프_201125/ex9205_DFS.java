package 그래프_201125;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ex9205_DFS{
	static int[] nx = {-1,-1,-1,0,1,1,1,0};
	static int[] ny = {-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] str = bf.readLine().split(" ");
			if(str[0].equals("0")) {
				break;
			}
			int w = Integer.parseInt(str[0]); //가로
			int h = Integer.parseInt(str[1]); //세로
			
			int[][] sum = new int[h][w];
			for(int i=0; i < h; i++) {
				String[] num = bf.readLine().split(" ");
 				for(int j=0; j < w; j++) {
					sum[i][j] = Integer.parseInt(num[j]);
				}
			}
			
			int count = 0;
			for(int i=0; i < h; i++) {
				for(int j=0; j < w; j++) {
					if(sum[i][j] == 1) {
						dfs(i,j,sum,w,h);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	private static void dfs(int i, int j, int[][] sum, int w, int h) {
		sum[i][j] = 0;
		
		for(int k=0; k < 8; k++) {
			int x = j+nx[k];
			int y = i+ny[k];
			if(x >= 0 && x < w && y >= 0 && y < h && sum[y][x]== 1) {
				dfs(y,x,sum,w,h);
			}
		}
	}

}
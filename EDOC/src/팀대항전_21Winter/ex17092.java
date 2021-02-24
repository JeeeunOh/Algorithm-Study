package 팀대항전_21Winter;
// 색칠공부 문제, 노가다 실패
import java.util.*;

public class ex17092 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(); // 크기가 H×W인 모눈종이
		int W = sc.nextInt();
		int N = sc.nextInt(); // N개의 칸은 검정색
		
		int[][] arr = new int[H+1][W+1];
		int[][] start = new int[H+1][W+1];
		
		for (int i=0 ; i<N ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b]=1; // 검정색 받기
			if (arr[a][b]==1){
				if(a-2>0 && b-2>0) start[a-2][b-2]+=1;
				if(a-1>0 && b-2>0) start[a-1][b-2]+=1;
				if(a>0 && b-2>0) start[a][b-2]+=1;
				if(a-2>0 && b-1>0) start[a-2][b-1]+=1;
				if(a-1>0 && b-1>0) start[a-1][b-1]+=1;
				if(a>0 && b-1>0) start[a][b-1]+=1;
				if(a-2>0 && b>0) start[a-2][b]+=1;
				if(a-1>0 && b>0) start[a-1][b]+=1;
				if(a>0 && b>0) start[a][b]+=1;
			}
		}
		
		for(int i=0 ; i<10 ; i ++ ) {
			int ans=0;
			for(int j=1 ; j<=H ; j++) {
				for(int k=1 ; k<=W ; k++) {
					if (start[j][k]==i) ans++;
				}
			}
			System.out.println(ans);
		}
	}
}

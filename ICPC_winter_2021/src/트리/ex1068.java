package 트리;

import java.util.*;

public class ex1068 {
	static int[][] nodes;
	static int N ; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nodes = new int[N][2]; // 0 : 부모노드 , 1 :자식노드
		
		for(int i=0 ; i< N ; i ++ ) // 노드 i의 부모노드 받기
			nodes[i][0] = sc.nextInt();
		
		// 자식 받아옴
		for(int i=0 ; i< N ; i++ )
			for(int j=0 ; j < N ; j++ ) // 노드 j의 부모노드가 i 이면 i의 자식노드 개수 추가해주기
				if (nodes[j][0]== i ) nodes[i][1]++;
		
		// 노드 지우기
		remove(sc.nextInt());
		
		int cnt=0;
		for(int i=0; i<N; i++)
			if(nodes[i][0]!=-2 &&nodes[i][1]==0)  cnt++; //  노드가 지워지지 않았고, 자식 노드가 없으면 cnt++
		System.out.println(cnt);
	}
	
	private static void remove(int num) {
		if(nodes[num][0]!=-1)// 루트노드아니면
			nodes[nodes[num][0]][1]--; // 부모노드의 자식수 줄이기
		
		nodes[num][0]=-2; // 지워진 노드 표시
		if(nodes[num][1]>0) //자식이 있으면
			for(int i=0; i<N; i++) 
				if(nodes[i][0]==num)  remove(i);
	}
}

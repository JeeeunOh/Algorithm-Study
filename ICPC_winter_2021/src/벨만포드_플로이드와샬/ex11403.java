package 벨만포드_플로이드와샬;

import java.util.*;

public class ex11403 {
	
	static int[][] arr;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tmp;
		int n = sc.nextInt();
		arr=new int[n][n];	//인접행렬 
		
		for(int i=0; i<n; i++) {	//입력 
			for(int j=0; j<n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) { //첫번째 행부터 갈 수 있는 길들을 큐에 추가 
				if(arr[i][j]==1) {	//갈수 있는 길 
					q.add(j);	//큐에 추가 
				}
			}
			while(!q.isEmpty()) {	//큐가 비지 않았으면 
				tmp=q.poll();		//큐에 있는 데이터를 꺼낸 뒤 잠시 저장 
				BFS(i,tmp);		//BFS메소드 호출 
			}
		}
			
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)  System.out.print(arr[i][j]+" ");		 
			System.out.println();
		}
	}
	
	public static void BFS(int i,int tmp) {	//시작한 지점 i, 큐에서 나온 변수 tmp 
			arr[i][tmp]=1;	// i에서 tmp는 갈 수 있으므로 1로 변경 
			for(int j=0; j<arr[0].length; j++) {//matrix[0].length==n 
				if(arr[tmp][j]==1&&arr[i][j]!=1) {
					//matrix[i][j]==1인데 큐에 넣으면 무한루프를 돌게 될 수 있으므로 조건 추가 
					q.add(j);	//갈 수 있는 길이므로 큐에 추가 
				}
			}	
	}
}



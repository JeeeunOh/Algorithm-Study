package EPPER;
import java.util.*;
public class ex15_9{
	
	// 인수 차례대로 작업공정 배열, 관계 배열, 목표
	public static int solution(int[] n,int[][] r,int goal){
		int n_len = n.length; // 공정의 개수
		int[][] adj = new int[n_len][n_len]; // 선후관계
		int[] time = new int[n_len]; // 공정 진행 시간
		int[] total = new int[n_len]; // 공정 최소 시간
		int[] level = new int[n_len]; // 선수 공정 개수
		
		for(int i=0 ; i<n_len ; i++) time[i]=n[i];
		
		for(int[] arr : r) {
			// 몇번과 몇번이 연결되어 있는지 입력 받을 때 시작번호가 1 이므로 -1해줌으로서 배열 인덱스가 0부터 시작하게 함
			int x = arr[0]-1, y = arr[1]-1;
			adj[x][y]=1;
			level[y]++; // y의 선수공정이 하나가 더 생겼다는 의미
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0; i<n_len ; i++) { // 모든 공정 탐색
			if(level[i]==0) { // 선수공정이 없는 공정이 있다면
				total[i] = time[i]; // 해당 공정의 수행 시간은 해당 공정 진행시간과 같음
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) { // 선수공정이 없는 공정이 큐에 남아있다면
			int q = queue.poll(); // 빼내고
			for(int i=0 ; i<n_len ; i++) { // 해당 공정 기준으로 다른 공정들 탐색함
				if(adj[q][i]==1) { // q와 탐색공정이 연결되어 있다면
					total[i]=Math.max(total[i], total[q]+time[i]); // 현재 수행시간과 q를 진행하고 현재 탐색공정을 수행하는 시간을 비교
					if(--level[i]==0) queue.add(i); //앞의 선수공정(q)를 하나 없앴을 때 현재 탐색 공정의 선수공정이 존재하지 않는다면 큐에 넣어줌 -> 다음 계산에 사용
				}
			}
		}
		return total[goal-1]; // 앞과 같은 이유로 goal-1을 해준 것의 탐색 시간을 리턴
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(); // 작업공정 수
		int R=sc.nextInt(); // 관계 수
		int[] n = new int[N];
		int [][] r=  new int[R][R];
		
		for(int i=0;i<N;i++)  n[i]=sc.nextInt(); 
		 for(int k=0;k<R;k++) // k 번째 관계에서 r[k][0], r[k][1] 이 서로 연결되어 있음
	            for(int j=0;j<=1;j++)  r[k][j]=sc.nextInt(); 
		
		int goal=sc.nextInt();
		
		System.out.println(solution(n,r,goal));
	}
}
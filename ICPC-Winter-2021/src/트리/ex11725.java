package 트리;
import java.io.*;
import java.util.*;

public class ex11725 {
	
	static int N;
	static int[] parent;
	static boolean[] visit;
	static List[] nodes;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		parent=new int[N+1]; // 부모노드 저장
		visit=new boolean[N+1];
		nodes=new ArrayList[N+1];
		
		for(int i=1; i<=N; i++)   nodes[i]=new ArrayList();
		
		for(int i=1; i<=N-1; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int num1=Integer.parseInt(st.nextToken()), num2=Integer.parseInt(st.nextToken());
			nodes[num1].add(num2); // 노드 num1과 노드 num2 는 연결되어있음
			nodes[num2].add(num1);
		}
		Search(1); // 1번부터 서치한다.
		for(int i=2; i<=N; i++)  System.out.print(parent[i]+"\n");  // 부모노드 출력
	}
	
	private static void Search(int n) { // 재귀방식 -> BFS
		visit[n]=true; // n번 노드 방문했음을 표시
		for(int i=0; i<nodes[n].size(); i++) { // 해당 노드 사이즈 만큼
			int next= (int) nodes[n].get(i);  // 노드와 연결된 i번째 노드 받아옴
			if(visit[next]==false) { // 만약 다음노드에 방문한 적이 없다면,
				visit[next]=true; // 방문할 것이므로 true값을 지정해주고
				parent[next]=n; // next의 부모노드는 현재 계산 중인 노드이다.
				Search(next); // 그리고 다음 노드를 다시 서치한다.
			}
		}
	}
}
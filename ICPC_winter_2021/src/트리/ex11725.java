package Ʈ��;
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
		parent=new int[N+1]; // �θ��� ����
		visit=new boolean[N+1];
		nodes=new ArrayList[N+1];
		
		for(int i=1; i<=N; i++)   nodes[i]=new ArrayList();
		
		for(int i=1; i<=N-1; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int num1=Integer.parseInt(st.nextToken()), num2=Integer.parseInt(st.nextToken());
			nodes[num1].add(num2); // ��� num1�� ��� num2 �� ����Ǿ�����
			nodes[num2].add(num1);
		}
		Search(1); // 1������ ��ġ�Ѵ�.
		for(int i=2; i<=N; i++)  System.out.print(parent[i]+"\n");  // �θ��� ���
	}
	
	private static void Search(int n) { // ��͹�� -> BFS
		visit[n]=true; // n�� ��� �湮������ ǥ��
		for(int i=0; i<nodes[n].size(); i++) { // �ش� ��� ������ ��ŭ
			int next= (int) nodes[n].get(i);  // ���� ����� i��° ��� �޾ƿ�
			if(visit[next]==false) { // ���� ������忡 �湮�� ���� ���ٸ�,
				visit[next]=true; // �湮�� ���̹Ƿ� true���� �������ְ�
				parent[next]=n; // next�� �θ���� ���� ��� ���� ����̴�.
				Search(next); // �׸��� ���� ��带 �ٽ� ��ġ�Ѵ�.
			}
		}
	}
}
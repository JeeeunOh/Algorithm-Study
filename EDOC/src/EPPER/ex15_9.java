package EPPER;
import java.util.*;

public class ex15_9{
	
	// �μ� ���ʴ�� �۾����� �迭, ���� �迭, ��ǥ
	public static int solution(int[] n,int[][] r,int goal){
		int n_len = n.length; // ������ ����
		int[][] adj = new int[n_len][n_len]; // ���İ���
		int[] time = new int[n_len]; // ���� ���� �ð�
		int[] total = new int[n_len]; // ���� �ּ� �ð�
		int[] level = new int[n_len]; // ���� ���� ����
		
		for(int i=0 ; i<n_len ; i++) time[i]=n[i]; // ��������ð� �ڱ��ڽ� �ð����� �� �ʱ�ȭ
		
		for(int[] arr : r) {
			// ����� ����� ����Ǿ� �ִ��� �Է� ���� �� ���۹�ȣ�� 1 �̹Ƿ� -1�������μ� �迭 �ε����� 0���� �����ϰ� ��
			int x = arr[0]-1, y = arr[1]-1;
			adj[x][y]=1;
			level[y]++; // y�� ���������� �ϳ��� �� ����ٴ� �ǹ�
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0; i<n_len ; i++) { // ��� ���� Ž��
			if(level[i]==0) { // ���������� ���� ������ �ִٸ�
				total[i] = time[i]; // �ش� ������ ���� �ð��� �ش� ���� ����ð��� ����
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) { // ���������� ���� ������ ť�� �����ִٸ�
			int q = queue.poll(); // ������
			for(int i=0 ; i<n_len ; i++) { // �ش� ���� �������� �ٸ� ������ Ž����
				if(adj[q][i]==1) { // q�� Ž�������� ����Ǿ� �ִٸ�
					total[i]=Math.max(total[i], total[q]+time[i]); // ���� ����ð��� q�� �����ϰ� ���� Ž�������� �����ϴ� �ð��� ��
					// �� �� ���������� �� ������ ���� ���� ���� �����ϹǷ� max ������ �缳������
					if(--level[i]==0) queue.add(i); //���� ��������(q)�� �ϳ� ������ �� ���� Ž�� ������ ���������� �������� �ʴ´ٸ� ť�� �־��� -> ���� ��꿡 ���
				}
			}
		}
		return total[goal-1]; // �հ� ���� ������ goal-1�� ���� ���� Ž�� �ð��� ���� ; �迭 �ε����� 0���� ����, goal�� 1�� �������� ������ ��
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(); // �۾����� ��
		int R=sc.nextInt(); // ���� ��
		int[] n = new int[N];
		int [][] r=  new int[R][R];
		
		for(int i=0;i<N;i++)  n[i]=sc.nextInt(); 
		 for(int k=0;k<R;k++) // k ��° ���迡�� r[k][0], r[k][1] �� ���� ����Ǿ� ����
	            for(int j=0;j<=1;j++)  r[k][j]=sc.nextInt(); 
		
		int goal=sc.nextInt();
		
		System.out.println(solution(n,r,goal));
	}
}
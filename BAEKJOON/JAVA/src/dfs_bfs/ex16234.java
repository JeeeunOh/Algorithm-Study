package dfs_bfs;

import java.util.*;
//�����Ǵ��� �ϰ� ��� �ѹ��� �α��� �ٲ���,,?
//�迭 �ϳ��ϳ� Ž���ϸ鼭 dfs�ѹ����� �����°ǰ�...?

public class ex16234 {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int N,L,R;
    static int map[][];
    static boolean visited[][];
    
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    // ������, ����, ��, �Ʒ� ����
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); L = sc.nextInt(); R = sc.nextInt();
        int ans = 0;
        map = new int[N][N];
        
        for(int i=0;i<N;i++)  for(int j=0;j<N;j++) map[i][j]=sc.nextInt(); // �α��� �Է¹���
        
        while(true){
            visited = new boolean[N][N]; // �湮 �ʱ�ȭ
            if(!check()) ans++;  // �α��̵��� �� �ʿ��� ���
             else break; 
        }
        System.out.println(ans);
    }
    
    // �α� �̵� �ʿ����� ��ü ���� Ȯ��.
    public static boolean check(){
        List<Node> n_list;
        boolean isDone = true;  // �̵��� ���̻� �ʿ����� ���� ��� true. �ʿ��� ��� false
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){ // �湮���� ���� ���
                    n_list = new LinkedList<>();
                    n_list.add(new Node(i,j));
                    int sum = dfs(i,j,n_list,0); // sum - ����Ʈ�� ����� ���� ��.
                    
                    if(n_list.size() > 1){ // ����Ʈ ũ�Ⱑ 1 �̻��� ���(= �α��̵��� �ʿ��� �����Ͱ� �������)
                    	
                    	int avg = sum/n_list.size(); // ���� ������ �α��� ��հ����� ����
                        for(Node node:n_list) map[node.x][node.y] = avg;
                        
                        isDone= false;  // �α��̵� �ʿ���
                        }
                }
            } }
        return isDone;
    }
    
    public static int dfs(int x, int y, List<Node> n_list, int sum){
        visited[x][y] =true;
        sum= map[x][y];
        
        for(int i=0;i<4;i++){
            int next_x = x+dx[i]; // Ž���� ��ǥ ���ϱ�
            int next_y = y+dy[i];
            
            if(next_x < 0 || next_x >=N || next_y <0 || next_y >=N ) continue;  // x�� y�� ������ �������� ������ �н�
            
            if(!visited[next_x][next_y]){ // ���� ��ǥ�� ������� �ʾҴٸ�
                int d = Math.abs(map[x][y] - map[next_x][next_y]); // �� ���ձ��� �α� �� ���� ����
                if(d >= L && d <= R){ // �ش� ���̰� ������ ������ �����ϸ�
                    n_list.add(new Node(next_x,next_y)); // ����Ʈ�� �ش� ��� ���ϰ�
                    sum+= dfs(next_x,next_y,n_list,sum); // ���� dfs �ݺ�
                }
            }
        }
        return sum;
    }   
}
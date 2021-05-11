package dfs_bfs;

import java.util.*;
//연합판단을 하고 어떻게 한번에 인구를 바꾸지,,?
//배열 하나하나 탐색하면서 dfs한번씩만 돌리는건가...?

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
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); L = sc.nextInt(); R = sc.nextInt();
        int ans = 0;
        map = new int[N][N];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) map[i][j]=sc.nextInt();
        }
        
        while(true){
            visited = new boolean[N][N]; // 방문 초기화
            if(!check()){
                ans++;  // 인구이동이 또 필요한 경우
            } else break; 
        }
       
        System.out.println(ans);
    }
    
    // 인구 이동 필요한지 전체 지도 확인.
    public static boolean check(){
        List<Node> n_list;
        boolean isDone = true;  // 이동이 더이상 필요하지 않을 경우 true. 필요한 경우 false
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                // 방문하지 않은 경우
                if(!visited[i][j]){
                    n_list = new LinkedList<>();
                    n_list.add(new Node(i,j));
                    // sum - 리스트에 저장된 값의 합.
                    int sum = dfs(i,j,n_list,0);
                    if(n_list.size() > 1){ // 리스트 크기가 1 이상일 경우(= 인구이동이 필요한 데이터가 있을경우)
                        change(sum,n_list); // 평균값 계산해서 map 갱신.
                        isDone= false;  
                        }
                }
            } }
        return isDone;
    }
    
    // 평균값으로 map 갱신.
    public static void change(int sum,List<Node> n_list){
        int avg = sum/n_list.size();
        for(Node node:n_list){
            map[node.x][node.y] = avg;
        }
    }
    
    
    public static int dfs(int x, int y, List<Node> n_list, int sum){
        visited[x][y] =true;
        sum= map[x][y];
        
        for(int i=0;i<4;i++){
            int next_x = x+dx[i];
            int next_y = y+dy[i];
            
            if(next_x < 0 || next_x >=N || next_y <0 || next_y >=N ){
                continue;
            }
            if(!visited[next_x][next_y]){
                int d = Math.abs(map[x][y] - map[next_x][next_y]);
                if(d >= L && d <= R){
                    n_list.add(new Node(next_x,next_y));
                    sum+= dfs(next_x,next_y,n_list,sum);
                }
            }
        }
        return sum;
    }   
}
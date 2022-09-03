#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m, k, t;
int dx[4]={-1, 1, 0, 0};
int dy[4]={0, 0, 1, -1};
vector<vector<int>> visited(51, vector<int> (51, 0));
vector<vector<int>> worm(51, vector<int> (51, 0));

queue<pair<int, int>> q;

void sol(int x, int y){
    q.push({x, y});
    visited[x][y]=1;

    while(!q.empty()){
        auto cur = q.front();
        q.pop();
        int cx = cur.first;
        int cy = cur.second;

        for(int i=0 ; i<4 ; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if(nx >=0 && nx <n && ny >=0 && ny <m && !visited[nx][ny] && worm[nx][ny]){
                q.push({nx, ny});
                visited[nx][ny]=1;
            }
        }
    }
}

int main(){
    cin >> t;
    while(t--){
        cin >> n >> m >> k;

        while(k--){
            int a,b;
            cin >> a >> b;
            worm[a][b]=1;
        }

        int res=0;
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(!visited[i][j] && worm[i][j]==1){
                    // cout << i << " " << j << '\n';
                    sol(i, j);
                    res++;
                }
            }
        }

        cout << res << '\n';

    }

}
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;


int dx[4]={-1, 1, 0, 0};
int dy[4]={0, 0, -1, 1};

int main(){
    int n,m;
    cin >> m >> n;
    int sum=0; // 0인 토마토가 몇개 남았는가

    vector<vector<int>> tomato(n, vector<int>(m, 0));
    queue<pair<int, int>> q;

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<m ; j++){
            cin >> tomato[i][j];

            if(tomato[i][j]==0) sum++;
            if(tomato[i][j]==1){
                q.push({i, j});
            }
        }
    }

    if(sum==0) { // 모든토마토 익어있음.
        cout << 0 << '\n';
        return 0;
    }

    int day=0;

    while(!q.empty()){
        auto cur = q.front();
        int cx = cur.first;
        int cy = cur.second;

        q.pop();

        day = tomato[cx][cy];

        for(int i=0 ; i<4 ; i++){
            int nx = cx+dx[i];
            int ny = cy+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m && tomato[nx][ny]==0){
                q.push({nx, ny});
                tomato[nx][ny]=day+1;
                sum--;
            }
        }
    }

    if(sum>0){ // 다 익지는 못함.
        cout << -1 << '\n';
        return 0;
    } else{ // 얼마 후에 익는지
        cout << day-1 << '\n';
        return 0;
    }
}
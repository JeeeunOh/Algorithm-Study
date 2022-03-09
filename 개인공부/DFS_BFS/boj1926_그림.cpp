#include <iostream>
#include <queue>
using namespace std;

queue<pair<int,int>> q; // 좌표 , 넓이
int n,m;
int mx=0, cnt=0;
int arr[501][501];
int check[501][501]={0};
int dx[]={-1,1,0,0};
int dy[]={0,0,1,-1};

void bfs(int x, int y){
    q.push(make_pair(x,y));
    check[x][y]=1;
    cnt++;

    int temp=0;

    while(!q.empty()){
        int nx=q.front().first;
        int ny=q.front().second;
        q.pop();

        temp++;

        for(int i=0 ; i<4 ; i++){
            int tx=nx+dx[i];
            int ty=ny+dy[i];

            if(tx>=0 && tx<n && ty>=0 && ty<m && arr[tx][ty]==1 && !check[tx][ty]){
                q.push(make_pair(tx,ty));
                check[tx][ty]=check[nx][ny]+1;
            }
        }
    }
    if(mx<temp) mx=temp;

}

int main(){
    cin >> n >> m;

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<m ; j++){
            cin >> arr[i][j];
        }
    }

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<m ; j++){
            if(arr[i][j]==1 && !check[i][j]){
                bfs(i,j);
            }
        }
    }

    cout << cnt << endl;
    cout << mx << endl;
}
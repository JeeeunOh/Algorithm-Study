#include <iostream>
#include <cstring>
#include <queue>
#define MAX 201

using namespace std;

int cnt[MAX][MAX];
int n, start_y, start_x, end_y, end_x;

const int dy[6] = {-2,-2,0,0,2,2};
const int dx[6] = {-1,1,-2,2,-1,1};

int main(void){
    
    memset(cnt, -1, sizeof(cnt));
    
    cin >> n;
    cin >> start_y >> start_x >> end_y >> end_x;
    
    queue<pair<int,int>> que;
    que.push(make_pair(start_y, start_x));
    cnt[start_y][start_x] = 0;
    
    while(!que.empty()){
        int y = que.front().first;
        int x = que.front().second;
        que.pop();
        
        // 도착한 경우
        if(y==end_y && x==end_x){
            break;
        }
        
        for(int i=0; i<6; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
            if(cnt[ny][nx]==-1){
                cnt[ny][nx] = cnt[y][x] + 1;
                que.push(make_pair(ny, nx));
            }
        }
    }
    
    cout << cnt[end_y][end_x] << '\n';
    
    return 0;
}
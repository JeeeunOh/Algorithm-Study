#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

int n;
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
vector<vector<int>> visited(26, vector<int>(26, 0));
vector<string> map(26);

int sol(int x, int y){
    int temp=0;
    temp++;
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y]=1;

    while(!q.empty()){
        
        auto cur = q.front();
        q.pop();
        int cx = cur.first;
        int cy = cur.second;

        // cout << temp << " " << cx << " " << cy << '\n';

        for(int i=0 ; i<4 ; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if (visited[nx][ny]==1 || map[nx][ny]=='0') continue;

            q.push({nx, ny});
            temp++;
            visited[nx][ny]=1;
        }
    }
    return temp;
}

int main(){
    cin >> n;
    vector<int> ans;

    for(int i=0 ; i<n ; i++){
        string s;
        cin >> s;
        map[i]=s;
    }

    int num=0;

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
            if(map[i][j]=='1' && visited[i][j]==0){
                num++;
                int cnt = sol(i,j);
                ans.push_back(cnt);
            }
        }
    }

    sort(ans.begin(), ans.end());

    cout << num << '\n';

    for(int i=0 ; i<ans.size(); i++){
        cout << ans[i] << '\n';
    }

}
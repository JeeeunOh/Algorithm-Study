#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    int res=0;
    int n,m;
    cin >> n >> m;

    vector<int> visited(n+1, 0);
    vector<vector<int>> com(n+1, visited);

    for(int i=0 ; i<m ; i++){
        int a,b;
        cin >> a >> b;
        com[a][b]=1;
        com[b][a]=1;
    }

    // for(int i=1 ; i<=n ; i++){
    //     for(int j=1 ; j<=n ; j++){
    //         cout << com[i][j] << " ";
    //     }
    //     cout << '\n';
    // }

    queue<int> q;
    q.push(1);
    visited[1]=1;

    while(!q.empty()){
        int cur = q.front();
        q.pop();

        // cout << cur << " ";

        for(int i=2 ; i<=n ; i++){
            if(visited[i]==1 || com[i][cur]!=1) continue;

            q.push(i);
            visited[i]=1;
            res++;
        }
    }
    cout << res << '\n';
}
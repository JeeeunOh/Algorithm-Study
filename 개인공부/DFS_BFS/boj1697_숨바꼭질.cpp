#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main(){
    int n,k;

    queue<int> q;
    vector<pair<int, int>> visited(100005, {0,0});

    cin >> n >> k;
    q.push(n);
    visited[n]={1, 0};


    while(!q.empty()){
        int cur = q.front();
        q.pop();

        if(cur-1>=n && cur-1 <=k+1 && visited[cur-1].first!=1) {
            q.push(cur-1);
            visited[cur-1]={1, visited[cur].second+1};

            // cout << cur-1 << " " << visited[cur].second+1 << '\n';
        }
        if(cur+1>=n && cur+1 <=k+1 && visited[cur+1].first!=1) {
            q.push(cur+1);
            visited[cur+1]={1, visited[cur].second+1};

            // cout << cur+1 << " " << visited[cur].second+1 << '\n';
        }
        if(2*cur>=n && 2*cur <=k+1 && visited[2*cur].first!=1) {
            q.push(2*cur);
            visited[2*cur]={1, visited[cur].second+1};

            // cout << 2*cur << " " << visited[cur].second+1 << '\n';
        }
    }

    cout << visited[k].second << '\n';
}
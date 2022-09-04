#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main(){
    int n,k;

    queue<int> q;
    vector<pair<int, int>> visited(2000002, {0,0});

    cin >> n >> k;
    q.push(n);
    visited[n]={1, 0};


    while(!q.empty()){
        int cur = q.front();
        q.pop();

        int next = cur -1 ;
        if(next >= 0 && next <=2*k && visited[next].first!=1) {
            q.push(next);
            visited[next]={1, visited[cur].second+1};
            // cout << cur-1 << " " << visited[cur].second+1 << '\n';
        }

        next = cur+1;
        if(next >= 0 && next <=2*k && visited[next].first!=1) {
            q.push(next);
            visited[next]={1, visited[cur].second+1};
            // cout << cur+1 << " " << visited[cur].second+1 << '\n';
        }

        next = 2*cur ; 
        if(next >= 0 && next <=2*k && visited[next].first!=1) {
            q.push(next);
            visited[next]={1, visited[cur].second+1};
            // cout << 2*cur << " " << visited[cur].second+1 << '\n';
        }
    }

    cout << visited[k].second << '\n';
}
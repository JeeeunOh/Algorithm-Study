#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main(){
    int n,k;

    queue<pair<int, int>> q;
    vector<int> visited(100001, 0);

    cin >> n >> k;
    q.push({n, 1});
    visited[n]=1;


    while(!q.empty()){
        auto cur = q.front();
        int idx = cur.first;
        int cnt = cur.second;
        q.pop();

        if(idx == k){
            cout << cnt << '\n';
            return 0;
        }

        int next = idx - 1 ;
        if(next >= 0 && next <=2*k && visited[next]!=1) {
            q.push({next, cnt+1});
            visited[next]=1;
            // cout << idx-1 << " " << visited[idx].second+1 << '\n';
        }

        next = idx + 1 ;
        if(next >=0  && next <=2*k && visited[next]!=1) {
            q.push({next, cnt+1});
            visited[next]=1;
            // cout << idx-1 << " " << visited[idx].second+1 << '\n';
        }

        next = 2 * idx ; 
        if(next >= 0 && next <=2*k && visited[next]!=1) {
            q.push({next, cnt+1});
            visited[next]=1;
            // cout << idx-1 << " " << visited[idx].second+1 << '\n';
        }
    }
}
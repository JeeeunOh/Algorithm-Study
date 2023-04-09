#include <iostream>
#include <vector>
using namespace std;

int n,m;
vector<int> v(8);
vector<int> output(8);

void dfs(int idx, int cnt){
    output[cnt]=v[idx];
    cnt++;

    if(cnt==m){
        for(int i=0 ; i<m ; i++){
            cout << output[i] << " ";
        }
        cout << '\n';
        return;
    }

    for(int i=idx+1 ; i<n ; i++){
        dfs(i, cnt);
    }

}

int main(){
    cin >> n >> m;

    for(int i=1 ; i<=n ; i++){
        v[i-1]=i;
        // cout << v[i-1] << " ";
    }
    // cout << '\n';

    for(int i=0 ; i<n ; i++){
        dfs(i, 0);
    }
}
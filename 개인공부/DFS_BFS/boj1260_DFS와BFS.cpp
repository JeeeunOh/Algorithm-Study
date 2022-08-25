#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n,m,s;
int arr[1001][1001];
vector<int> visited(1001, 0);
vector<int> visDFS(1001, 0);

void dfs(int s){
    visited[s]=1;

    cout << s << " ";

    for(int i=1 ; i<=n; i++){ // 방문한 적 있거나 둘이 연결되어있지 않으면 패스
        if(visited[i]==1 || arr[s][i]!=1) continue;
        dfs(i);
    }
}

void bfs(int s){
    queue<int> q;
    q.push(s);
    visDFS[s]=1;

    while(!q.empty()){
        int cur = q.front();
        cout << cur << " ";
        q.pop();

        for(int i=1; i<=n ; i++){
            if(visDFS[i]==1 || arr[cur][i]!=1) continue;
            q.push(i);
            visDFS[i]=1;
        }
    }
}


int main(){
    cin >> n >> m >> s;
    
    while(m--){
        int a,b;
        cin >> a >> b;
        arr[a][b]=1;
        arr[b][a]=1;
    }
    dfs(s);
    cout << '\n';
    bfs(s);
    cout << '\n';
}
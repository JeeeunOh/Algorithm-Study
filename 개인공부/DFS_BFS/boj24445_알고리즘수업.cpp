#include <iostream>
#include <queue>
using namespace std;

int main(){
    long long N, M, R; // 정점, 간선, 시작정점
    long long arr[100001][100001];
    long long count[100001];
    queue<long long> q;

    cin >> N >> M >> R;

    while(M--){
        int a,b;
        cin >> a >> b;
        arr[a][b]=1;
        arr[b][a]=1;
    }

    q.push(R);
    count[R] = 1;

    while(!q.empty()){
        int cur = q.front();
        q.pop();

        for(int i=1 ; i<=N; i++){
            if(i==cur) continue;
            if(count[i]==0 && arr[cur][i]==1){
                q.push(i);
                count[i]=count[cur]+1;            
            }
        }
    }

    for(int i=1 ; i<=N; i++){
        cout << count[i] << endl;
    }
}
#include <iostream>
#include <queue>
using namespace std;

int n,m; // 주어진 컴퓨터 수, 신뢰하는 관계 수
int arr[10001][10001]={0};
int long mx[10001]={0};
int res=0; // 현재까지 가장 많은 컴퓨터 해킹 수

int main(){
    cin >> n >> m;

    while(m--){
        int a,b;
        cin >> b >> a; //b가 a를 신뢰함.
        arr[a][b]=1;
    }

    for(int i=1; i<=n ; i++){
        queue<int> q; // 현재 탐색 큐
        int check[10001]={0};
        q.push(i);

        while(!q.empty()){
            int cur = q.front();
            q.pop();
            check[i]++;
            for(int j=1; j<=n ; j++){
                if(arr[cur][j]==1 && check[j]==0){
                    q.push(j);
                    check[j]=1;
                }
            }
        }

        mx[i]=check[i]-1;
        if(res<mx[i]) res=mx[i];
    }

    for(int i=1; i<=n ; i++){
        if(res==mx[i]) cout << i << " ";
    }
}
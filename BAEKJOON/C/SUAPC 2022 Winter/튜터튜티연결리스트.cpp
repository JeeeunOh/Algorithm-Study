#include <iostream>
#include <vector>
using namespace std;

int N, M, ans=0;

int sol(int start, int temp){

}

int main(){
    vector<int> graph[200001];
    cin >> N >> M; // 교육생 수, 친분관계수

    while(M--){
        int a,b;
        cin >> a >> b;

        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    for(int i=1 ; i<=N; i++){
        ans+=sol(i,1);
    }

    ans%=1000000007;

    cout << ans << endl;
}
#include <iostream>
using namespace std;
const int MAX = 2000;

int N, K, cnt, ans;
bool visited[MAX];

int main(){
    ios_base::sync_with_stdio(false); 
    cout.tie(NULL); 
    cin.tie(NULL);
    cin >> N >> K;
    for(int i = 2; i<=N; ++i){
        if(ans) break;
        if(visited[i]) continue;
        for(int j = i; j<=N; j+=i){
            if(visited[j]) continue;
            cnt++;
            if(cnt==K){
                ans = j;
                break;	
            }
            visited[j] = true;
        }
    }
    cout << ans << '\n';

    return 0;
}
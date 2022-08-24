#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n,k;
    cin >> n >> k;
    vector<int> dp(k+1, 0); // 무게가 w일 때의 가치

    for(int i=0 ; i<n ; i++){
        int a,b;
        cin >> a >> b; // 무게 가치
        // for(int j=k ; j>=a ; j--){
        //     dp[j]=max(dp[j], dp[j-a]+b);
        // }
        for(int j=a ; j<=k ; j++){
            dp[j]=max(dp[j], dp[j-a]+b);
        }
    }
    cout << dp[k] << '\n';
}
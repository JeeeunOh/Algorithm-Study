#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int n;
    long long arr[301];
    long long dp[301];

    cin >> n;
    
    for(int i=1 ; i<=n ; i++){
        cin >> arr[i];
    }

    dp[1] = arr[1];
    dp[2]=arr[1]+arr[2];
    dp[3]=max(arr[1]+arr[3], arr[2]+arr[3]); // 여기서도 최댓값 구해줘야함.

    for(int i=4 ; i<=n ; i++){
        dp[i]=max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
    }

    cout << dp[n] << endl;
}
#include <iostream>
using namespace std;

int max(int a,int b){
    return a>b? a:b;
}

int main(){
    int N,M;
    int arr[1001][1001];
    int dp[1001][1001];

    cin >> N >> M;

    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<M ; j++){
            cin >> arr[i][j];
            dp[i][j]=arr[i][j];
            if(i-1>=0) dp[i][j]=max(dp[i][j], dp[i-1][j]+arr[i][j]); 
            if(j-1>=0) dp[i][j]=max(dp[i][j], dp[i][j-1]+arr[i][j]); 
            if(i-1>=0 && j-1>=0) dp[i][j]=max(dp[i][j], dp[i-1][j-1]+arr[i][j]); 
        }
    }
    cout << dp[N-1][M-1];
}
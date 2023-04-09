#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 100001 // 최대 동전 100001개 써서 동전 가치 도달할 수 있음.

int main(){
    int n,k,res=0;
    int arr[101]; // 주어진 동전 가치
    int dp[MAX]; // dp[만들어야하는 동전들의 합]=필요한개수
    cin >> n >> k;

    fill_n(dp, MAX, MAX); //dp의 모든 값을 최댓값으로 초기화

    for (int i=0 ; i<n ; i++) cin >> arr[i]; // 동전 가치 입력받기
    for(int i=0 ; i<n ; i++) dp[arr[i]]=1; // 동전 한개로 만들 수 있는 가치 설정 

    for(int i=1 ; i<=k ; i++){ // dp[1] ~ dp[k] 찾기
        for(int j=0 ; j<n ; j++){ // 주어진 동전 가치들 반복문으로 돌리면서
            if(i-arr[j]>0){ // 탐색하려는 이전값이 1이상이면서
                if(dp[i-arr[j]]!=MAX) { // 만들 수 있는 가치이면
                    dp[i]=min(dp[i], dp[i-arr[j]]+1); // 둘 중 최솟값 비교해서 넣기
                }
            }
        }
    }
    if(dp[k]!=MAX) cout << dp[k] << '\n'; // 해당 가치를 만들 수 있으면 출력
    else cout << -1 << '\n'; // 아니면 -1
} 
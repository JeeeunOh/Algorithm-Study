#include <iostream>
#include <algorithm>
#include <string.h>
using namespace std;

int N, K;
int dp[1010][1010];

int solve(int n, int k)
{
    if(k == 0 || n == k) return 1;
    if(dp[n][k] != 0) return dp[n][k] % 10007;
    dp[n][k] = solve(n-1, k-1) + solve(n-1, k);
    return dp[n][k] % 10007;
}

int main(void)
{
    cin >> N >> K;
    cout << solve(N, K);
    return 0;
}

function solution(n) {
    const mod = 1000000007;
    let dp = [0, 1, 2];
    
    for(let i=3 ; i<=n ; i++){
        dp[i] = (dp[i-2] + dp[i-1])%mod;
    }
    
    return dp[n];
}
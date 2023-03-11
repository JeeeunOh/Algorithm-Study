// https://velog.io/@longroadhome/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-LV.4-3-x-n-%ED%83%80%EC%9D%BC%EB%A7%81-JS

const MOD = 1000000007;

function solution (n) {
  const dp = [0, 3, 11];
  const idx = n >> 1;
  
  if(n % 2) return 0;
  if(idx < 3) return dp[idx];
  
  for(let i = 3; i <= idx; i++) {
    dp[i] = dp[i-1] * 3 + 2;
    
    for(let j = 1; j < i-1; j++) {
      dp[i] += dp[j] * 2;
    }
    
    dp[i] %= MOD;
  }
  
  return dp[idx];
}

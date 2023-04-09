function solution(n) {
  let cnt = 0;
  let dp = [0];

  for (let i = 1; i <= n; i++) {
    dp.push(dp[i - 1] + i);
    for (let j = 0; j < i; j++) {
      if (dp[i] - dp[j] == n) {
        cnt++;
      }
    }
  }

  return cnt;
}

// 자연수의 약수 중 홀수의 개수가 정답

function solution(n) {
  let answer = 0;
  for (let i = 1; i <= n; i++) {
    if (n % i === 0 && i % 2 === 1) answer++;
  }
  return answer;
}

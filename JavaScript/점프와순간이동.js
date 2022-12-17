// k칸 앞 || 순간이동 : 온 거리 * 2
// k칸 점프는 k만큼 건전지
// 최단거리..? -> 시간초과...!

function solution(n) {
  // n거리를 순간이동 할 경우(최댓값)를 min으로 초기화
  let min = n;

  function dfs(idx, cost, n) {
    // 끝점 다다르면 return
    if (idx === n) {
      if (cost < min) min = cost;
      return;
    }
    // k거리 점프
    for (let i = idx + 1; i <= n; i++) {
      dfs(i, cost + (i - idx), n);
    }
    // 순간이동
    if (idx != 0 && idx * 2 <= n) {
      dfs(idx * 2, cost, n);
    }
  }
  // 계산 시작
  dfs(0, 0, n);

  return min;
}

// dp 풀이
// 정확도 100, 효율 0...

function solution(n) {
  let dp = [0];

  for (let i = 1; i <= n; i++) {
    if (i % 2 == 1) {
      dp[i] = dp[i - 1] + 1;
    } else {
      dp[i] = dp[i / 2];
    }
  }

  return dp[n];
}

// n의 최댓값이 10억이기 때문에 위에서부터 거꾸로 내려오는 방식 차용
function solution(n) {
  // n거리를 순간이동 할 경우(최댓값)를 min으로 초기화
  let ans = 0;

  while (n != 0) {
    if (n % 2 == 0) n /= 2;
    else {
      n--;
      ans++;
    }
  }

  return ans;
}

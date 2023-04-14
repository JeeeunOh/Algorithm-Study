// 투포인터 풀이
function solution(n) {
  let answer = 0;
  let start = 1, end=1, sum=1; // start~end까지 더한 값
  
  while(start<=end && end!=n+1 && start>=1){ // start가 end보다 작거나 같아야 함. start, end가 정해진 지점 넘어가면 안됨.
      if(sum<n){ // sum이 작으면, end 바로 뒤의 숫자를 더함
          end++; 
          sum+=end;
      } else if (sum>n){ // sum이 크면, start를 뺌.
          sum-=start;
          start++;
      } else if (sum===n){ // sum===n이면 answer 추가하고 end를 뒤로 미룸.
          answer++;
          end++;
          sum+=end;
      }
  }
  return answer;
}

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

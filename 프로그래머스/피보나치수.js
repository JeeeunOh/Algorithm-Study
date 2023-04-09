function solution(n) {
  let answer = 0;
  let arr = [0, 1];

  for (let i = 2; i <= n; i++) {
    arr.push((arr[i - 1] + arr[i - 2]) % 1234567);
  }

  answer = arr[n] % 1234567;

  return answer;
}

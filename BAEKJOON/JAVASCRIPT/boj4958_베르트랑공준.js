const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

let arr = input.slice(0).map(Number);

let size = 123456;

let isPrime = Array(2 * size + 1).fill(true);

for (let i = 2; i < Math.sqrt(2 * size) + 1; i++) {
  if (isPrime[i]) {
    for (let j = 2; i * j <= 2 * size; j++) {
      isPrime[i * j] = false;
    }
  }
}

let dp = Array(2 * size + 1).fill(0);

for (let i = 2; i < isPrime.length; i++) {
  if (isPrime[i]) dp[i] = dp[i - 1] + 1;
  else dp[i] = dp[i - 1];
}

for (let i = 0; i < arr.length - 1; i++) {
  let cur = arr[i];
  console.log(dp[2 * cur] - dp[cur]);
}

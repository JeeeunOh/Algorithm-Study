// 이진탐색

const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);
arr.sort((a, b) => a - b);

let start = 0,
  end = arr.at(-1),
  ans = Math.ceil((start + end) / 2);

while (start <= end) {
  let mid = Math.ceil((start + end) / 2);
  let sum = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] > mid) sum += arr[i] - mid;
  }
  if (sum >= M) {
    ans = mid;
    start = mid + 1;
  } else end = mid - 1;
}

console.log(ans);

// 단순 구현

// let idx = 0,
//   ans = arr[0];
// sum = 0;

// while (ans >= 0) {
//   if (ans < arr[idx]) {
//     idx++;
//   }
//   sum += idx;
//   if (sum >= M) break;
//   ans--;
// }

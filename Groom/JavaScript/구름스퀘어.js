const readFileSyncAddress =
  process.platform === 'linux'
    ? '/dev/stdin'
    : '/Users/jieun/Documents/GitHub/Algorithm_Study/Groom/JavaScript/input.txt';

const input = require('fs')
  .readFileSync(readFileSyncAddress)
  .toString()
  .trimEnd()
  .split('\n');

const n = +input[0];
let arr = [];
for (let i = 1; i <= n; i++) {
  arr.push(input[i].split(' ').map(Number));
}
arr.sort((a, b) => a[1] - b[1]);

let ans = 1;
let fin = arr[0][1];

for (let i = 1; i < arr.length; i++) {
  if (fin + 1 <= arr[i][0]) {
    fin = arr[i][1];
    ans++;
  }
}
console.log(ans);

const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

let n = +input[0];
const arr = input.slice(1).map((item) => item.split(' ').map(Number));
const newArr = [];

for (let i = 0; i < n; i++) {
  let temp = [];
  for (let j = 0; j < n; j++) {
    temp.push(arr[j][i]);
  }
  newArr.push(temp);
}

console.log(newArr);

let cnt = 0;
while (true) {
  let mx = 0;
  for (let i = 1; i < n; i++) {
    if (newArr[i].at(-1) > newArr[mx].at(-1)) {
      mx = i;
    }
  }
  let max = newArr[mx].at(-1);
  newArr[mx].pop();
  cnt++;
  console.log(cnt, max);
  if (cnt === n) {
    console.log(max);
    break;
  }
}

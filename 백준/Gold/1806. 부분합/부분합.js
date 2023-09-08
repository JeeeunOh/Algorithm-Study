const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';
const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

const [N, S] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

let ans = 100001;
let sum = 0;
let curArr = [];

for (let i = 0; i < N; i++) {
    curArr.push(arr[i]);
    sum += arr[i];
    if (sum >= S) {
        while (true) {
            if (sum - curArr[0] >= S) {
                sum -= curArr[0];
                curArr.shift();
            } else break;
        }
        ans = Math.min(ans, curArr.length);
    }
}

console.log(ans === 100001 ? 0 : ans);
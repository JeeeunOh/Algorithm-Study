const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

const [N, K] = input[0].split(' ').map(Number);
const arr = Array(Math.max(N, 2 * K) + 1).fill(-1);
arr[N] = 0;

let q = [N];

while (q.length) {
    let cur = q.shift();
    let [case1, case2, case3] = [2 * cur, cur - 1, cur + 1];

    if (case1 < arr.length && arr[case1] === -1) {
        arr[case1] = arr[cur];
        if (case1 === K) break;
        q.push(case1);
    }
    if (case2 < arr.length && arr[case2] === -1) {
        arr[case2] = arr[cur] + 1;
        if (case2 === K) break;
        q.push(case2);
    }
    if (case3 < arr.length && arr[case3] === -1) {
        arr[case3] = arr[cur] + 1;
        if (case3 === K) break;
        q.push(case3);
    }
}

console.log(arr[K]);
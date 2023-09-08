const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const num = input[1]
    .split(' ')
    .map(Number)
    .sort((a, b) => a - b);

function sol(arr, curIdx) {
    let nextArr = [...arr, num[curIdx]];
    if (nextArr.length === M) {
        console.log(nextArr.join(' '));
        return;
    }
    for (let i = 0; i < N; i++) {
        if (i !== curIdx && !nextArr.includes(num[i])) {
            sol(nextArr, i);
        }
    }
    return;
}

for (let i = 0; i < N; i++) {
    sol([], i);
}

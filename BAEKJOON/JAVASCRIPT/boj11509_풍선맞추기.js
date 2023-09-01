const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

let N = +input[0];
let arr = input[1].split(' ').map(Number);
let cnt = 0;

while (N > 0) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] !== -1) {
            cnt++;
            N--;
            let h = arr[i];
            arr[i] = -1;
            for (let j = i + 1; j < arr.length; j++) {
                if (arr[j] === h - 1) {
                    h--;
                    N--;
                    arr[j] = -1;
                }
            }
            break;
        }
    }
}

console.log(cnt);

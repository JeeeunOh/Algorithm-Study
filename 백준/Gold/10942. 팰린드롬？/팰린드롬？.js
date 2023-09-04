const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

const nums = input[1].split(' ').map(Number);
const dp = Array.from({ length: nums.length }, () => Array(nums.length).fill(0));
let answer = [];

for (let i = 0; i < nums.length; i++) {
    dp[i][i] = true;
    if (i + 1 < nums.length) {
        if (nums[i] === nums[i + 1]) dp[i][i + 1] = true;
        else dp[i][i + 1] = false;
    }
}

for (let j = 2; j < nums.length; j++) {
    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[i] !== nums[j]) continue;

        if (dp[i + 1][j - 1]) dp[i][j] = true;
    }
}

input.slice(3).forEach((el) => {
    const [src, dst] = el.split(' ').map(Number);

    if (dp[src - 1][dst - 1]) answer.push(1);
    else answer.push(0);
});

console.log(answer.join('\n'));

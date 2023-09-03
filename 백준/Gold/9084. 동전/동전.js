const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

let t = +input.shift();

while (t--) {
    let num = +input.shift();
    let coins = input.shift().toString().split(' ').map(Number);
    let won = +input.shift();

    let dp = Array.from({ length: won + 1 }, () => 0);
    dp[0] = 1;

    for (let j = 0; j < num; j++) {
        for (let k = coins[j]; k <= won; k++) {
            dp[k] += dp[k - coins[j]];
        }
    }

    console.log(dp[won]);
}

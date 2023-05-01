const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const input = `10
1 2 3 4 5 6 7 8 9 10`.toString().trim().split('\n');

const num = +input[0];
const arr = input[1].split(' ').map(Number);
let dp = Array(num).fill(1);

for(let i=1 ; i<arr.length; i++){
    for(j=0 ; j<i ; j++){
        if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j]+1);
    }
}

console.log(Math.max(...dp));

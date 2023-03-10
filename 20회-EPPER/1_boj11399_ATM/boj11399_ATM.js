const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const input = fs.readFileSync('/Users/jieun/Documents/GitHub/Algorithm_Study/20회-EPPER/1_boj11399_ATM/input.txt').toString().split('\n');

let N = +input[0];
// 그냥 sort() 시 오류가 남.
let arr = input[1].split(" ").map(n=>+n).sort((a, b)=> a-b);
let ans=0;

for(let i=0 ; i<N ; i++){
    ans +=arr[i]*(N-i);
}

console.log(ans);
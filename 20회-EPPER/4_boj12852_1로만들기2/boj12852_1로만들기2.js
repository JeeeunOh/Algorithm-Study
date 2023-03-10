// 1부터 num까지 거꾸로 올라가기
// dp_string : string
// dp_cnt : 연산 횟수

// case 1 : X가 3으로 나누어 떨어지면, 3으로 나눈다.
// case 2 : X가 2로 나누어 떨어지면, 2로 나눈다.
// case 3 : 1을 뺀다.

const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const input = fs.readFileSync('/Users/jieun/Documents/GitHub/Algorithm_Study/20회-EPPER/4_boj12852_1로만들기2/input.txt').toString().split('\n');

let num = +input[0];
let dp_string = new Array(num+1).fill([]);
let dp_cnt = new Array(num+1).fill(0);

dp_string[1] = '1';

for(let i=2 ; i<=num ; i++){
    // 디폴트는 case3
    dp_cnt[i] = dp_cnt[i-1]+1;
    dp_string[i] = dp_string[i-1]+` ${i}`
    // case 2
    if(i%2===0){
        let temp = dp_cnt[i/2]+1;
        if(dp_cnt[i]>temp){
            dp_cnt[i] = temp;
            dp_string[i] = dp_string[i/2]+` ${i}`;
        }
    }
    // case 1
    if(i%3===0){
        let temp = dp_cnt[i/3]+1;
        if(dp_cnt[i]>temp){
            dp_cnt[i] = temp;
            dp_string[i] = dp_string[[i/3]]+` ${i}`;
        }
    }
}

console.log(dp_cnt[num]);
let ans = dp_string[num].split(" ").reverse().join(" ");
console.log(ans);
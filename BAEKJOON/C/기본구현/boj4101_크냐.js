const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const input = fs.readFileSync('/Users/jieun/Documents/GitHub/Algorithm_Study/개인공부/기본구현/input.txt').toString().trim().split('\n');
let i=0;
while(true){
    let [a, b] = input[i].split(' ').map(Number);
    i++;
    if(a===0 && b===0) return;
    if(a>b){
        console.log('YES');
    } else {
        console.log('NO');
    }
}

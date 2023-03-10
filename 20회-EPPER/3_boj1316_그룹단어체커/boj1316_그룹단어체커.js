const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const input = fs.readFileSync('/Users/jieun/Documents/GitHub/Algorithm_Study/20회-EPPER/3_boj1316_그룹단어체커/input.txt').toString().split('\n');

let cnt = +input[0];
let res=0;

function isWord(st){
    let arr = new Array(200).fill(0);
    arr[st[0].charCodeAt(0)]++;
    for(let i=1 ; i<st.length; i++){
        let ch = st[i].charCodeAt(0);
        // 이전 글자와 같지 않은데 이전에 해당 알파벳이 나왔었다면
        if(st[i-1]!=st[i] && arr[ch]!=0){
            return false;
        }
        // 해당 알파벳 나왔었다고 체킹
        arr[ch]++;
    }
    return true;
}

for(let i=1; i<=cnt; i++){
    let st = input[i];
    if(isWord(st)) res++;
}

console.log(res);
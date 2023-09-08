const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

const N = +input[0];
const arr = input[1].split(' ').map(Number);
let ans = Array(N).fill(-1);
let st = [];

for (let i = 0; i < N; i++) {
    let cur = arr[i];
    while (st.length) {
        // 스택 맨 위부터 탐색
        let top = st.at(-1);
        if (top.num < cur) {
            // 제일 위 요소가 현재 요소보다 작으면
            ans[top.idx] = cur; // 정답 추가해주고
            st.pop(); // 빼기
        } else break; // 아니면 while문 빠져나오기
    }
    st.push({ num: cur, idx: i });
}

console.log(ans.join(' '));

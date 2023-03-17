const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const input = fs.readFileSync('/Users/jieun/Documents/GitHub/Algorithm_Study/20회-EPPER/8_boj2638_치즈/input.txt').toString().split('\n');

let [N, M] = input.shift().split(' ').map(Number);
let dx = [1, -1, 0, 0];
let dy = [0, 0, -1, 1];
let remainCount = 0;
let answer = 0;
let matrix = input.slice(0).map((row)=> row.split(' ').map(Number));

matrix.forEach(arr => {
    arr.forEach(num => {
        if (num === 1) remainCount++;
    });
})

function dfs(cx, cy) {
    // 정해진 범위 밖이면 return
    if (cx < 0 || cy < 0 || cx >= N || cy >= M) return;
    if (matrix[cx][cy] === -1) return;
    if (matrix[cx][cy] >= 1) {
        matrix[cx][cy] += 1;
        return;
    }
    if (matrix[cx][cy] === 0) matrix[cx][cy] = -1;

    for (let i = 0; i < 4; i++) {
        let nextY = cx + dy[i];
        let nextX = cy + dx[i];
        dfs(nextY, nextX);
    }
}

// 치즈가 하나라도 남아있다면 반복
while (remainCount > 0) {
    answer++;
    let x, y = 0;
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (matrix[i][j] === -1) matrix[i][j] = 0;
            if (matrix[i][j] === 2) matrix[i][j] = 1;
            if (matrix[i][j] === 0) x = i, y = j;
        }
    }
    dfs(x, y);

    // 외부 공기와 2번 이상 겹친 치즈는 0으로 바꾸기
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            if (matrix[i][j] >= 3) {
                matrix[i][j] = 0;
                remainCount--;
            }
        }
    }
    if (remainCount <= 0) break;
}

console.log(answer);
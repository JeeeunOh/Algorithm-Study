const [[N, M], ...paper] = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map(v => v.split(' ').map(Number));

const maxValue = paper
  .reduce(
    (acc, row) => 
    	Math.max(acc, row.reduce((acc, v) => Math.max(acc, v), 0)),
    0
  );
  
const offset = [[0, 1], [0, -1], [1, 0], [-1, 0]];
const visited = [...Array(N)].map(() => Array(M).fill(false));
let maxSum = 0;

const dfs = (x, y, count, sum) => {
  if (sum + (4 - count) * maxValue <= maxSum) {
    return;
  }

  if (count === 4) {
    maxSum = Math.max(maxSum, sum);
    return;
  }

  for (const [dx, dy] of offset) {
    const nx = x + dx;
    const ny = y + dy;
    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {

      if (count === 2) {
        visited[nx][ny] = true;
        dfs(x, y, count + 1, sum + paper[nx][ny]);
        visited[nx][ny] = false;
      }

      visited[nx][ny] = true;
      dfs(nx, ny, count + 1, sum + paper[nx][ny]);
      visited[nx][ny] = false;
    }
  }
};

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    visited[i][j] = true;
    dfs(i, j, 1, paper[i][j]);
    visited[i][j] = false;
  }
}

console.log(maxSum);
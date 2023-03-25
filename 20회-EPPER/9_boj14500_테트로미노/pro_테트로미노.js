function solution (N, M, paper) {
  // 자리에 위치한 최대값
  let maxValue = 0;
  paper.forEach((row)=>{
    row.forEach((item)=>{
      maxValue = Math.max(item, maxValue)
    })
  })
  
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];
  const visited = [...Array(N)].map(() => Array(M).fill(false));
  let maxSum = 0;

  const dfs = (x, y, count, sum) => {
    // 정사각형 4개 이어 붙임 -> 테트로미노
    if (count === 4) {
      maxSum = Math.max(maxSum, sum);
      return;
    }

    for (let i=0 ; i<4; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];
      if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
      
      if (count === 2) {
        visited[nx][ny] = true;
        dfs(x, y, count + 1, sum + paper[nx][ny]);
        visited[nx][ny] = false;
      }

      visited[nx][ny] = true;
      dfs(nx, ny, count + 1, sum + paper[nx][ny]);
      visited[nx][ny] = false;

    }
  };
  
  // 백트래킹으로 시작점!!
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      visited[i][j] = true;
      dfs(i, j, 1, paper[i][j]);
      visited[i][j] = false;
    }
  }

  return maxSum;
}


const ch = ['1 2 3 4 5',
'5 4 3 2 1',
'2 3 4 5 6',
'6 5 4 3 2',
'1 2 1 2 1']
const arr = ch.map(item=>item.split(' ').map(Number));
console.log(solution(5, 5, arr)); // 19
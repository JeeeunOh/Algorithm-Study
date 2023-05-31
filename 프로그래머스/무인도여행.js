function solution(maps) {
  var answer = [];
  maps = maps.map((item) => item.split(''));
  let row = maps[0].length;
  let column = maps.length;

  let d = [
    [-1, 0],
    [1, 0],
    [0, 1],
    [0, -1],
  ];

  for (let i = 0; i < column; i++) {
    for (let j = 0; j < row; j++) {
      if (maps[i][j] != 'X') {
        let temp = +maps[i][j];
        let queue = [[i, j]];
        maps[i][j] = 'X';

        while (queue.length) {
          let [cx, cy] = queue.shift();
          for (const [dx, dy] of d) {
            let [nx, ny] = [cx + dx, cy + dy];
            if (nx < 0 || nx >= column || ny < 0 || ny >= row) continue;
            if (maps[nx][ny] === 'X') continue;
            temp += +maps[nx][ny];
            maps[nx][ny] = 'X';
            queue.push([nx, ny]);
          }
        }
        answer.push(temp);
      }
    }
  }

  return answer.length === 0 ? [-1] : answer.sort((a, b) => a - b);
}

function solution(maps) {
  let map = maps.map((item) => item.split(''));
  let N = map.length;
  let M = map[0].length;

  let dx = [-1, 1, 0, 0];
  let dy = [0, 0, -1, 1];

  const dfs = (x, y, cnt) => {
    for (let i = 0; i < 4; i++) {
      let [nx, ny] = [x + dx[i], y + dy[i]];
      if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 'X') {
        let num = +map[nx][ny];
        map[nx][ny] = 'X';
        cnt += dfs(nx, ny, num);
      }
    }
    return cnt;
  };

  var answer = [];

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (map[i][j] != 'X') {
        let num = +map[i][j];
        map[i][j] = 'X';
        answer.push(dfs(i, j, num));
      }
    }
  }

  return answer.length ? answer.sort((a, b) => a - b) : [-1];
}

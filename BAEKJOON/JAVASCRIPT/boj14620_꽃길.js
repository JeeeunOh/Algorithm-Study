const readFileSyncAddress = process.platform === 'linux' ? '/dev/stdin' : '/Users/jieun/Documents/GitHub/Algorithm_Study/BAEKJOON/JAVASCRIPT/input.txt';

const input = require('fs').readFileSync(readFileSyncAddress).toString().trimEnd().split('\n');

let n = +input[0],
  min = 600;
let arr = input.slice(1).map((item) => item.split(' ').map(Number));
let temp = input.slice(1).map((item) => item.split(' ').map(Number));

let dx = [-1, 1, 0, 0];
let dy = [0, 0, -1, 1];

const dfs = (cx, cy, sum, cnt) => {
  for (let i = 0; i < 4; i++) {
    let [nx, ny] = [cx + dx[i], cy + dy[i]];
    if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] === -1) return;
  }
  for (let i = 0; i < 4; i++) {
    // 꽃술 주변 꽃잎들도 다 위치시키기
    let [nx, ny] = [cx + dx[i], cy + dy[i]];
    sum += arr[nx][ny];
    arr[nx][ny] = -1;
  }

  console.log(cx, cy, sum, cnt);

  cnt++;
  if (cnt === 3) {
    // 꽃 3개 다 배치했다면
    arr[cx][cy] = temp[cx][cy];

    for (let i = 0; i < 4; i++) {
      // 해당 꽃 위치 리턴
      let [nx, ny] = [cx + dx[i], cy + dy[i]];
      arr[nx][ny] = temp[nx][ny];
    }

    console.log(arr);
    min = Math.min(min, sum);
    return;
  }

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (arr[i][j] !== -1) {
        arr[i][j] = -1;
        dfs(i, j, sum, cnt);
        arr[i][j] = temp[i][j];
      }
    }
  }

  arr[cx][cy] = temp[cx][cy];

  for (let i = 0; i < 4; i++) {
    // 해당 꽃 위치 리턴
    let [nx, ny] = [cx + dx[i], cy + dy[i]];
    arr[nx][ny] = temp[nx][ny];
  }

  return;
};

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    dfs(i, j, 0, 0);
  }
}

console.log(min);

// 20:09 -> 20:22
function solution(maps) {
  let answer=Infinity;
  let n = maps.length, m = maps[0].length;
  let dx = [0, 0, -1, 1], dy = [-1, 1, 0, 0];
  let queue = [[0, 0, 1]];
  maps[0][0] = 0;
  
  while(queue.length){
      let [cx, cy, cnt] = queue.shift();
      if(cx===n-1 && cy===m-1) return cnt;
      
      for(let i=0 ; i<4 ; i++){
          let [nx, ny] = [cx+dx[i], cy+dy[i]];
          if(nx<0 || nx>= n || ny<0 || ny>=m) continue;
          if(maps[nx][ny]){
              maps[nx][ny] = 0;
              queue.push([nx, ny, cnt+1]);
          }
      }
  }
  
  return -1;
}


function solution(maps) {
  let answer = 1;
  let visited = maps;
  let queue = [];
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];
  const n = maps.length;
  const m = maps[0].length;

  queue.push([0, 0]);
  visited[0][0] = 0;

  while (queue.length > 0) {
    let size = queue.length;

    for (let i = 0; i < size; i++) {
      let [x, y] = queue.shift();

      for (let j = 0; j < 4; j++) {
        let nx = x + dx[j];
        let ny = y + dy[j];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] === 1) {
          if (nx == n - 1 && ny == m - 1) {
            return ++answer;
          }
          queue.push([nx, ny]);
          visited[nx][ny] = 0;
        }
      }
    }
    answer++;
  }

  return -1;
}

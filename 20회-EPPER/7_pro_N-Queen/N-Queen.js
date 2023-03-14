// 풀이링크 : https://velog.io/@longroadhome/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-LV.3-%EC%B5%9C%EA%B3%A0%EC%9D%98-%EC%A7%91%ED%95%A9-JS-2xs6gra3

function solution(n) {
    let answer = 0;
    
    const dfs = (board, row) => {
        // 퀸을 n번째 row까지 놓았다면 ++
        if(row === n) answer++;
        // 아니라면 다음 row 탐색
        else {
            for(let i = 1; i <= n; i++) {
            board[row+1] = i;
            // 해당 위치에 퀸 놓을 수 있으면 계속 dfs 탐색
            if(isValid(board, row+1)) dfs(board, row+1);
            }
        }
    }
    
    const isValid = (board, row) => {
      for(let i = 1; i < row; i++) {
        // 같은 column에 있으면 false
        if(board[i] === board[row]) return false;
        // 대각선 상에 있으면 false
        if(Math.abs(board[i] - board[row]) === Math.abs(i - row)) return false;
      }
      return true;
    }
    
    // 가로, 세로, 대각선에 겹치는 것 있으면 X
    // 1 ~ n 번째 row에 퀸 하나씩 놓음.
    // 이 때 board[a] = b;는 [a][b]에 퀸이 있다는 것을 의미한다.
    for(let i = 1; i <= n; i++) {
      const board = new Array(n+1).fill(0);
      board[1] = i;
      dfs(board, 1);
    }
    
    return answer;
  }
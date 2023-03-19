// 가로, 세로에 있으면 안됨.
function solution(n) {
    let answer = 0;
    
    // map[i]=1 일 경우, arr[i][1] 에 퀸이 있음.
    let map = new Array(n).fill(0);
    
    const isValid = (row) => {
        for(let i=0 ; i<row; i++){
            // 같은 세로 상에 있으면 false
            if(map[i]===map[row]) return false;
            // 같은 대각성 상에 있으면 false
            if(Math.abs(i-row)/Math.abs(map[i]-map[row]) === 1) return false;
        }
        return true;
    }
    
    const dfs = (row) => {
        // 마지막 row까지 퀸 놨으면 ++
        if(row===n) { 
            answer++;
            // console.log(answer, map)
            return;
        }
        
        // row 남았으면 계속하기
        for(let i=0; i<n; i++){
            map[row] = i;
            // (row, i) 에 퀸 놓았을 때 valid한지 판별하고
            // valid 하면 dfs 돌리기
            if(isValid(row)){
                dfs(row+1);
            }
            map[row] = 0;
        }
    }
    
    dfs(0);
    
    return answer;
  }
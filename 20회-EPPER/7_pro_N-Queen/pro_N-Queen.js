function solution(n) {
    let answer = 0;
    let map = new Array(n).fill(0);
    
    const isValid = (row) => {
        for(let i=0 ; i<row; i++){
            if(map[i]===map[row]) return false;
            if(Math.abs(map[i]-map[row]) === row - i ) return false;
        }
        return true;
    }
    
    const dfs = (row) => {
        if(row===n) { 
            answer++;
            return;
        }

        for(let i=0; i<n; i++){
            map[row] = i;
            if(isValid(row)){
                dfs(row+1);
            }
            map[row] = 0;
        }
    }
    
    dfs(0);
    
    return answer;
  }
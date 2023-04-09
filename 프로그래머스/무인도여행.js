function solution(maps) {
    let map = maps.map((item)=>item.split(''));
    let N = map.length
    let M = map[0].length;
    
    let dx = [-1, 1, 0, 0];
    let dy = [0, 0, -1, 1];

    
    const dfs = (x, y, cnt) => {
        for(let i=0 ; i<4 ; i++){
            let [nx, ny] = [x+dx[i], y+dy[i]];
            if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!='X'){
                let num = +map[nx][ny]
                map[nx][ny] = 'X';
                cnt+=dfs(nx, ny, num);
            }
        }
        return cnt;
    }
    
    var answer = [];
    
    for(let i=0 ; i<N; i++){
        for(let j=0 ; j<M; j++){
            if(map[i][j]!='X') {
                let num = +map[i][j];
                map[i][j]='X';
                answer.push(dfs(i, j, num));
            }
        }
    }
    
    return answer.length? answer.sort((a, b)=>a-b) : [-1];
}
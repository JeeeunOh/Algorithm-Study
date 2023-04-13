function solution(dirs) {
    let set = new Set();
    let dir = {U:[0, 1], D:[0, -1], R:[1, 0], L:[-1, 0]};
    
    let cur = [5, 5] // +5, +5 하고 시작
    
    let arr = dirs.split('');
    
    for(let i=0 ; i<arr.length; i++){
        let item = arr[i];
        let [nx, ny] = [cur[0]+dir[item][0], cur[1]+dir[item][1]];
        if(nx<0 || nx>10 || ny<0 || ny>10) continue;
        let json = JSON.stringify([cur, [nx, ny]].sort());
        set.add(json);
        cur = [nx, ny];
    }
    
    return set.size;
}
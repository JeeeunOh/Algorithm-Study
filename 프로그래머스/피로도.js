// 백트래킹 풀이
function solution(k, dun) {
    // 현재 피로도, [최소 필요, 소모]
    let max = 0;
    
    const searchDun = (curK, cnt) => {
        max = Math.max(max, cnt);
        
        for(let i=0 ; i<dun.length; i++){
            let [a, b] = dun[i];
            if(a!=-1 && a<=curK){ // 최소 필요 만족하면, 백트래킹
                dun[i] = [-1, -1];
                searchDun(curK-b, cnt+1);
                dun[i] = [a, b];
            }
        }
    }
    
    searchDun(k, 0);
    
    return max;
}

// 예전에 틀렸던 풀이
function solution(k, dun) {
    // 현재 피로도, [최소 필요, 소모]
    let max = -1;
    let len = dun.length;

    // 현재 몇번째 던전인지, 몇개를 돌았는지, 체력은 얼마나 남았는지, 던전 배열
    function dfs (idx, cnt, hp){
        let flag = false;
        let cur = dun[idx];
        
        console.log(cur);
        console.log(hp);
        
        // 던전에 들어간 경우
        if(cur[1]<=hp){
            flag = true;
            for(let i=idx+1 ; i<len; i++){
                dfs(i+1, cnt+1, hp-cur[1]);
            }
            if(idx==len-1 && cnt+1 > max) max = cnt+1;
        }
        
        // 안 들어간 경우
        for(let i=idx+1 ; i<len; i++){
            dfs(i, cnt, hp);
        }
        
        if(idx==len-1 && cnt > max) max = cnt;
    }
    
    
    for(let i=0 ; i<len; i++){
        dfs(i, 0, k);
    }
    
    return max;
}
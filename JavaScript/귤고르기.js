function solution(k, tangerine) {
    var cnt = 0;
    let map = new Map();
    
    tangerine.map((item)=>(
        map.get(item)?
        map.set(item, map.get(item)+1)
        :
        map.set(item, 1)
    ))
    
    const mapList = [...map]
    
    mapList.sort((a, b)=> b[1]-a[1]);
    
    for(let i=0 ; i<mapList.length; i++){
        k-=mapList[i][1];
        cnt++;
        if(k<=0) break;
    }
    
    return cnt;
}
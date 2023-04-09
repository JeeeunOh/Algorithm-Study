function solution(citations) {
    var answer = 0;
    let map = new Map();
    
    citations.forEach(key=>{
        for(let i=1; i<=key; i++){
            if(map.has(i)) map.set(i, map.get(i)+1);
            else map.set(i, 1);
        }
    })
    
    let mapToArr = [...map]
    mapToArr.sort((a, b)=>b[0]-a[0]);
    
    for(const item of mapToArr){
        if(item[0]<=item[1]) return item[0];
    }
    
    return 0;
}
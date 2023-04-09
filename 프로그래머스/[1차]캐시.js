function solution(cacheSize, cities) {    
    if(cacheSize===0) return cities.length*5;
    
    var answer = 0;
    let arr = [];
   
    for(let i=0 ; i<cities.length; i++){
        let cur = cities[i].toUpperCase(); // 현재도시
        let idx = arr.indexOf(cur)
        
        if(idx===-1){ // 캐시에 존재하지 않으면
            if(arr.length===cacheSize){ // 캐시가 꽉차있으면 빼기
                arr.shift();
            }
            arr.push(cur);
            answer+=5;
        } else { // 캐시에 존재하면
            arr = arr.filter((_, id)=> id!=idx);
            arr.push(cur);
            answer+=1;
        }
    }
    return answer;
}
// slice, filter 등을 이용한 구현
function solution(want, number, discount) {
    var answer = 0;
    
    for(let i=10 ; i<=discount.length; i++){
        let disSlice = discount.slice(i-10, i);
        
        for(let j=0 ; j<want.length ; j++){
            if(disSlice.filter(item=> item===want[j]).length!=number[j]) break;
            if(j===want.length-1) {
                answer++;
            }
        }
    }
    
    return answer;
}
// map을 이용한 구현
function solution(want, number, discount) {
    var answer = 0;
    let wantMap = new Map();
    for(let i=0 ; i<want.length; i++){
        wantMap.set(want[i], number[i]);
    }
    
    let disMap = new Map();
    
    for(let i=0 ; i<discount.length; i++){
        let key = discount[i];
        if(i>9) disMap.set(discount[i-10], disMap.get(discount[i-10])-1); 
        if(disMap.has(key)){
            disMap.set(key, disMap.get(key)+1);
        } else {
            disMap.set(key, 1);
        }
        
        if(i<9) continue;
        
        for(let j=0 ; j<want.length; j++){
            let wKey = want[j];
            if(wantMap.get(wKey)!=disMap.get(wKey)) break;
            if(j===want.length-1) answer++;
        }
    }
    
    return answer;
}
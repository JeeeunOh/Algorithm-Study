// 수정 풀이 : 각 숫자에 대한 소수를 판별함.
function solution(n, k) {
    var answer = 0;
    
    const isValid = (n) => {
        for(let i=2 ; i<=Math.sqrt(n) ; i++){
            if(n%i===0) return false;
        }
        return true;
    }
     
    let arr = n.toString(k).split('0').filter(item=> item!='');
    arr.forEach(item=>{
        if(+item>=2 && isValid(+item)) answer++;
    })
    
    return answer;
}

// 틀린 이유 : n을 2진수로 바꿨을 떄...
function solution(n, k) {
    var answer = 0;
    let dp = new Array(1000001).fill(false); // 모두 소수라고 가정. 소수면 false
    dp[0] = dp[1] = true;
    
    console.log(Number(1000001).toString(2));
    
    for(let i=2 ; i < 1000001 ; i++){
        for(let mul=2 ; mul*i<1000001; mul++){
            dp[mul*i] = true;
        }
    }
    
    let arr = n.toString(k).split('0').filter(item=> item!='');
    arr.forEach(item=>{
        if(!dp[+item]) answer++;
    })
    
    return answer;
}
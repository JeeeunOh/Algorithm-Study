// 주어진 범위만 구함.
function solution(n, left, right) {
    var answer = [];
    let start = Math.floor(left/n);
    let end = Math.ceil(right/n);
    
    for(let i=start+1 ; i<=end+1 ; i++){
        for(let j=1 ; j<=n ; j++){
            if(j<=i) answer.push(i);
            else answer.push(j);
        }
    }
    
    return answer.slice(left-start*n, right-start*n+1);
}

// 런타임 에러 : 모든 범위 구했음.
function solution(n, left, right) {
    var answer = [];
    for(let i=1 ; i<=n ; i++){
        for(let k=0 ; k<i ; k++){
            answer.push(i);
        }
        for(let j=i+1 ; j<=n ; j++){
            answer.push(j);
        }
    }
    
    return answer.slice(left, right+1);
}

// 괴물 풀이
function solution(n, left, right) {
    var answer = [];

    for (let i = left; i <= right; i++) {
        answer.push(Math.max(i % n, parseInt(i / n)) + 1)
    }

    return answer;
}
//1. 정답 풀이

// 2. 시간초과 풀이
function solution(S, P, Q) {
    let M = P.length;
    let answer = [];
    let map = new Map();
    map.set('A', 1); map.set('C', 2); map.set('G', 3); map.set('T', 4);

    for(let i=0 ; i<M ; i++){
        let [start, end] = [P[i], Q[i]];
        let min = 5;
        for(let j=start ; j<=end ; j++){
            min = Math.min(min, map.get(S[j]));
        }
        answer.push(min);
    }
    
    return answer;
}

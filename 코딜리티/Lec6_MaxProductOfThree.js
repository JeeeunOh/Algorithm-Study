// 본 풀이 : O(N * log(N))
function solution(A) {
    A.sort((a, b)=>b-a);
    return Math.max(A[0]*A[1]*A[2], A[0]*A[A.length-1]*A[A.length-2])
}

// 정확도 떨어진 풀이
function solution(A) {
    let minus = [];
    let plus = [];

    A.forEach((item)=>{
        if(item<0) minus.push(item);
        else plus.push(item);
    })

    plus.sort((a, b) => b-a);
    minus.sort((a, b)=> b-a);

    // 양수 3개 || 양수 1개, 음수 2개 
    // 양수 2개, 음수 1개 & 음수 3개
    let answer = - Math.pow(1000, 3);

    // 양수인 케이스 먼저 계산

    // console.log(plus);
    // console.log(minus);

    if(plus.length>=1){
        if(plus.length<3){
            return plus[0]*minus[0]*minus[1];
        } else {
            return Math.max(plus[0]*plus[1]*plus[2], plus[0]*minus[0]*minus[1]);
        }
    } else {
        let mLen = minus.length;
        let pLen = plus.length;
        if(plus.length<2){
            return minus[mLen-1]*minus[mLen-2]*minus[mLen-2];
        } else {
            return Math.max(plus[pLen-1]*plus[pLen-2]*minus[mLen-1], minus[mLen-1]*minus[mLen-2]*minus[mLen-2]);
        }
        
    }

    

    return answer;
}

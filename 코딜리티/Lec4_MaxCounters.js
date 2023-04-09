// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(N, A) {
    let answer = new Array(N).fill(0);
    let max = 0, setMax = -1;

    A.forEach((num)=>{
        if(num<=N){
            if(answer[num-1]<setMax){
                answer[num-1] = setMax;
            }
            answer[num-1]++;
            max = Math.max(max, answer[num-1]);
        } else if (num===N+1){
            // 원래는 여기에 배열 재생성 로직 넣었음 -> 시간초과 뜸.
            setMax = max;
        }
    })

    answer.forEach((_, idx)=>{
        if(answer[idx]<setMax){
            answer[idx] = setMax;
        }
    })

    return answer;
}

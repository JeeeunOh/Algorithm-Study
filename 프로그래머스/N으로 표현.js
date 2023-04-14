// 내 풀이
function solution(N, number) { // N을 이용해서 number 만들기
    let answer = 0;
    let useCnt = Array.from({length: 10}, (_, idx)=> new Set([+String(N).repeat(idx)]));
    
    for(let i=1 ; i<=9 ; i++){ // i개의 N개 사용하기
        for(let j=1 ; j<i ; j++){ // j개의 N에 대한 set 탐색하기
            for(const first of useCnt[j]){
                for(const second of useCnt[i-j]){ // useCnt[i-j] & useCnt[j]의 것들
                    useCnt[i].add(first+second);
                    useCnt[i].add(first/second);
                    useCnt[i].add(second/first);
                    useCnt[i].add(first-second);
                    useCnt[i].add(second-first);
                    useCnt[i].add(first*second);
                }
            }
        }
        if(useCnt[i].has(number)) return i;
    }
    
    return -1;
}

// 다른 사람 풀이
function solution(N, number) { // N을 이용해서 number 만들기
    let answer = 0;
    let use = Array.from(new Array(9), () => new Set()); // new Set 1~8 만들기
    
    if(N==number) return 1;
    else {
        use.forEach((set, idx) => {
            if (idx !== 0) set.add(Number(String(N).repeat(idx)));
        });
        for(let i=1 ; i<=8 ; i++) { // 숫자 8개까지 사용해보기
            for(let j=1 ; j<i ; j++) { // i개의 숫자를 사용하기 위헤 숫자 j개를 사용했을 때의 리스트 받아오기
                for(var first of use[j]) { 
                    for(var second of use[i-j]) { // 숫자 i-j 개 사용했을 떄 & 숫자 j개 사용했을 떄 연산하기
                        use[i].add(first+second);
                        use[i].add(first-second);
                        use[i].add(first*second);
                        use[i].add(first/second);
                    }
                }
            }
            if(use[i].has(number)) {
                console.log(i, use[i]);
                return i;
            }
        }
        // 8개 사용했을 때 없으면 -1 return
        return -1;
    }
    return answer;
}
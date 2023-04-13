function solution(n, times) {
    let answer=0;
    times.sort((a, b)=> b-a);
    let start=1, end = times[0]*n; // 최악의 경우 계산
    
    while(start<=end){
        let mid = Math.floor((start+end)/2); // 초
        
        let total = 0;
        for(const time of times){ // total초 동안 각 심사대는 Math.floor(mid/time) 명 심사 가능
            total+=Math.floor(mid/time);
        }
        
        if(total>=n) { // 다 심사할 수 있는 경우 -> 심사시간 줄이기
            answer = mid;
            end = mid-1;
        }
        else { // 다 심사하지 못하는 경우 -> 심사시간 늘이기
            start = mid+1; 
        }
    }
    return answer;
}
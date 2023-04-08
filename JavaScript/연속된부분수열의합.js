// 1. 1차시도 : 52.9
function solution(sequence, k) {
    let dp = [0];
    let answer = [];
    let minLen = 1001;
    for(let i=0 ; i<=sequence.length; i++){
        if(i!=sequence.length){
            dp[i+1] = dp[i] + sequence[i];
        }
        for(let j=0 ; j<=i ; j++){
            if(dp[i]-dp[j]===k){
                minLen = Math.min(minLen, i-j);
                answer.push([j, i-1, (i-j)]);
            }
        }
    }
    answer = answer.filter((item)=>item[2]===minLen);
    return [answer[0][0], answer[0][1]];
}

// 2. 투포인터 풀이
function solution(sequence, k) {
    let answer = [];
    let minLen = 1000001;
    let start = 0, end = 0, sum = 0; // start~end-1까지의 합
    
    while(start<=end){
        if (sum===k){
            if(end-start<minLen){
                minLen = end-start;
                answer = [start, end-1];
            }
        } 
        
        if(sum<=k){
            if(end===sequence.length) break;
            sum+=sequence[end];
            end++;
        } else if(sum>k){
            sum-=sequence[start];
            start++;
        }
    }
    
    return answer;
}

// [1,1,1,1,1,1,1], 7 [0, 6]
// [7,5,5,1,1,50,50], 100 , [5, 6]
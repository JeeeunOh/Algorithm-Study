// 내 풀이
// 노가다 of 노가다
function solution(elements) {
    let set = new Set();
    let dp = new Array(elements.length+1).fill(0);
    for(let i=0 ; i<elements.length; i++){
        dp[i+1] = dp[i] + elements[i];
    }
    
    for(let i=0 ; i<elements.length ; i++){
        for(let size=1 ; size<=elements.length ; size++){
            if(i+size < dp.length){
                set.add(dp[i+size] - dp[i]); // dp[1] - dp[0]; dp[elements.length+1] - dp[
            } else {
                set.add((dp[dp.length-1] - dp[i]) + (dp[i+size-dp.length+1]- dp[0]))
            }
            // console.log(i, size, set);
        }
    }
    
    return set.size;
}
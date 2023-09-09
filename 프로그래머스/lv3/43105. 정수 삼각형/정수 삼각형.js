function solution(tri) {
    var answer = 0;
    let dp = Array.from({length: tri.length}, (_, idx) => Array(idx+1).fill(0));
    dp[0][0] = tri[0][0];
    let max = 0;
    
    for(let i=1 ; i<tri.length; i++){
        for(let j=0 ; j<=i ; j++){
            if(j===0){
                dp[i][j] = dp[i-1][j] + tri[i][j];
            } else if (j===i){
                dp[i][j] = dp[i-1][j-1] + tri[i][j];
            } else {
                dp[i][j] = Math.max(dp[i-1][j-1] + tri[i][j], dp[i-1][j] + tri[i][j])
            }
            
            if(i===tri.length-1) max = Math.max(max, dp[i][j])
        }
    }
    
    return max;
}
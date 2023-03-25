function solution(num){
    let answer = [];
    let dp_string = new Array(num+1).fill([]);
    let dp_cnt = new Array(num+1).fill(0);

    dp_string[1] = [1];

    for(let i=2 ; i<=num ; i++){
        // 디폴트는 case3
        dp_cnt[i] = dp_cnt[i-1]+1;
        dp_string[i] = [...dp_string[i-1], i];
        // case 2
        if(i%2===0){
            let temp = dp_cnt[i/2]+1;
            if(dp_cnt[i]>temp){
                dp_cnt[i] = temp;
                dp_string[i] = [...dp_string[i/2], i];
            }
        }
        // case 1
        if(i%3===0){
            let temp = dp_cnt[i/3]+1;
            if(dp_cnt[i]>temp){
                dp_cnt[i] = temp;
                dp_string[i] = [...dp_string[i/3], i];
            }
        }
    }
    
    answer.push(dp_cnt[num])
    answer.push(dp_string[num].reverse());
    
    return answer;
}

console.log(solution(2));
// 1
// 2 1
console.log(solution(10));
// 3
// 10 9 3 1
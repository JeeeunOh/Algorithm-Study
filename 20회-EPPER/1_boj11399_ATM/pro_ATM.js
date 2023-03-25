function solution(n, arr){
    let answer=0;
    
    arr.sort((a, b)=> a-b);
    for(let i=0 ; i<n ;i++){
        answer+=arr[i]*(n-i);
    }

    return answer;
}

console.log(solution(5, [3, 1, 4, 3, 2]));
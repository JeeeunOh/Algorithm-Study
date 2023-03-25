function solution (n, arr) {
    let answer=0;
    // console.log('a'.charCodeAt(0)); // 97
    
    for(let i=0 ; i<n; i++){
        let cur = arr[i];
        let cnt = new Array(30).fill(0);
        cnt[cur[0].charCodeAt(0)-97]++;

        if(cur.length===1) answer++;

        for(let j=1; j<cur.length; j++){
            let ch = cur[j].charCodeAt(0)-97;
            // 이전 글자와 같지 않은데 이전에 해당 알파벳이 나왔다면
            if(cur[j-1]!=cur[j] && cnt[ch]!=0){
                break;
            }
            if(j===cur.length-1) answer++;
        }
    }
    
    return answer;
}

console.log(solution(3, ['happy', 'new', 'year'])); // 3
console.log(solution(4, ['aba', 'abab', 'abcabc', 'a'])); // 1
console.log(solution(5, ['ab', 'aa', 'aca', 'ba', 'bb'])); // 4
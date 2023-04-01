function solution(arr1, arr2) {
    var answer = [];
    
    console.log(arr1.length, arr2[0].length, arr1[0].length)
    
    for(let i=0 ; i<arr1.length; i++){
        let arr = [];
        for(let j=0 ; j<arr2[0].length; j++){
            let temp = 0;
            for(let k=0 ; k<arr1[0].length; k++){
                temp += arr1[i][k]*arr2[k][j];
            }
            arr.push(temp);
        }
        answer.push(arr);
    }
    
    return answer;
}
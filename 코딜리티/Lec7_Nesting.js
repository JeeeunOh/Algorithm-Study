function solution(S) {
    let arr = S.split('');
    let st = 0;

    for(let i=0 ; i<arr.length; i++){
        let item = arr[i];
        if(item==='(') st++;
        else{
            if(st>0) st--;
            else return 0;
        }
    }

    return st? 0:1;
}

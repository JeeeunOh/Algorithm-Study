function solution(A) {
    A.sort((a, b)=> a-b);

    for(let i=0 ; i<A.length-2 ; i++){
        let a = A[i], b=A[i+1], c=A[i+2];

        if(a+b>c && a+c>b && b+c>a) return 1;
    }
    
    return 0;
}

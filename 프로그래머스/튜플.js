function solution(s) {
    var answer = [];
    
    const arr = JSON.parse(s.replace(/{/g, "[").replace(/}/g, "]"));
    arr.sort((a, b)=> a.length-b.length);
    arr.forEach((list)=>{
        for(let i=0 ; i<list.length; i++){
            if(answer.indexOf(list[i])===-1) answer.push(list[i]);
        }
    })
    
    return answer;
}
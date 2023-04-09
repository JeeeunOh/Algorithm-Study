// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(A) {
    let map = new Map();
    A.forEach((item)=>{
        if(map.has(item)){
            map.set(item, map.get(item)+1);
        } else {
            map.set(item, 1);
        }
    })

    return map.size
}

function solution(N, M, K, matrix){
  let res = 0;
  let par = Array.from({length:N+1}, (_, i)=>i);
  const find = (x) => {
    return x===par[x]? x:par[x]=find(par[x]);
  }
  const union = (x, y) => {
    if(x>y) return union(y, x);
    x = find(x);
    y = find(y);
    par[y] = x;
  }
  for(const arr of matrix){
    for(let i=2 ; i<arr.length; i++){
      union(arr[1], arr[i]);
    }
  }
  let set = new Set();
  for(i=0; i<K.length; i++){
    const a = find(K[i]);
    set.add(a);
  }
  for(const arr of matrix){
    let flag = true;
    for(let i=1; i<arr.length; i++){
      const a = find(arr[i]);
      if(set.has(a)){
        flag = false;
        break;
      }
    }
    if(flag) res++;
  }

  return res;
}

console.log(solution(4, 3, [0], [[2, 1, 2], [1, 3], [3, 2, 3, 4]])) // 3
console.log(solution(4, 1, [1, 1], [[4, 1, 2, 3, 4]])) // 0
console.log(solution(4, 1, [0], [[4, 1, 2, 3, 4]])) // 1
console.log(solution(4, 5, [1, 1], [[1, 1], [1, 2], [1, 3], [1, 4], [2, 4, 1]])); // 2




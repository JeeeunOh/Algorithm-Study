function solution(N, M, K, matrix){
  let res = 0;
  const par = Array.from({ length: N + 1 }, (_, i) => i)
  // 부모 노드 찾음.
  const find = (x) => {
   return x === par[x] ? x : par[x] = find(par[x]);
  }
  // par[y]에 부모 노드 저장.
  const union = (x, y) => {
    if (x > y) return union(y, x)
    x = find(x)
    y = find(y)
    par[y] = x
  }
  for (let arr of matrix) {
    // 같은 파티끼리 union 묶음.
    const a = arr[1]
    for (let i = 2; i < arr.length; i++) {
      union(a, arr[i])
    }
  }
  // set에 거짓말쟁이들 union의 부모 노드 찾아서 집어넣음.
  const set = new Set()
  for (let i = 1; i < K.length; i++) {
    set.add(find(K[i]))
  }
  // 모든 arr 돌기
  for (let arr of matrix) {
    // 거짓말해도 되는 파티라고 가정
    let check = true
    for (let i = 1; i < arr.length; i++) {
      // 해당 파티의 부모노드가 set에 저장되어있다면
      const a = find(arr[i])
      if (set.has(a)) {
        // false
        check = false
        break;
      }
    }
    // 여전히 거짓말해도 되는 파티면
    if (check) {
      res ++;
    }
  }
  return res;
}

console.log(solution(4, 3, [0], [[2, 1, 2], [1, 3], [3, 2, 3, 4]])) // 3
console.log(solution(4, 1, [1, 1], [[4, 1, 2, 3, 4]])) // 0
console.log(solution(4, 1, [0], [[4, 1, 2, 3, 4]])) // 1
console.log(solution(4, 5, [1, 1], [[1, 1], [1, 2], [1, 3], [1, 4], [2, 4, 1]])); // 2




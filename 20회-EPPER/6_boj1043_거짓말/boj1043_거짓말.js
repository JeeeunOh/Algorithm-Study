const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const input = fs.readFileSync('/Users/jieun/Documents/GitHub/Algorithm_Study/20회-EPPER/6_boj1043_거짓말/input.txt').toString().split('\n');

// 솔루션 - 유니온파인드..어렵따....
const [N, M] = input.shift().split(' ').map(Number)
const K = input.shift().split(' ').map(Number)
const matrix = input.map(l => l.split(' ').map(Number))


const par = Array.from({ length: N + 1 }, (_, i) => i)
// console.log(par);
const find = x => x === par[x] ? x : par[x] = find(par[x])
const union = (x, y) => {
  if (x > y) return union(y, x)
  x = find(x)
  y = find(y)
  par[y] = x
}

for (let arr of matrix) {
  const a = arr[1]
  for (let i = 2; i < arr.length; i++) {
    union(a, arr[i])
  }
}

const set = new Set()
for (let i = 1; i < K.length; i++) {
  set.add(find(K[i]))
}

let res = 0
for (let arr of matrix) {
  let check = true
  for (let i = 1; i < arr.length; i++) {
    const a = find(arr[i])
    if (set.has(a)) {
      check = false
      break;
    }
  }
  if (check) res ++;
}
console.log(res)


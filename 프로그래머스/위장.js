function solution(clothes) {
  let map = new Map();

  for (let i = 0; i < clothes.length; i++) {
    if (map.has(clothes[i][1])) {
      map.set(clothes[i][1], map.get(clothes[i][1]) + 1);
    } else {
      map.set(clothes[i][1], 1);
    }
  }
  let answer = 1;
  let cnt = [];

  for (let item of map.values()) {
    cnt.push(item);
  }
  console.log(cnt);

  for (let i = 0; i < cnt.length; i++) {
    answer *= cnt[i] + 1;
  }

  return answer - 1;
}

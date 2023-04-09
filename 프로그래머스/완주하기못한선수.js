function solution(pt, ct) {
  // 참여선수, 완주 선수
  let map = new Map();

  for (let i = 0; i < ct.length; i++) {
    if (map.has(ct[i])) {
      map.set(ct[i], map.get(ct[i]) + 1);
    } else map.set(ct[i], 1);
  }

  // console.log(map)

  for (let i = 0; i < pt.length; i++) {
    if (map.has(pt[i])) {
      map.set(pt[i], map.get(pt[i]) - 1);
      if (map.get(pt[i]) == -1) return pt[i];
    } else {
      return pt[i];
    }
  }
}

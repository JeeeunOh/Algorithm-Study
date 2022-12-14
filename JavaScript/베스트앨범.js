// 내 풀이
function solution(genres, plays) {
  let map = {};

  genres.map((item, idx) => {
    map[item] = map[item] ? map[item] + plays[idx] : plays[idx];
  });

  let idx = [];
  for (let i = 0; i < genres.length; i++) {
    idx.push(i);
  }

  let genreCnt = {};

  idx = idx
    .sort((a, b) => {
      if (genres[a] != genres[b]) return map[genres[b]] - map[genres[a]];
      else if (genres[a] == genres[b] && plays[b] != plays[a])
        return plays[b] - plays[a];
      else if (genres[a] == genres[b] && plays[b] == plays[a]) return a - b;
    })
    .filter((idx) => {
      if (genreCnt[genres[idx]] >= 2) {
        // console.log("걸러내기")
        return false;
      }
      // console.log("걸러내기")
      genreCnt[genres[idx]] = genreCnt[genres[idx]]
        ? genreCnt[genres[idx]] + 1
        : 1;
      return true;
    });

  // console.log(genreCnt)

  return idx;
}

// 다른 사람 풀이
function solution(genres, plays) {
  var dic = {};
  genres.forEach((t, i) => {
    dic[t] = dic[t] ? dic[t] + plays[i] : plays[i];
  });

  var dupDic = {};
  return genres
    .map((t, i) => ({ genre: t, count: plays[i], index: i }))
    .sort((a, b) => {
      if (a.genre !== b.genre) return dic[b.genre] - dic[a.genre];
      if (a.count !== b.count) return b.count - a.count;
      return a.index - b.index;
    })
    .filter((t) => {
      if (dupDic[t.genre] >= 2) return false;
      dupDic[t.genre] = dupDic[t.genre] ? dupDic[t.genre] + 1 : 1;
      return true;
    })
    .map((t) => t.index);
}

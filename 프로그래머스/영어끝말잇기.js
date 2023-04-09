function solution(n, words) {
  let answer = [];

  // 상대방 뒷 글자와 다른 앞글자로 얘기할 때
  // 한 글자 얘기할 때
  // 이전에 등장한 단어 얘기할 때

  let i;
  let dic = {};

  for (i = 0; i < words.length; i++) {
    if (i != 0 && words[i][0] != words[i - 1].substr(-1)) break;
    if (words[i].length == 1) break;
    if (dic[words[i]]) break;
    dic[words[i]] = 1;
    if (i == words.length - 1) return [0, 0];
  }

  console.log(i);

  let idx = (i % n) + 1;
  if (idx === 0) idx = n;
  let turn = Math.floor(i / n) + 1;

  answer.push(idx);
  answer.push(turn);

  return answer;
}

// 탈락 요인
// 1. 한자리단어
// 2. 이전에 등장했던 단어
// 3. 시작 문자가 이전 끝문자랑 다를 때
function solution(n, words) {
  let set = new Set();
  let i=0;
  let flag = true;
  
  // n : 3일 때,
  
  for(i=0 ; i<words.length; i++){
      if(words[i].length===1) break; // 1. 한글자일때
      
      if(i===0) set.add(words[i]); // 가장 앞 단어일 때
      else {
          // 3. 앞의 끝단어랑 현재 시작단어랑 다를 때
          if(words[i][0]!=words[i-1][words[i-1].length-1]) break;
          else if(set.has(words[i])) break; // 2. 이전에 등장했던 단어일 때
          else set.add(words[i]);
      }
      if(i===words.length-1) flag = false;
  }
  
  return flag? [i%n+1, Math.floor(i/n)+1] : [0, 0]; // 사람, 차례
}

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

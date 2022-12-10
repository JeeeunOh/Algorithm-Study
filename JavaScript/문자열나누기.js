// 97.6 / 100.0

function solution(s) {
  var answer = 0;
  let start = s[0];
  let startN = 1;
  let otherN = 0;

  for (let i = 1; i < s.length; i++) {
    if (start != s[i]) {
      otherN++;
      if (startN == otherN) {
        answer++;

        start = s[i + 1];
        startN = 1;
        otherN = 0;
        i++;
      }
    } else {
      startN++;
    }
    if (i === s.length - 1 && startN != otherN) answer++;
  }

  return answer;
}

// 100점 풀이
function solution(s) {
  var answer = 0;
  let start = '';
  let startN = 0;
  let otherN = 0;

  for (let i = 0; i < s.length; i++) {
    // 첫 문자 세팅
    if (startN == 0 && otherN == 0) {
      start = s[i];
      startN++;
      answer++;
    } else {
      // 첫 문자가 아니라면
      if (start == s[i]) {
        // 첫 문자와 현재 문자 같으면
        startN++;
      } else {
        // 첫 문자와 현재 문자 다르면
        otherN++;
        if (startN == otherN) {
          startN = 0;
          otherN = 0;
        }
      }
    }
  }

  return answer;
}

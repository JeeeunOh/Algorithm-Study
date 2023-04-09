function solution(s) {
  var answer = [];
  var alpha = [];

  for (let i = 0; i < 26; i++) {
    alpha.push(-1);
  }

  for (let i = 0; i < s.length; i++) {
    var idx = s[i].charCodeAt(0) - 97;
    if (alpha[idx] == -1) answer.push(-1);
    else {
      answer.push(i - alpha[idx]);
    }
    alpha[idx] = i;
  }
  return answer;
}

function solution_other(s) {
  const answer = [];
  const alpha = new Map();
  s.split('').map((item, index) => {
    if (alpha.has(item)) {
      answer.push(index - alpha.get(item));
    } else {
      answer.push(-1);
    }
    alpha.set(item, index);
  });
  return answer;
}

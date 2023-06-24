function solution(n) {
  let n_len = n
    .toString(2)
    .split('')
    .filter((item) => item === '1').length;
  let ans = n + 1;
  while (true) {
    let newN_len = ans
      .toString(2)
      .split('')
      .filter((item) => item === '1').length;
    if (newN_len === n_len) return ans;
    ans++;
  }
}

// 14:40 ~
// 1. 첫 풀이 : 14:44 완성
// 2. 시간초과 생각 ~ : 1000000 넣었을 때 결과가 1초 안에 나옴 -> 패스
// 3. 최종 풀이 : 14:46
function solution(n) {
  let temp = n + 1;
  let nLen = String(n.toString(2))
    .split('')
    .filter((item) => item != '0').length;

  while (true) {
    let tempLen = String(temp.toString(2))
      .split('')
      .filter((item) => item != '0').length;
    if (tempLen === nLen) return temp;
    temp++;
  }
}

function solution(n) {
  function countOne(input) {
    let sum = 0;
    for (let i = 0; i < input.length; i++) {
      if (input[i] == '1') sum++;
    }
    return sum;
  }

  let answer = n;

  while (true) {
    answer++;
    if (countOne(n.toString(2)) == countOne(answer.toString(2))) {
      return answer;
    }
  }
}

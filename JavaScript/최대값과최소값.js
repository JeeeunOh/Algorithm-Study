// 내 풀이
function solution(s) {
  var answer = '';
  let arr = s.split(' ');
  let min = Number.MAX_SAFE_INTEGER,
    max = Number.MIN_SAFE_INTEGER;

  for (let i = 0; i < arr.length; i++) {
    if (Number(arr[i]) > max) max = Number(arr[i]);
    if (Number(arr[i]) < min) min = Number(arr[i]);
  }

  answer += min;
  answer += ' ';
  answer += max;

  return answer;
}
// 다른 사람 풀이
function solution(s) {
  const arr = s.split(' ');

  return Math.min(...arr) + ' ' + Math.max(...arr);
}

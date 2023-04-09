function solution(A, B) {
  var answer = 0;

  A.sort((a, b) => a - b);
  B.sort((a, b) => a - b);

  // A는 앞에서부터 곱하고 B는 뒤에서부터 곱하기...?
  A.map((item, idx) => {
    answer += item * B[B.length - 1 - idx];
  });

  return answer;
}

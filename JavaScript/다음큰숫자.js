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

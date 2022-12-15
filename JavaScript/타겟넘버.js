function solution(numbers, target) {
  var answer = 0;

  function dfs(idx, total) {
    let plus = total + numbers[idx];
    let minus = total - numbers[idx];

    idx++;
    if (idx == numbers.length - 1) {
      if (plus == target) answer++;
      if (minus == target) answer++;
      return;
    }
    dfs(idx + 1, plus);
    dfs(idx + 1, minus);
  }

  dfs(0, 0);

  return answer;
}

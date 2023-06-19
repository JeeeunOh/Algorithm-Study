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

function solution(numbers, target) {
  let answer = 0;

  const dfs = (curIdx, sum) => {
    if (curIdx === numbers.length) {
      if (sum === target) answer++;
      return;
    }
    dfs(curIdx + 1, sum - numbers[curIdx]);
    dfs(curIdx + 1, sum + numbers[curIdx]);
  };

  dfs(0, 0);

  return answer;
}

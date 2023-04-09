function solution(answers) {
  let answer = [];
  let correct = [0, 0, 0];
  let person = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ];
  let idx = [0, 0, 0];

  for (let i = 0; i < answers.length; i++) {
    for (let j = 0; j < 3; j++) {
      if (answers[i] == person[j][idx[j]]) {
        correct[j]++;
      }
      idx[j]++;
      if (idx[j] >= person[j].length) {
        idx[j] = 0;
      }
      // console.log(idx)
    }
  }

  // console.log(correct)

  let max = 0;

  for (let i = 0; i < 3; i++) {
    if (max < correct[i]) max = correct[i];
  }

  for (let i = 0; i < 3; i++) {
    if (max == correct[i]) answer.push(i + 1);
  }

  return answer;
}

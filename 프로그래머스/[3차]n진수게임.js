function solution(n, t, m, p) {
  var answer = '';
  let gameNumber = 0;
  let turnNumber = 1;

  while (true) {
    let temp = gameNumber.toString(n).split('');
    for (let i = 0; i < temp.length; i++) {
      if (turnNumber === p) {
        answer += temp[i].toUpperCase();
        if (answer.length === t) return answer;
      }
      turnNumber++;
      if (turnNumber > m) turnNumber = 1;
    }

    gameNumber++;
  }
}

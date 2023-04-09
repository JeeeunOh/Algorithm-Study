function solution(array, commands) {
  var answer = [];

  commands.map((item) => {
    let temp = array.slice();
    temp = temp.slice(item[0] - 1, item[1]);
    temp.sort((a, b) => a - b);
    answer.push(temp[item[2] - 1]);
  });

  return answer;
}

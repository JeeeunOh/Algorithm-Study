// 2개만 통과함.
function solution(brown, yellow) {
  var answer = [];
  let width = yellow + 2;
  let height = 1;

  while (true) {
    if (width * 2 + height * 2 - 4 == brown) break;
    else height++;
  }

  answer.push(width);
  answer.push(height);

  return answer;
}

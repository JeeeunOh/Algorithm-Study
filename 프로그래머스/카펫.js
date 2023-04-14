// 전부 통과함.
function solution(brown, yellow) {
  var answer = [];
  let width = 3, height = 3; // yellow 1 이상, brown 8이상이려면 적어도 3x3이어야함.
  
  while(true){
      height = (brown+4)/2 - width;
      if((width-2)*(height-2)===yellow && width>=height) break;
      else width++;
  }
  
  return [width, height];
}

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

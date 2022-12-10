function solution(input) {
  let cnt = 0;
  let ingre = [1, 2, 3, 1];
  let idx = 0; // 현재 탐색중인 햄버거 재료 위치

  while (true) {
    let flag = true;
    idx = 0;

    for (let i = 0; i < input.length; i++) {
      if (input[i] == ingre[idx]) {
        idx++;
      } else {
        if (input[i] == 1) idx = 1;
        else idx = 0;
      }

      if (idx == 4) {
        input.splice(i - 3, 4);
        cnt++;
        flag = false;
      }
    }
    // 처음부터 끝까지 탐색했을 때 어떤 햄버거도 만들 수 없었으면 break;
    if (flag) break;
  }

  return cnt;
}

function solution_blog(ingredient) {
  const stk = [];
  let cnt = 0;

  ingredient.forEach((ing, idx) => {
    stk.push(ing);

    if (stk.length >= 4) {
      const find = stk.slice(-4).join('');
      if (find === '1231') {
        stk.pop();
        stk.pop();
        stk.pop();
        stk.pop();
        cnt++;
      }
    }
  });

  return cnt;
}
// 다른 사람 풀이
function solution(ingredient) {
  let count = 0;

  for (let i = 0; i < ingredient.length; i++) {
    if (ingredient.slice(i, i + 4).join('') === '1231') {
      count++;
      ingredient.splice(i, 4);
      i -= 3;
    }
  }

  return count;
}
// 다른 사람 풀이 보고 응용
function solution(input) {
  const stk = [];
  let cnt = 0;

  for (let i = 3; i < input.length; i++) {
    if (input.slice(i - 3, i + 1).join('') === '1231') {
      input.splice(i - 3, 4);
      cnt++;
      i -= 3;
    }
  }

  return cnt;
}

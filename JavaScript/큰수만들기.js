// 83.3점 , 시간초과

// 처음부터 탐색하면서 이전숫자가 다음숫자보다 작으면 이전 숫자 바로 뺴버리기
// 한번 빼면 다시 처음부터 시작

function solution(number, k) {
  let answer = '';
  let temp = number.split('');
  let max = 0;

  // 배열로 만들어서
  // 요소 하나씩 탐색 후
  // 해당하는 것만 answer에 더하기

  while (k > 0) {
    for (let i = 0; i < temp.length; i++) {
      if (temp[i] < temp[i + 1]) {
        temp.splice(i, 1);
        k--;
        break;
      }
    }
  }

  answer = temp.join('');

  return answer;
}

// 스택으로 풀어야하는 코드
function solution(number, k) {
  let st = [];
  number = number.split('');

  for (let i = 0; i < number.length; i++) {
    // 스택에 아무것도 없으면 일단 넣기
    if (st.length === 0) {
      st.push(number[i]);
      continue;
    }
    // 스택에 뭐가 들어있으면
    // 제일 마지막 숫자가 현재 숫자보다 작으면 pop
    while (k > 0 && st[st.length - 1] < number[i]) {
      st.pop();
      k--;
    }
    // pop하는 동작 끝났으면 현재 숫자 push
    st.push(number[i]);
  }
  return st.join('').substr(0, st.length - k);
}

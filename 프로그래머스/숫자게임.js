function solution(A, B) {
  A.sort((a, b) => b - a);
  B.sort((a, b) => b - a);

  let j = 0; // B를 가리키는 인덱스
  let ans = 0; // 점수

  for (let i = 0; i < A.length; i++) {
    // i는 A를 가리키는 인덱스
    if (A[i] < B[j]) {
      // B가 더 클 때
      ans++; // 점수 증가
      j++; // B를 가리키는 인덱스 증가
    }
  }

  return ans;
}

function solution(A, B) {
  var answer = 0;
  A.sort((a, b) => a - b);
  B.sort((a, b) => a - b);

  console.log(A, B);

  const calc = (aIdx, bIdx, temp) => {
    if (aIdx >= A.length || bIdx >= B.length) {
      answer = Math.max(temp, answer);
      return;
    }
    if (A[aIdx] < B[bIdx]) {
      // 해당 라운드 이겼다고 가정
      calc(aIdx + 1, bIdx + 1, temp + 1);
    }

    calc(aIdx, bIdx + 1, temp);

    return;
  };

  calc(0, 0, 0);

  return answer;
}

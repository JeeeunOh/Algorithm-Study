// 학생 번호 체격순 ; 앞번호나 뒷번호한테 빌려주기
// 최대한 많은 학생들

// 92점 풀이

function solution(n, lost, reserve) {
  // 전체 학생 수, 도난 당한 번호 배열, 여분 있는 번호 배열
  // 학생 최댓값 return

  var answer = 0;

  for (let i = 1; i <= n; i++) {
    if (lost.find((item) => item == i)) {
      // 체육복 잃어버린 사람이면
      if (reserve.find((item) => item == i)) {
        // 자기가 여분 있는지
        answer++;
        reserve[reserve.findIndex((item) => item == i)] = 0;
      } else if (reserve.find((item) => item == i - 1)) {
        // 앞친구가 여분 있는지
        answer++;
        reserve[reserve.findIndex((item) => item == i - 1)] = 0;
      } else if (reserve.find((item) => item == i + 1)) {
        // 뒷친구가 여분 있는지
        answer++;
        reserve[reserve.findIndex((item) => item == i + 1)] = 0;
      }
      // 체육복 있는 사람이면 그대로 ++
    } else answer++;
  }

  return answer;
}

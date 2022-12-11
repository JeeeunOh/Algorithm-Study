// 각 기능 진도 100 일 때 반영 가능
// 뒤의 기능이 먼저 개발 가능
// 뒤의 기능은 앞의 기능 배포 때 함께 배포

function solution(pro, speeds) {
  // 배포 순서 정수 배열, 작업 개발 속도
  let answer = [];
  // 몇번째 pro가 배포되어야 하는지
  let idx = 0;

  while (idx != pro.length) {
    // 배포된 pro 면 패스
    if (pro[idx] == -1) {
      idx++;
      continue;
    }
    // pro마다 작업량 추가
    for (let i = idx; i < pro.length; i++) {
      if (pro[i] != -1) pro[i] += speeds[i];
    }
    // 해당 pro가 작업량 100 넘었으면
    if (pro[idx] >= 100) {
      let temp = 1;
      // 뒤의 작업 중 배포 가능한 작업들 찾기
      for (let i = idx + 1; i < pro.length; i++) {
        if (pro[i] >= 100) {
          pro[i] = -1;
          temp++;
        } else break;
      }
      // 다음 idx 찾아 떠나기
      answer.push(temp);
      idx++;
    }
  }

  return answer;
}

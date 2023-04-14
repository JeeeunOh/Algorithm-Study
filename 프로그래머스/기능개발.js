function solution(pro, speeds) {
  let answer = [];
  let day = Array.from({length:pro.length}, (_, idx)=>  Math.ceil((100-pro[idx])/speeds[idx]));
  
  for(let i=0 ; i<day.length; i++){
      if(day[i]===-1) continue;
      let temp = 1;
      for(let j=i+1 ; j<day.length; j++){
          if(day[j]>day[i]) break;
          if(day[j]!=-1 && day[j]<=day[i]){
              temp++;
              day[j]=-1;
          }
      }
      answer.push(temp);
  }
  
  return answer;
}

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

// 프로그래머스 다른 사람 풀이

function solution(pro, speeds) {
  let answer = [0];
  // 각각 며칠 걸리는지 days에 저장.
  let days = pro.map((item, index) => Math.ceil((100 - item) / speeds[index]));
  let maxDay = days[0];

  for (let i = 0, j = 0; i < days.length; i++) {
    if (days[i] <= maxDay) {
      answer[j] += 1;
    } else {
      maxDay = days[i];
      answer[++j] = 1;
    }
  }

  return answer;
}

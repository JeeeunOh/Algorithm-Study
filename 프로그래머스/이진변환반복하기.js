function solution(s) {
  let delCnt = 0, changeCnt = 0;
  
  while(true){
      // 0 제거 후 1의 개수 반환
      let newLen = s.split('').filter((item)=> item!='0').length;
      let bi = newLen.toString(2); // 남은 string을 이진수로 변환
      
      changeCnt++;
      delCnt+=s.length - newLen;
      
      s=bi;
      if(s==='1') break;
  }
  
  return [changeCnt, delCnt];
}

function solution(s) {
  let answer = [0, 0];
  let num = 0,
    delZero = 0;
  let len = 0;

  // 1이 될때까지 계산 반복
  while (s.length > 1) {
    num++;
    len = s.length;
    s = s.split('0').join('');
    delZero += len - s.length;

    s = s.length.toString(2);
    console.log(s);
  }

  answer = [num, delZero];
  return answer;
}

// 블로그 풀이
function solution(s) {
  let answer = [0, 0];
  let sLen = 0;

  while (s.length > 1) {
    sLen = s.length;
    s = s.split('0').join('');
    answer[0]++;
    answer[1] += sLen - s.length;
    s = s.length.toString(2);
  }

  return answer;
}

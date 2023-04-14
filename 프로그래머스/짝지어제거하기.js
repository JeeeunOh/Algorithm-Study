
// 14:48 시작
// 1. 첫 풀이 : 14:57
// 2. 시간초과 확인 -> 스택구조로 변경
// 3. 최종제출 : 15:??

function solution(s){
    
  let st = [];
  
  for(let i=0 ; i<s.length; i++){
      if(!st.length) st.push(s[i]);
      else{
          if(st[st.length-1]===s[i]) st.pop();
          else st.push(s[i]);
      }
  }
  
  return st.length? 0:1;
}

// 정확도 - 시간초과
function solution(s) {
  let answer = 0;
  let arr = s.split('');

  while (true) {
    let flag = true;
    for (let i = 0; i < arr.length - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        arr.splice(i, 2);
        flag = false;
      }
    }
    if (flag) break;
  }

  if (arr.length) return 0;
  else return 1;
}

// 정확도 - 시간초과 해결 / 효율성 - 싹 다 탈락
function solution(s) {
  let arr = s.split('');

  for (let i = 0; i < arr.length - 1; i++) {
    if (arr[i] == arr[i + 1]) {
      arr.splice(i, 2);
      flag = false;
      i -= 2;
    }
  }

  if (arr.length) return 0;
  else return 1;
}

// 효율성 ( 스택 구조 )
function solution(s) {
  var arr = [];

  for (var i = 0; i < s.length; i++) {
    if (arr[arr.length - 1] != s[i]) {
      arr.push(s[i]);
    } else {
      arr.pop();
    }
  }

  return arr.length > 0 ? 0 : 1;
}

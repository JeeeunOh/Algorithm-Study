// 정확도 100, 시간초과 0

function solution(s){
  let arr = [];
  
  s.split('').map((item)=>{
      let len = arr.length;
      if(len==0) arr.push(item);
      else if (item==')'){
          if(arr[len-1] == '(') arr.pop();
          else return false;
      } else if (item=='(') arr.push(item);
  })
  
  if(arr.length!=0) return false;

  return true;
}

// 
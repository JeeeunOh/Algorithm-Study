// 틀린 풀이
function solution(n) {
  let arr = [0, 0, 3, 0, 11];
  // 2일 때 3개 만들 수 있음
  // 4일 때 arr[i-2]*3 + arr[i-4]*2 개 만들 수 있음.
  
  if(n%2==1) return 0;

  for(let i=5 ; i<=n ; i++){
      if(i%2==1) arr.push(0);
      else{
          arr.push(arr[i-2]*3 + arr[i-4]*2);
      }
  }

  return arr[n];
}
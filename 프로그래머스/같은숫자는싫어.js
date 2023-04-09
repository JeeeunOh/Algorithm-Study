function solution(arr) {
  return arr.filter((item, idx) => item != arr[idx + 1]);
}

// 풀이
function solution(arr) {
  return arr.filter((val, index) => val != arr[index + 1]);
}

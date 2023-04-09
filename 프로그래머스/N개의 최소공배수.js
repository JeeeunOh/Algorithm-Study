function solution(arr) {
  arr.sort((a, b) => a - b);
  let answer = arr[arr.length - 1];

  while (answer++) {
    for (let i = 0; i < arr.length; i++) {
      if (answer % arr[i] != 0) break;
      if (i == arr.length - 1) return answer;
    }
  }
}

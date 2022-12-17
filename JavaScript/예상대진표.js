function solution(n, a, b) {
  let temp = 1;
  while (true) {
    if (Math.floor((a - 1) / 2 ** temp) == Math.floor((b - 1) / 2 ** temp)) {
      return temp;
    } else temp++;
  }
}

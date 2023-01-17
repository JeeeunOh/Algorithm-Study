// 76.9

function solution(storey) {
  let cnt = 0;

  while (storey) {
    let last = storey % 10;
    storey /= 10;
    storey = Math.floor(storey);

    if (last <= 5) {
      cnt += last;
    } else {
      cnt += 10 - last;
      storey++;
    }
  }

  return cnt;
}

// 기준점인 5를 반례 포인트로 잡기

// 75 -> 8
// 555 -> 14

// 끝이 5인 경우 일의 자리수만 생각하는게 아니라 십의 자
function solution(storey) {
  let cnt = 0;

  while (storey) {
    let last = storey % 10;
    storey /= 10;
    storey = Math.floor(storey);

    if (last < 5 || (last == 5 && (storey % 10) + 1 <= 5)) {
      cnt += last;
    } else if (last > 5 || (last == 5 && (storey % 10) + 1 > 5)) {
      cnt += 10 - last;
      storey++;
    }
  }

  return cnt;
}

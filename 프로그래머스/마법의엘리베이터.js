// 76.9

function solution(st) {
  let cnt = 0;

  while (st) {
    let last = st % 10;
    st /= 10;
    st = Math.floor(st);

    if (last <= 5) {
      cnt += last;
    } else {
      cnt += 10 - last;
      st++;
    }
  }

  return cnt;
}

// 기준점인 5를 반례 포인트로 잡기

// 75 -> 8
// 555 -> 14

// 100점
function solution(st) {
  let cnt = 0;

  while (st) {
    let last = st % 10;
    st /= 10;
    st = Math.floor(st);

    if (last < 5 || (last == 5 && (st % 10) + 1 <= 5)) {
      cnt += last;
    } else if (last > 5 || (last == 5 && (st % 10) + 1 > 5)) {
      cnt += 10 - last;
      st++;
    }
  }
  return cnt;
}

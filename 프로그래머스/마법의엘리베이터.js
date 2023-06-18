// 75 -> 8
// 555 -> 14

// 끝이 5인 경우 일의 자리수만 생각하는게 아니라 십의 자리수도 같이 생각해주어야 합니다.

// 예를 들어
// 45 인 경우 -1 * 5, -10 * 4 해서 9가 나오고
// 75인 경우 +1 * 5, +10 * 3, -100 * 1 해서 9가 나와야하는데,
// 75인 경우 +1 * 5, +10 * 2, -100 * 1 해서 8이 나와야하는데,
// 일의 자리만 처리하면 -1 * 5, -10 * 7 해서 12가 나옵니다.

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

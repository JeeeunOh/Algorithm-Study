// 시간초과...
const map = new Map(); // 해당 key를 조건으로 한 사람의 점수 배열

function solution(infos, querys) {
  var answer = [];

  // 1. 지원자들 정보 조건을 key로 하는 지원자들 점수 map으로 저장
  for (const info of infos) {
    let condition = info.split(' ');
    let score = +condition.pop();
    combination(condition, score, 0);
  }

  // 2. map 내 value 들 오름차순 정렬
  for (const [key, value] of map) {
    value.sort((o1, o2) => o1 - o2);
  }

  // 3. 주어진 조건 해당하는 케이스 이분탐색으로 구하기
  for (const query of querys) {
    let qArr = query.replace(/ and /g, '').split(' ');
    let score = +qArr.pop();

    answer.push(binarySearch(score, map.get(qArr.join(''))));
  }

  return answer;
}

function combination(condition, score, start) {
  let key = condition.join('');
  let value = map.get(key);

  value ? map.set(key, [...value, score]) : map.set(key, [score]);
  // map.set(key, map.get(key) ? [...map.get(key), score] : [score]);

  // -를 이용해 조합 만들기
  for (let i = start; i < condition.length; i++) {
    let combiArr = [...condition];
    combiArr[i] = '-';
    combination(combiArr, score, i + 1);
  }
}

function binarySearch(score, scoreArr) {
  // 이분탐색
  if (!scoreArr) return 0;

  let start = 0,
    end = scoreArr.length;
  while (start < end) {
    let mid = Math.floor((start + end) / 2);
    if (scoreArr[mid] >= score) end = mid;
    else start = mid + 1;
  }
  return scoreArr.length - start;
}

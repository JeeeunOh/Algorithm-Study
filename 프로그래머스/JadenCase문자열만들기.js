// 44점

function solution(s) {
  var answer = '';
  let arr = s.split(' ');

  for (let i = 0; i < arr.length; i++) {
    let cur = arr[i];
    answer += arr[i][0].toUpperCase();
    if (arr[i].length > 1) {
      answer += arr[i].substring(1, arr[i].length).toLowerCase();
    }

    if (i != arr.length - 1) answer += ' ';
  }

  return answer;
}

// 100점. 다른사람 풀이

function solution(s) {
  const words = s
    .split(' ')
    .map(
      (word) => word.substr(0, 1).toUpperCase() + word.substr(1).toLowerCase()
    );

  return words.join(' ');
}

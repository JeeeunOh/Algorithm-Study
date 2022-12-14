// fs 방식
const fs = require('fs');

// 개행문자(\n)로 구분된 각 행을 요소로 가지는 배열을 반환.
// 인코딩을 명시적으로 넘기지 않은 경우에는 raw Buffer가 반환되므로
// toString()함수를 호출하여 string으로 변환하여야 한다.
const input1 = fs.readFileSync(0).toString().split('\n');

// options으로 인코딩을 string 자료형으로 넘기는 경우, string을 반환한다.
const input2 = fs.readFileSync(0, 'utf8').split('\n');

// input2와 동일
const input3 = fs.readFileSync(0, { encoding: 'utf8' }).split('\n');

// readline 방식
const reader = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

reader.on('line', function (line) {
  input = line.split('');
  reader.close();
  let num = Number(input[0]);

  for (let i = 1; i <= num; i++) {
    let star = '';
    for (let j = 1; j <= i; j++) {
      star += '*';
    }
    console.log(star);
  }
});

// 정석 - 스택 이용
// 1. 스택이 비었다면 numbers의 인덱스를 넣어줌.
// 2. 스택에 원소가 하나라도 있고, numbers의 마지막 원소 < 현재 원소
// -> answer[st에서 pop한 인덱스]를 현재 탐색한 numbers의 원소로 바꿔줌.
// -> 이 조건이 맞다면 무한반복
function solution(numbers) {
    const answer = Array(numbers.length).fill(-1);
    const stack = [];
    for (let i = 0; i < numbers.length; i++) {
      while (stack && numbers[stack.at(-1)] < numbers[i]) {
        answer[stack.pop()] = numbers[i];
      }
      stack.push(i);
    }
    return answer;
  }

// 시간초과
function solution(numbers) {
    var answer = [];
    for(let i=0 ; i<numbers.length-1; i++){
        let max = -1;
        for(let j=i+1 ; j<numbers.length; j++){
            if(numbers[i] < numbers[j]){
                max = numbers[j];
                break;
            }
        }
        answer.push(max);
    }
    answer.push(-1);
    return answer;
}
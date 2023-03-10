function solution(board, moves) {
    let answer = 0;
    let arr = [0];
    let len = board.length;
    
    for(let i=0 ; i<moves.length; i++){
        // 몇번째 줄에서 꺼낼건가
        let idx = moves[i]-1;
        // 캐릭터 인형 종류 파악하기
        let char = 0; 
        for(let j=0 ; j<len ; j++){
            if(board[j][idx]!=0){
                char = board[j][idx];
                // 해당 줄에서 인형빼서 스택에 집어넣기
                board[j][idx] = 0;
                // 가장 위에 있는 인형이 char과 똑같으면 pop
                if(arr[arr.length-1] === char){
                    arr.pop();
                    answer+=2;
                } else { // 아니면 char 집어넣기
                    arr.push(char);
                }
                break;
            }
        }
    }
    
    return answer;
}
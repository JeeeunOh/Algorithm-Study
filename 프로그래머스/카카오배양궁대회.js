// 화살 갯수, 10 ~ 0 점 개수
// 라이언이 큰 차이로 우승 가능한 배열 return
function solution(n, info) {
    // 어피치 점수
    let apeachScore = 0;
    info.forEach((item, idx)=>{
        apeachScore +=item*(10-idx);
    })
    let lionScore = 0;
    let answer = [-1];
    
    // 현재 라이언 스코어, 남은 화살 개수, 탐색할 과녁 idx, 결과 배열
    const dfs = (curScore, restN, idx, scoreList) => {
        if(restN<=0 || idx>10){
            if(lionScore < curScore && apeachScore < curScore){
            // if(apeachScore < curScore){
            //     console.log(scoreList, lionScore, curScore);
            //     answer = scoreList;
            // }
                answer = scoreList;
            return;
            }
        }
        
        let newArray = Array.from(scoreList)
        
        // 이번 과녁에서 이겼을 때
        let lionNum = info[idx]+1;
        if(restN >= lionNum){
            newArray[idx] = lionNum;
            dfs(curScore+(10-idx), restN-lionNum, idx+1, newArray);
        }
        
        newArray[idx] = 0;
        // 이번 과녁에서 졌을 때
        dfs(curScore, restN, idx+1, newArray);
        
        return;
        
    }
    
    let lionNum = info[0]+1; // 라이언이 사용해야하는 화살 개수
    let scoreList = new Array(10).fill(0);
    
    dfs(0, n, 0, scoreList); // 10점에서 졌을 때
    
    return answer;
}
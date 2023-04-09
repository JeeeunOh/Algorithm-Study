function solution(A, B) {
    let st = [];

    for(let i=0 ; i<A.length; i++){
        let size = A[i], dir = B[i];
        if(!st.length || dir===1){ // 1. 비어있으면 그대로 집어넣기
            st.push([size, dir]);
        } else { // 2. 물고기 존재하면 & dir===0 이면
            while(st.length){
                let [topSize, topDir] = [st[st.length-1][0], st[st.length-1][1]]; // 가장 위의 물고기 정보
                if(!topDir){ // 2-1. 두 물고기가 만나지 않을 때 ; topDir이 0 일 때
                    st.push([size, dir]);
                    break;
                } else { // 2-2. 두 물고기가 만날 때
                    if(topSize < size){ // 2-2-a. 현재 물고기가 더 크면 존재하는 물고기 잡아먹기.
                        st.pop();
                        if(!st.length){ // 더 잡아먹을 물고기가 없을 떄
                            st.push([size, dir]);
                            break;
                        }
                    } else { // 2-2-b. 현재 물고기가 작으면 그대로 잡아먹히고 끝남.
                        break; 
                    }
                }
            }
        }
    }

    return st.length;
}

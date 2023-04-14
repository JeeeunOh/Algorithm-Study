function solution(people, limit){
	var answer = 0
    people.sort((a,b) => b-a)
    let l = 0, r = people.length-1
    
    while(l<r){
    	let sum = people[l] + people[r]
        answer++
        if(sum>limit){
        	l++
        } else {
        	l++; r--;
        }
    }
    if(l === r) answer++
    return answer
}


// 시작시간 : 18:45
function solution(people, limit) {
  let answer=0;
  people.sort((a, b)=> b-a);
  
  for(let i=0 ;i<people.length; i++){
      if(people[i]===0) continue;
      answer++;
      for(let j=i+1 ; j<people.length ; j++){
          if (people[j]===0) continue;
          if(people[i]+people[j]<=limit){
              people[i]=0;
              people[j]=0;
              break;
          }
      }
  }
  return answer;
}

function solution(people, limit) {
  // 사람 몸무게 수, 무게 제한
  let cnt = 0;
  people.sort((a,b)=>b-a); // 내림차순 정렬
  
  while(people.length!=0){
      let temp = limit;
      cnt++;
      
      people = people.filter((item)=>{
          if(temp>0 && item<=temp){
              temp-=item;
              return false;
          } else {
              return true;
          }
      })
  }
  
  return cnt;
}

// 정확도 100 , 효율성 시간초과 5/5

function solution(people, limit) {
  // 사람 몸무게 수, 무게 제한
  let cnt = 0;
  people.sort((a,b)=>b-a); // 내림차순 정렬
    
    for(let i=0 ; i<people.length; i++){
        if(people[i]!=0){
            cnt++;
            for(let j=i+1 ; j<people.length; j++){
                if(people[j]!=0 && people[i]+people[j]<=limit){
                    people[i] = 0;
                    people[j] = 0 ;
                    break;
                }
            }
            
        }

    }
  
  return cnt;
}

// 정확도 통과 100, 효용성 시간 초과 3/5
function solution(people, limit) {
  // 사람 몸무게 수, 무게 제한
  let cnt = 0;
  people.sort((a,b)=>b-a); // 내림차순 정렬
    
    while(people.length>0){
        let len = people.length;
        cnt++;
        if(len==1) break;
        if(people[0]+people[len-1]<=limit){
            people.pop();
            
        } 
        people.shift()
    }
  
  return cnt;
}

// 굳이 앞에 것을 뺼 필요는 없다.
// 그냥 앞에서부터 하나씩 탐색하면서 뒤에 것을 뺴자.
// 모두 통과
function solution(people, limit) {
  // 사람 몸무게 수, 무게 제한
  let cnt = 0;
  people.sort((a,b)=>b-a); // 내림차순 정렬

    for(let i=0 ; i<people.length; i++){
        cnt++;
        if(people[i]+people[people.length-1] <= limit)
            people.pop();
    }
  
  return cnt;
}
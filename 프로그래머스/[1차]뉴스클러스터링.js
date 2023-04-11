// 정규식을 좀 더 깔끔하게 써보는 풀이
function solution(str1, str2) {
    let map1 = new Map(), map2 = new Map();
    let cnt1 = 0 , cnt2 = 0, same = 0; // 각 원소 개수
    
    for(let i=0 ; i<str1.length-1; i++){
        let key = str1.substring(i, i+2).toUpperCase();
        if(key.match(/[a-zA-Z]{2}/)){
            if(map1.has(key)) map1.set(key, map1.get(key)+1)
            else map1.set(key, 1);
            cnt1++;
        }
    }
    
    for(let i=0 ; i<str2.length-1; i++){
        let key = str2.substring(i, i+2).toUpperCase();
        if(key.match(/[a-zA-Z]{2}/)){
            if(map2.has(key)) map2.set(key, map2.get(key)+1)
            else map2.set(key, 1);
            
            if(map1.get(key)>= map2.get(key)) same++;
            
            cnt2++;
        }
    }
    
    return cnt1+cnt2? Math.floor(65536*same/(cnt1+cnt2-same)): 65536;
}

// 첫 풀이
function solution(str1, str2) {
    var answer = 0;
    var pt = /[a-zA-Z]/;
    let map1 = new Map(), map2 = new Map();
    let cnt1 = 0 , cnt2 = 0, same = 0; // 각 원소 개수
    
    
    for(let i=0 ; i<str1.length-1; i++){
        if(pt.test(str1[i]) && pt.test(str1[i+1])){
            let key = (str1[i]+str1[i+1]).toUpperCase();
            if(map1.has(key)) map1.set(key, map1.get(key)+1)
            else map1.set(key, 1);
            cnt1++;
        }
    }
    
    for(let i=0 ; i<str2.length-1; i++){
        if(pt.test(str2[i]) && pt.test(str2[i+1])){
            let key = (str2[i]+str2[i+1]).toUpperCase();
            if(map2.has(key)) map2.set(key, map2.get(key)+1)
            else map2.set(key, 1);
            
            if(map1.get(key)>= map2.get(key)) same++;
            
            cnt2++;
        }
    }
    
    return cnt1+cnt2? Math.floor(65536*same/(cnt1+cnt2-same)): 65536;
}
// dp로 풀었다. 그리디로 풀어야할 것 같음.... 40퍼

int last=0, MAX=0;

void dp(int cur, int temp, vector<int> &a, vector<int> &b){
    if(last<a[cur]){
        temp++;
        last=b[cur];
        if(MAX<temp) MAX=temp;
        for(int i=cur+1; i<a.size(); i++){
            dp(i, temp, a, b);
        }
    }
}

int solution(vector<int> &a, vector<int> &b) {
    for(int i=0 ; i<a.size(); i++){
        last=0;
        dp(i,0, a, b);
    }

    return MAX;
}

//100퍼 나옴. 구글링함.

int solution(vector<int> &A, vector<int> &B) {
    int answer = 0;
    int previousLineEndIndex = -1;
    
    for(int i=0; i<A.size(); i++) {
        if(A[i] > previousLineEndIndex) {
            answer++;
            previousLineEndIndex = B[i];
        }
    }
    return answer;
}

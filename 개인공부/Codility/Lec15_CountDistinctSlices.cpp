int solution(int M, vector<int> &A) {
    bool chk[M+1];
    int ans = 0, right = 0;
    int n = A.size();
        
    for(int left=0;left<n;left++) {
        // 중복 원소 나올때까지 right 증가시키며 cnt
        while(right < A.size() && !chk[A[right]]) {
            ans += (right-left+1);
            chk[A[right]] = true;
            right++;
                
            if(ans >= 1000000000) {
                return 1000000000;
            }
        }

        chk[A[left]] = false; // left 끝나면 제외시킴

        if(ans >= 1000000000)
            return 1000000000; 
    }

    return ans;
}
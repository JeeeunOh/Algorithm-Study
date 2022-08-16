#include <algorithm>

int solution(vector<int> &A) {
    sort(A.begin(), A.end());
    int res=1;
    
    for(int i=0 ; i<A.size(); i++){
        if(res==A[i]) res++;
        else if (res>A[i]) continue;
        else return res;
    }
}

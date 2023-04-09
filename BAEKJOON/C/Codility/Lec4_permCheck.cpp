#include <algorithm>

int solution(vector<int> &a) {

    sort(a.begin(), a.end());
    if(a[0]!=1) return 0;
    for(int i=1 ; i<a.size(); i++){
        if(a[i]!=(a[i-1]+1)) return 0;
    }
    return 1;
}
#include <vector>

vector<int> solution(vector<int> &a, int k) {
    vector<int> ans(a.size(), 0);
    for(int i=0 ; i<a.size(); i++){
        ans[(i+k)%a.size()]=a[i];
    }
    return ans;
}
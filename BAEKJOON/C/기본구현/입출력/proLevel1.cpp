#include <vector>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 1;
    int cnt=0;
    long long ans[200001];

    for(int i=0 ; i<nums.size(); i++){
        if(ans[nums[i]]!=1) {
            ans[nums[i]]=1;
            cnt++;
        }
    }

    if(cnt>(nums.size())/2) 
        answer=(nums.size())/2;
    else answer=cnt;

    return answer;
}
#include <vector>
using namespace std;

int solution(int N) {
    int ans=0;
    int temp=0;
    vector<int> v;
    while(true){
        if(N==0) {
            break;
        }
        else if(N%2==1) v.push_back(1);
        else if (N%2==0) v.push_back(0);
        N/=2;
    }

    for(int i=v.size()-2 ; i>=0; i--){
        if(v[i]==0) temp++;
        else{
            if(ans<temp) ans=temp;
            temp=0;
        }
    }

    return ans;
}
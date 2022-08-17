#include <vector>

int solution(vector<int> &a) {
    long long sum=0;
    vector<int> left(100001,0);
    vector<int> right(100001,0);

    for(int i=0 ; i<a.size(); i++){
        // cout << left[i] << " " << right[i] << '\n';
        if(a[i]==0) { // 동쪽
            right[i+1]=right[i]+1;
            left[i+1]=left[i];
            // sum+=left[i];
        }
        else { // 서쪽
            left[i+1]=left[i]+1;
            right[i+1]=right[i];
            sum+=right[i];
        }
        if(sum>1000000000) return -1;
    }


    return sum;
}
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    int n,k;
    vector<pair<long long, long long>> v; // 가격, 무게
    long long bag[300001]={0};
    
    cin >> n >> k;
    while(n--){
        int a,b;
        cin >> a >> b;
        v.push_back({b, a});
    }
    for(int i=0 ; i<k ; i++){
        cin >> bag[i];
    }
    sort(v.begin(), v.end()); // 보석 가격 오름차순
    sort(bag, bag+k); // 최대 무게 오름차순

    long long res=0;

    for(int i=v.size()-1 ; i>=0 ; i--){ // 보석가치 높은 것부터 탐색
        long long weight = v[i].second;
        for(int p=0 ; p<k ; p++){
            if(weight<bag[p]){
                res+=v[i].first;
                bag[p]=0;
            }
        }
    }

    cout << res << '\n';
}
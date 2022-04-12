#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n,m,k; // 참가자수, 장르수, 본선진출자수
    vector<pair<double, int>> v; // 점수, 참가자 번호
    cin >> n >> m >> k;

    for(int i=0 ; i<m ; i++){
        for(int j=0 ; j<n ; j++){
            int a; 
            double b;
            cin >> a >> b;
            v.push_back({b, a});
        }
    }

    sort(v.begin(), v.end(), greater<pair<double, int>>());

    double res=0;
    int checkP[101]={0}; // 사람 체크
    int cnt=0;

    for(int i=0 ; i<v.size(); i++){
        if(!checkP[v[i].second]){ // 본선 참가자 아니면
            cnt++;
            checkP[v[i].second]=1;
            res+=v[i].first;
            if(cnt==k) break;
        }
    }
    
    printf("%.1f\n", res);
}
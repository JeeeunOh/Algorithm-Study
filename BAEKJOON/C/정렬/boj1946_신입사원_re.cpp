#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    int t;
    cin >> t;

    while(t--){
        int n;
        cin >> n;
        vector<pair<int, int>> v(n);

        for(int i=0 ; i<n ; i++){
            int a,b;
            cin >> a >> b;
            v[i]={a,b};
        }

        sort(v.begin(), v.end()); // 최소 등수부터

        // for(int i=0 ; i<n ; i++){
        //     cout << v[i].first << " " << v[i].second << '\n';
        // }
        
        int min = v[0].second; // 최소 등수 저장
        int res=0;

        for(int i=1 ; i<n ; i++){
            if(min>v[i].second) min = v[i].second;
            else {
                res++;
            }
        }

        cout << n-res << '\n';
    }
}
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<pair<int, int>> v(n);

    for(int i=0 ; i<n ; i++){
        int a,b;
        cin >> v[i].second >> v[i].first;
    }

    int res=0;

    sort(v.begin(), v.end());

    int end=0;
    
    for(int i=0 ; i<n ; i++){
        // cout << v[i].first << " " << v[i].second << '\n';

        if(end<=v[i].second){
            end=v[i].first;
            res++;
        }
    }

    cout << res << '\n';
}
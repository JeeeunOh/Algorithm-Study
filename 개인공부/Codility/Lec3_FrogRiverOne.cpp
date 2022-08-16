// 정확도 18퍼 

#include <map>

int solution(int x, vector<int> &a) {
    map<int, int> m;

    for(int i=0 ; i<a.size(); i++){
        if(m.find(a[i])==m.end()) m[a[i]]=i;
    }

    if(m.find(x)!=m.end()) return m[x];
    else return -1;
}

// 정확도 27퍼

#include <map>

int solution(int x, vector<int> &a) {
    map<int, int> m;

    for(int i=0 ; i<a.size(); i++){
        if(m.find(a[i])==m.end()) m[a[i]]=i;
    }

    // for(auto iter:m){
    //     cout << iter.first << " " << iter.second << '\n';
    // }

    for(int i=1 ; i<=x; i++){
        if(m.find(i)==m.end()) {
            // cout << i << '\n';
            break;
        }
        if(i==x) return m[x];
    }

    return -1;
}

// 정확도 100퍼

#include <vector>

int solution(int x, vector<int> &a) {
    vector<int> v(100001, 0);
    int sum = x*(x+1)/2;

    for(int i=0 ; i<a.size(); i++){
        if(a[i]>=1 && a[i]<=x && v[a[i]]!=1){
            v[a[i]]=1;
            sum-=a[i];
            // cout << i << " " << sum << '\n';
        }
        if(sum==0) return i;
    }

    return -1;
}
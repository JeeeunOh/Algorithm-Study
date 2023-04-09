#include <map>
#include <vector>

int solution(vector<int> &a) {
    map<int, int> m;

    for(int i=0 ; i<a.size(); i++){
        int temp;
        if(a[i]<0) temp = a[i]*(-1);
        else temp = a[i];

        if(m.find(temp)==m.end()) m.insert({temp, 1});
    }
    
    return m.size();
}
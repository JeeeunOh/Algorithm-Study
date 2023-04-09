#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
vector<string> v;
//정렬순서

bool compare(string a, string b){
    if(a.size()!= b.size()){
        return a.size() < b.size();
    }
    else{
        int numA=0, numB=0;
        for(int i=0 ; i<a.size() ; i++){
            if(a[i]-'0' <=9 && a[i]-'0'>-0) numA+=a[i]-'0';
        }
        for(int i=0 ; i<b.size() ; i++){
            if(b[i]-'0' <=9 && b[i]-'0'>-0) numB+=b[i]-'0';
        }
        if(numA!=numB) return numA < numB;
        else{
            return a<b;
        }
    }
}

int main(){
    int N;
    cin >> N;
    for(int i=0 ; i<N ; i++){
        string s;
        cin >> s;
        v.push_back(s);
    }
    sort(v.begin(), v.end(), compare);
    for(int i=0 ; i<v.size() ; i++){
        cout << v[i] << endl;
    }
    return 0;
}


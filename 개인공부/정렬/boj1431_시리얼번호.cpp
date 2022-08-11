#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(string a, string b){
    if(a.length()!=b.length()) return a.length() < b.length();
    int numA=0, numB=0;
    for(int i=0 ; i<a.length(); i++){
        if(a[i]-'0'>=0 && a[i]-'0'<=9) numA+=a[i]-'0';
        if(b[i]-'0'>=0 && b[i]-'0'<=9) numB+=b[i]-'0';
    }
    if(numA!=numB) return numA < numB;
    return a<b;
}

int main(){
    int n;
    cin >> n;
    vector<string> v(n);

    for(int i=0 ; i<n ; i++){
        cin >> v[i];
    }

    sort(v.begin(), v.end(), compare);

    for(int i=0 ; i<n ; i++){
        cout << v[i] << '\n';
    }
}
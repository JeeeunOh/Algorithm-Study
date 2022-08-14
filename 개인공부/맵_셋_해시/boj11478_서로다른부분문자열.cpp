#include <iostream>
#include <map>
#include <string>
using namespace std;

int main(){
    string s;
    int res=0;
    cin >> s;

    map<string, int> m;

    for(int i=0 ; i<s.length() ; i++){
        for(int j=1; j<=s.length()-i; j++){
            string temp = s.substr(i,j); // i번째부터 j의 len을 가진 str
            if(m.find(temp)==m.end()) {
                m[temp]=1;
                res++;
            }
        }
    }
    cout << res << '\n';
}
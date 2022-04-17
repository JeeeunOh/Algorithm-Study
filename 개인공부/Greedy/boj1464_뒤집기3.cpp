#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(void){
    string str;
    cin >> str;
    string s = str.substr(0,1);

    for(int i=1; i<str.size(); i++){
        if( s[i-1] < str[i]) s = str[i] + s; 
        else s = s + str[i]; 
    }
    reverse(s.begin(), s.end());
    cout << s;
    return 0;
}

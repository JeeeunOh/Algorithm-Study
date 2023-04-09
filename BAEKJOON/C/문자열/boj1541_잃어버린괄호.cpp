#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    cin >> s ;
    
    bool minus=false;

    for(int i=0 ; i<s.length(); i++){
        if(s[i]=='-') minus=true;
        if(s[i]=='+' && minus) s[i]='-';
    }

    char last='+';
    int res=0;
    int temp=0;

    for(int i=0 ; i<s.length(); i++){
        if(s[i]=='-' || s[i]=='+') {
            if(last=='+') {
                res+=temp;
            }
            else {
                res-=temp;
            }
            last=s[i];
            temp=0;
        } else {
            int t = temp*10 + (s[i]-'0');
            temp = t;
        }
    }

    if(last=='+') {
        res+=temp;  
    } else {
        res-=temp;
    }

    cout << res << '\n';
}
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

    // cout << s << '\n';

    for(int i=0 ; i<s.length(); i++){
        if(s[i]=='-' || s[i]=='+') {
            if(last=='+') {
                res+=temp;  
                // cout << i << " " << res << " + " << temp<< '\n';
            }
            else {
                res-=temp;
                // cout << i << " " << res << " - " << temp<< '\n';
            }
            last=s[i];
            temp=0;
            // cout << res << '\n';
        } else {
            int t = temp*10 + (s[i]-'0');
            temp = t;
            // cout << i << " : " << t << " " << temp << '\n';
        }
    }

    if(last=='+') {
        res+=temp;  
        // cout << i << " " << res << " + " << temp<< '\n';
    } else {
        res-=temp;
        // cout << i << " " << res << " - " << temp<< '\n';
    }

    cout << res << '\n';
}
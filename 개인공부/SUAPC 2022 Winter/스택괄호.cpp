#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main(){
    stack<char> stack;
    int dp[100000];
    string s;
    cin >> s;

    int resA=0; // (
    int resB=0; // )

    if(s[0]=='(')  dp[0]=1; 
    if(s[0]==')')  dp[0]=-1; 

    for(int i=0 ; i<s.length(); i++){
        if(s[i]=='('){
            stack.push('(');
            dp[i]=dp[i-1]++;
            resA++;
        } 
        if(s[i]==')'){
            stack.push(')');
            dp[i]=dp[i-1]--;
            resB++;
        }
    }

    char target;

    if(resA>resB) {
        target='(';

        while(!stack.empty()){
            if(s.top()==target){
                
            }

        }

        cout << resA;
    }
    else {
        target=')';

        cout << resB;
    }
}
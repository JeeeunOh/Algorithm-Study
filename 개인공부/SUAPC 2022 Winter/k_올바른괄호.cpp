#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main(){
    vector<char> v;
    int dp[100000];
    string s;

    cin >> s;
 
    if(s[0]=='(')  dp[0]=1; 
    if(s[0]==')')  dp[0]=-1; 

    for(int i=1 ; i<s.length(); i++){
        if(s[i]=='(') dp[i]=dp[i-1]+1; 
        if(s[i]==')') dp[i]=dp[i-1]-1; 
    }

    char target;

    if(dp[s.length()-1]>0) target='(';
    else target=')';

    int res=0;

    //dpB > dpA 이면 안됨.
    
    for(int i=0 ; i<s.length(); i++){
        if(s[i]==target){ // 타겟 문자열을 뺐을 때
            bool flag=true; // 해당 문자열 뺀 게 잘한거다.
            for(int j=0 ; j<s.length(); j++){
                if(i==j) continue; // 자기자신 탐색했으면 패스
                if(target=='('){ // (를 뺐을 때,
                    if(j<i && dp[j]<0) flag=false;
                    else if( j>i && dp[j]-1<0) flag=false; 
                } else { // )를 뺐을 때,
                    if(j<i && dp[j]<0) flag=false; 
                    else if(j>i && dp[j]+1<0) flag=false;
                }
            }
            if(flag) res++; 
        }
    }
    cout << res;
}
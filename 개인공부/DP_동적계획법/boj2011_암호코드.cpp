#include <iostream>
#include <vector>
using namespace std;

int main(){
    string s;
    vector<int> v;
    long long dp[5001]={0};
    
    cin >> s;
    
    for(int i=0 ; i<s.length(); i++){
        v.push_back(s[i]-'0');
    }

    if(v[0]==0){ // 암호가 잘못된 경우
        cout << "0" << endl;
        return 0;
    }
    int pre, cur, temp;
    for(int i=0 ; i<v.size(); i++){
        cur = v[i];
        if(cur>=1 && cur<=9) dp[i]+=dp[i-1]; // 1자리 암호일 때

        if(i>=1) { // 2자리 암호가 가능한지 체크
            pre = v[i-1]; 
            temp=pre*10 + cur;
            if( 10<=temp && temp<=26 && i==1) dp[i]++;
            else if ( 10<=temp && temp<=26 && i>=2 ) dp[i]+=dp[i-2];
        }

        dp[i]%=1000000;

    }

    cout << dp[s.length()-1]%1000000 << endl;
}
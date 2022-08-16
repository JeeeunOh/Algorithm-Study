#include <iostream>
#include <vector>
using namespace std;
#define MAX 1000001

// 나의 고민 )
// 입력 받은 n - 탐색한 소수 = 다른 소수인걸 어떻게 알지...?

int main(){
    vector<int> prime(MAX + 1, 0);
    vector<int> v;
    //0이면 소수, 1이면 소수가 아님

    for(int i=2 ; i<MAX; i++){
        if(prime[i]!=1){
            int mul=2;
            v.push_back(i); // i는 소수이다.
            while(true){
                if(i*mul<MAX) prime[i*mul]=1;
                else break;
                mul++;
            }
        }
    }

    int n,a,b;
    
    while(true){
        bool flag=0;
        cin >> n;
        if(n==0) break;
        
        for(int i=1; i<v.size(); i++){
            for(int j=v.size()-1 ; j>=i ; j--){
                if(n==v[i]+v[j]){
                    a=v[i];b=v[j];
                    flag=1;
                }
                // cout << i << " : " << j << '\n';
                if(flag) break;
            }
            if(flag) break;
        }

        if(flag) cout << n << " = " << a << " + " << b << '\n';
        else cout << "Goldbach's conjecture is wrong." << '\n';
    }
}
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n;
    int plus[51];
    int minus[51];
    int plusN=0, minusN=0;
    cin >> n;

    for(int i=0 ; i<n ; i++){
        int a;
        cin >> a; 
        if(a>0){
            plus[plusN] = a;
            plusN++;
        } else if (a<=0){
            minus[minusN] = a;
            minusN++;
        }
    }

    sort(plus, plus+plusN, greater<int>()); // 내림차순 정렬
    sort(minus, minus+minusN); // 음수는 오름차순 정렬

    int res=0;

    if(plusN%2==0){ // 짝수면
        for(int i=0 ; i<=plusN-2 ; i+=2){
            if(plus[i+1]!=1) res+=plus[i]*plus[i+1];
            else{
                res+=plus[i];
                res+=plus[i+1];
            }
        }
    } else {
        for(int i=0 ; i<=plusN-3 ; i+=2){
            if(plus[i+1]!=1) res+=plus[i]*plus[i+1];
            else{
                res+=plus[i];
                res+=plus[i+1];
            }
        }
        res+=plus[plusN-1];
    }

    if(minusN%2==0){ // 짝수면
        for(int i=0 ; i<=minusN-2 ; i+=2){
            res+=minus[i]*minus[i+1];
        }
    } else {
        for(int i=0 ; i<=minusN-3 ; i+=2){
            res+=minus[i]*minus[i+1];
        }
        res+=minus[minusN-1];
    }

    cout << res << '\n';
}
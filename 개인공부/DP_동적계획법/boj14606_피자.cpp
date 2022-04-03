#include <iostream>
using namespace std;

int res=0;

void solution(int cur){
    int next1, next2;

    next1=cur/2;
    if(cur%2==0){ // 짝수일 때
        next2=cur/2;
    } else{ // 홀수일 때
        next2=cur/2+1;
    }

    res+=next1*next2;
    if(next1!=1) solution(next1);
    if(next2!=1) solution(next2);
}

int main(){
    int n;
    cin >> n;
    if(n==1) {
        cout << "0" << '\n';
        return 0;
    } else {
        solution(n);
    }
    cout << res << '\n';
}
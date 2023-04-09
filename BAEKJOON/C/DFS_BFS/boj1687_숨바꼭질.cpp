#include <iostream>
#include <algorithm>
using namespace std;

int n,k,cnt=100000;

void sol(int temp, int num){
    if(temp==k){
        cnt = min(cnt, num);
    } else if (temp<k){
        sol(temp+1, num+1);
        sol(temp-1, num+1);
        sol(temp*2, num+1);
    }
    return;
}

int main(){
    cin >> n >> k;
    sol(n,0);
    cout << cnt << '\n';
}
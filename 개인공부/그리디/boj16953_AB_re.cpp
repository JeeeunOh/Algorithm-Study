#include <iostream>
#include <algorithm>
using namespace std;

int cnt=1000000000;
int a,b;

void sol(long long temp, int num){

    if(temp>b) return;

    if(temp==b) {
        cnt = min(cnt, num);
    } else if(temp<b){
        num++;
        sol(temp*2, num);
        sol(temp*10+1, num);
    }

}

int main(){
    cin >> a >> b;
    
    sol(a, 1);

    if(cnt == 1000000000){
        cout << -1 << '\n';
        return 0;
    } else {
        cout << cnt+1 << '\n';
        return 0;
    }
}
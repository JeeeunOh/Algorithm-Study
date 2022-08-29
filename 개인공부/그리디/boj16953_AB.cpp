#include <iostream>
#include <algorithm>
using namespace std;

int cnt=1000000000;
int a,b;

void mul2(long long temp, int num);
void plus1(long long temp, int num);

void mul2(long long temp, int num){
    temp*=2;
    num++;

    if(temp==b) {
        cnt = min(cnt, num);
    } else if(temp<b){
        mul2(temp, num);
        plus1(temp, num);
    } 
    return;
}

void plus1(long long temp, int num){
    temp*=10;
    temp++;
    num++;

   if(temp==b) {
        cnt = min(cnt, num);
    } else if(temp<b){
        mul2(temp, num);
        plus1(temp, num);
    } 
    return;
}

int main(){
    cin >> a >> b;
    
    mul2(a, 0);
    plus1(b, 0);

    if(cnt == 1000000000){
        cout << -1 << '\n';
        return 0;
    } else {
        cout << cnt+1 << '\n';
        return 0;
    }
}
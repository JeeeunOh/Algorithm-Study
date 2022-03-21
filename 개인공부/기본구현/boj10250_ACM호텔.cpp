#include <iostream>
using namespace std;

int main(){
    int x;
    cin >> x;

    int idx=1;

    while(x>idx){ // 몇번째 줄에 있는지 판단
        x-=idx;
        idx++;
    }

    int mo, ja, sum = idx+1;

    if(idx%2!=0){ // 홀수줄
        cout << idx+1-x << "/" << x << '\n';
    }else{ // 짝수줄
        cout << x << "/" << idx+1-x << '\n';
    }
}
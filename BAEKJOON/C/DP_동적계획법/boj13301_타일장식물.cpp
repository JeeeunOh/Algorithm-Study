#include <iostream>
using namespace std;

int main(){
    long long n;
    cin >> n;

    long long arr[81]={0};
    arr[1] = 4;
    arr[2] = 6;

    if(n<=2){
        cout << arr[n] << '\n';
        return 0;
    }

    long long w = 1, h=2;

    for(int i=3 ; i<=n ; i++){
        long long d;
        if(i%2!=0){ // 홀수면 세로
            d=h;
            w+=d;
        } else {
            d=w;
            h+=d;
        }
        arr[i]=w*2+h*2;
    }

    cout << arr[n] << '\n';
    return 0;
}
#include <iostream>
using namespace std;

int main(){
    int n;
    int arr[10]={0};

    cin >> n;

    while(n){
        arr[n%10]++;
        n/=10;
    }

    int temp = arr[6]+arr[9];
    int res = temp%2;
    temp/=2;
    arr[6]=temp; arr[9]=temp+res;

    int max=0;

    for(int i=0 ; i<=9 ; i++){
        if(arr[i]>max) max=arr[i];
    }

    cout << max << '\n';
}
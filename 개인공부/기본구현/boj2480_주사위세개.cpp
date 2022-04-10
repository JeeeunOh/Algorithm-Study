#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int arr[3];
    int res=0;
    
    cin >> arr[0] >> arr[1] >> arr[2];
    sort(arr, arr+3);

    if(arr[0]==arr[1] && arr[1]==arr[2]){
        res = 10000+arr[0]*1000;
    } else if(arr[0]==arr[1]){
        res=1000+arr[0]*100;
    } else if(arr[1]==arr[2]){
        res=1000+arr[1]*100;
    } else{
        res=100*arr[2];
    }
    
    cout << res << '\n';
}
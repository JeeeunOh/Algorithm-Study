#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n=9;
    int arr[20];

    for(int i=0 ; i<n ; i++){
        cin >> arr[i];
    }

    sort(arr, arr+n);

    cout << arr[n/2] << '\n';
}
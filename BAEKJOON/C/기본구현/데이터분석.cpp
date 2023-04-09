#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n=10;
    int arr[20];
    int arr1[20];

    for(int i=0 ; i<n ; i++){
        cin >> arr[i];
    }
     for(int i=0 ; i<n ; i++){
        cin >> arr1[i];
    }
    for(int i=0 ; i<n ; i++){
        cout << arr[i]-arr1[i] << " ";
    }

    cout <<'\n';
}
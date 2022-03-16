#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int arr[1001];
    int n, res=0;
    cin >> n;

    for(int i=0 ; i<n ; i++) cin >> arr[i]; 

    sort(arr, arr+n);

    for(int i=0; i<n ; i++){
        res+=arr[i]*(n-i);
    }

    cout << res << endl;

}
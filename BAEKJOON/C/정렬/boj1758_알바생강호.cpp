#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    long long arr[100001];

    for(int i=0 ; i<n ; i++){
        cin >> arr[i];
    }

    sort(arr, arr+n, greater<>());

    long long res=0;

    for(int i=0; i<n ; i++){
        long long temp = arr[i]-i;
        if(temp>0) res+=temp;
    }

    cout << res << '\n';
}
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n,k;
    long long arr[100005];
    cin >> n >> k;
    arr[0]=0;

    for(int i=1 ; i<=n ; i++){
        cin >> arr[i];
        arr[i]+=arr[i-1];
    }

    int res=-1e9;
    for(int i=k; i<=n ; i++){
        if(res<arr[i]-arr[i-k]) {
            res = arr[i]-arr[i-k];
        }
    }
    
    cout << res << '\n';
}
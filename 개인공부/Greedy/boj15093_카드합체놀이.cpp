#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    long long arr[1001];
    int n,m;

    cin >> n >> m;

    for(int i=0 ; i<n ; i++) cin >> arr[i]; 

    while(m--){
        sort(arr, arr+n);
        long long temp=arr[0]+arr[1];
        arr[0]=temp;
        arr[1]=temp;
    }

    long long res=0;
    
    for(int i=0 ; i<n ; i++) res+=arr[i]; 

    cout << res << endl;
}
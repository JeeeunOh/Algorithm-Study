#include <iostream>
using namespace std;

int main(){
    int n;
    int arr[101];
    cin >> n ;

    for(int i=0 ; i<n ; i++){
        cin >> arr[i];
    }

    int res=0;
    for(int i=n-2 ; i>=0 ; i--){
        if(arr[i]>=arr[i+1]){
            int cnt = arr[i]-arr[i+1];
            cnt++;
            arr[i]-=cnt;
            res+=cnt;
        }
    }

    cout << res << '\n';
}
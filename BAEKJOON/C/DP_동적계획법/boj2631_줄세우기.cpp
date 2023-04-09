#include <iostream>
using namespace std;

int main(){
    int n;
    int arr[200];
    cin >> n;
    for(int i=0 ; i<n ; i++){
        cin >> arr[i];
    }

    int d[200];
    int Max=0;

    for(int i=0 ; i<n ; i++){
        d[i]=1;
        for(int j=0 ; j<i ; j++){
            if(arr[i]>arr[j] && d[i]<d[j]+1){
                d[i]++;
            }
        }
        if(Max<d[i]) Max=d[i];
    }

    cout << n-Max << '\n';
    return 0;

}
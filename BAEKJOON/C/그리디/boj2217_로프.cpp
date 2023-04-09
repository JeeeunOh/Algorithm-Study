#include <iostream>
#include <algorithm>

using namespace std;

int N;
int arr[10001];

int main(){
    cin >> N;
    for(int i=0 ; i<N ; i++) cin >> arr[i]; 

    sort(arr, arr+N, greater<int>());

    long long max=0;

    for(int i=0 ; i<N; i++){
        if(arr[i]*(i+1)>max) max=arr[i]*(i+1);
    }

    cout << max << endl;
}
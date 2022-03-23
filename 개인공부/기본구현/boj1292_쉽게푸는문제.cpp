#include <iostream>
using namespace std;

int main(){
    int a,b;
    int max=1, cur=1;
    int arr[1001]={0};

    cin >> a >> b;

    for(int i=1 ; i<=b ; i++){
        arr[i]+=arr[i-1]+max;
        cur++;
        if(max<cur){
            max++;
            cur=1;
        }
    }
    cout << arr[b] - arr[a-1] << '\n';
}
#include <iostream>
using namespace std;

int main(){
    int n,k;
    int arr[10];
    cin >> n >> k;
    for(int i=0 ; i<n ; i++) cin >> arr[i];

    int idx=n-1; // 주어진 동전 가치 최대값부터 역탐색하기
    int cnt=0; // 필요한 동전갯수
    while(k>0){
        if(k>=arr[idx]){
            int temp=k/arr[idx];
            cnt+=temp;
            k-=arr[idx]*temp;
        }
        idx--;
    }
    cout << cnt << endl;
}
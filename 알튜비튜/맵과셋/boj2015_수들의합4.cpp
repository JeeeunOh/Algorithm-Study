#include <iostream>
#include <map>
using namespace std;

map<int, long long> m;

int main(){
    long long n, k;

    cin >> n >> k;

    long long arr[200002];
    arr[0]=0;
    for(int i=1 ; i<=n ; i++){
        cin >> arr[i];
        arr[i]+=arr[i-1]; // arr[i]까지의 부분합 다 구해놓기
    }

    long long cnt=0;
    for(int i=1 ; i<=n ; i++){
        if(arr[i]==k) cnt++;

        cnt+=m[arr[i]-k];
        m[arr[i]]++;
    }

    cout << cnt << endl;
}
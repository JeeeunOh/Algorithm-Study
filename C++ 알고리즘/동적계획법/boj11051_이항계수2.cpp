#include <iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);cout.tie(NULL);

    int n,k;
    cin >> n >> k;
    if(k==0){
        cout << 1 << "\n";
        return 0;
    }
    long long res=1;
    for(int i=n ; i>n-k; i--) res*=i;
    for(int i=1 ; i<=k ; i++) res/=i;
    res%=10007;
    cout << res << "\n";
}
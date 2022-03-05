#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n,k;
    int cnt=0;
    cin >> n >> k;
    for(int i=1 ; i<=n; i++){
        if (n%i==0) cnt++;
        if (cnt==k) {
            cout << i << endl;
            return 0;
        }
    }

    cout << 0 << endl;

}
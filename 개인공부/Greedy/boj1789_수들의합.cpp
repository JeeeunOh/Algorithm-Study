#include <iostream>
using namespace std;

int main(){
    long long n;
    cin >> n;
    long long cnt=0;
    long long cur=1;

    while(n){
        if(cur<=n){
            n-=cur;
            cnt++;
        } else{ //
            cur++;
            break;
        }
        cur++;
    }

    cout << cnt << endl;
}
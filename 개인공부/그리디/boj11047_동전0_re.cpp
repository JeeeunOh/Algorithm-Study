#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n,k;
    cin >> n >> k;
    vector<int> v(n);

    for(int i=n-1 ; i>=0 ; i--) cin >> v[i];

    int res=0;

    for(int i=0 ; i<n ; i++){
        if(k>=v[i]){
            res+=k/v[i];
            k-=v[i]*(k/v[i]);
        } 
        if(k==0) break;
    }

    cout << res << '\n';
}
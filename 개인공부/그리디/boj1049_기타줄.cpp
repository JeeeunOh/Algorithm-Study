#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n,m;
    int big[50];
    int small[50];

    cin >> n >> m;

    for(int i=0 ; i<m ; i++) {
        int a,b;
        cin >> big[i] >> small[i];
    }

    sort(big, big+m);
    sort(small, small+m);

    int sum=0;
    int a=n/6, b=n%6; // 몫, 나머지

    if(big[0]<small[0]*6){
        sum+=a*big[0];
    } else sum+=a*small[0]*6;

    if(big[0]<small[0]*b){
        sum+=big[0];
    } else{
        sum+=b*small[0];
    }

    cout << sum << '\n';
}
#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<long long> dis(n);
    vector<long long> price(n);

    long long res=0;

    for(int i=0 ; i<n-1; i++){
        cin >> dis[i];
    }
    for(int i=0 ; i<n; i++){
        cin >> price[i];
    }
    long long min=1000000000;
    for(int i=0 ; i<n-1 ; i++){
        if(min>price[i]) min = price[i];
        price[i]=min;
        res+=price[i]*dis[i];
    }

    cout << res << '\n';

}
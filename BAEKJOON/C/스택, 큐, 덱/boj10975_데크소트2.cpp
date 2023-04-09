#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    vector<int> a;
    int n, cnt=0;

    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;

    for(int i=0 ; i<n ; i++) {
        int input;
        cin >> input;
        a.push_back(input);
    }
    if(next_permutation(a.begin(), a.end())){
        for(int i=0 ; i<n ; i++){
            cout << a[i] << " ";
        }
    } else cout << -1;

}
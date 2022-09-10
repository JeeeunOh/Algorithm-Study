#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    string a,b;
    vector<vector<int>> v(1001, vector<int> (1001, 0));

    cin >> a >> b;

    for(int i=1 ; i<=a.length(); i++){
        for(int j=1 ; j<=b.length(); j++){
            if(a[i-1]==b[j-1]){
                v[i][j] = v[i-1][j-1]+1;
            } else v[i][j] = max(v[i-1][j], v[i][j-1]);
        }
    }

    cout << v[a.length()][b.length()] << '\n';

}
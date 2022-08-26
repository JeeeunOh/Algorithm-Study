#include <iostream>
#include <vector>
using namespace std;
int n,m;

void change(vector<string> &a, int x, int y){
    for(int i=x; i<x+3; i++){
        for(int j=y; j<y+3; j++){
            if(a[i][j]=='0') a[i][j]='1';
            else a[i][j]='0';
        }
    }
}

bool isSame(vector<string> &a, vector<string> &b){
    bool flag=true;

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<m ; j++){
            if(a[i][j]!=b[i][j]) {
                flag=false;
                break;
            }
        }
    }

    return flag;
}

int main(){
    cin >> n >> m;
    vector<string> a(n);
    vector<string> b(n);

    for(int i=0 ; i<n; i++) cin >> a[i];
    for(int i=0 ; i<n; i++) cin >> b[i]; 

    int cnt=0;

    for(int i=0 ; i<=n-3; i++){
        for(int j=0 ; j<=m-3; j++){
            if(a[i][j]!=b[i][j]) {
                change(a, i, j);
                cnt++;
            } 
        }
    }
    
    bool flag=isSame(a, b);

    if(flag) cout << cnt << '\n';
    else cout << -1 << '\n';
}
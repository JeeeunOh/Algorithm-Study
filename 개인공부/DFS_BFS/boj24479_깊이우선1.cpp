#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n,m.r;
    cin >> n >> m >> r;
    
    int arr[100001][100001];

    for(int i=0 ; i<m ; i++){
        int a,b;
        cin >> a >> b;
        arr[a][b]=1;
        arr[b][a]=1;
    }
}
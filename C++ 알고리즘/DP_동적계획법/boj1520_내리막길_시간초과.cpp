#include <iostream>
#include <algorithm>
using namespace std;

int M,N;
int arr[500][500];
int cnt=0;

void sol(int x, int y){
    if(x==M-1 && y==N-1) {
        cnt++;
        return;
    }

    if(x+1 < M && arr[x+1][y]<arr[x][y]) sol(x+1, y);
    if(y+1 < N && arr[x][y+1]<arr[x][y]) sol(x, y+1);
    if(x-1 < M && arr[x-1][y]<arr[x][y]) sol(x-1, y);
    if(y-1 < N && arr[x][y-1]<arr[x][y]) sol(x, y-1);

    return;
}



int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> M >> N;
    for(int i=0 ; i<M ; i++)
        for(int j=0 ; j<N ; j++)
            cin >> arr[i][j];

    sol(0,0);

    cout << cnt << "\n";
}
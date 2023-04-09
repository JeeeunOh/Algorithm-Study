#include <iostream>
using namespace std;

int N;
int arr[100][100];
int cnt=0;

void sol(int x, int y){
    if(x==N-1 && y==N-1){ // 마지막 지점에 도착
        cnt++;
        return;
    }
    if(x>=N || y>=N) return; // 범위 벗어남

    sol(x+arr[x][y], y);
    sol(x, y+arr[x][y]);
}

int main(){
    cin >> N;

    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<N ; j++){
            cin >> arr[i][j];
        }
    }
    
    sol(0,0);
    cout << cnt << endl;
}
#include <iostream>
#include <queue>
using namespace std;

queue<pair<pair<int, int>, int>> q; // x좌표, y좌표, 남은 벽 갯수

// 0은 빈칸, 1은 벽, 2는 바이러스

int main(){
    int N,M;
    cin >> N >> M;
    int arr[8][8];

    for(int i=0 ; i<N; i++){
        for(int j=0 ; j<M; j++){
            cin >> arr[i][j];
        }
    }

}
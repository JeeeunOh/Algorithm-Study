#include <iostream>

using namespace std;

int map[50][50];
int visited[50][50];
int N, M;

//위 오 아 왼
int dr[4] = {-1,0,1,0};
int dc[4] = {0,1,0,-1};

void dfs(int r, int c, int d, int sum){ //2번

//    1. 현재 위치를 청소한다.
//    2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
//    a.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//    b.왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
//    c.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//    d.네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.


    for(int i = 0; i<4; i++){       //왼쪽부터 반시계방향

        int nd = (d+3-i)%4;
        int nr = r + dr[nd];
        int nc = c + dc[nd];

        if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]==1) {  //범위 넘어가거나 벽이면 다음 방향
            continue;
        }

        //a.  아직 청소하지 않은 공간이 존재한다면
        if(visited[nr][nc] == 0 && map[nr][nc] == 0){
            visited[nr][nc] = 1; //현재 위치 청소
            dfs(nr, nc, nd, sum+1);
        }

    }


    int backIdx = d+2<4 ? d+2 : d-2;
    int backr = r + dr[backIdx];
    int backc = c + dc[backIdx];
    if(0<=backr && backr<=N && 0<=backc && backc<=M){
        if(map[backr][backc]==0){   //뒤쪽 방햑 벽 아니어서 후진할 수 있을 때
            dfs(backr, backc, d, sum);  //한칸 후진
        }
        else{   //뒤쪽 방향 벽이라 후진 못할 때
            cout << sum <<endl;
            exit(0);
        }
    }

}



int main(){

    int r, c, d;
    cin >> N >> M;
    cin >> r >> c >> d;

    for(int i = 0; i<N; i++){
        for(int j = 0; j<M; j++){
            cin >>map[i][j];
            visited[i][j] = 0;
        }
    }

    visited[r][c] = 1;
    dfs(r,c,d,1);

    return 0;
}
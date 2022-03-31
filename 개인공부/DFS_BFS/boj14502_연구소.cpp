#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

const int MAX = 8;

typedef struct{
    int y, x;
}Dir;

Dir moveDir[4] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };


int N, M;
int lab[MAX][MAX];
int temp[MAX][MAX];
int result;

void BFS(void){
    int afterSpread[MAX][MAX];
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            afterSpread[i][j] = temp[i][j];
            
    queue<pair<int, int>> q; //y, x
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            if (afterSpread[i][j] == 2) //바이러스라면
                q.push(make_pair(i, j)); //큐에 넣는다 
                
    while (!q.empty()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        
        for (int i = 0; i < 4; i++){
            int nextY = y + moveDir[i].y;
            int nextX = x + moveDir[i].x;
            
            if(0 <= nextY && nextY < N && 0 <= nextX && nextX < M) //범위 내
                if (afterSpread[nextY][nextX] == 0){
                    afterSpread[nextY][nextX] = 2; //바이러스 감염
                    q.push(make_pair(nextY, nextX));
                }
            }
        }

        int empty = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (afterSpread[i][j] == 0)
                    empty++;
                    
        result = max(result, empty);
}

 

void makeWall(int cnt){
    if (cnt == 3) {//벽을 세개 만들었으므로
        BFS();
        return;
    }
    for(int i=0; i<N; i++)
        for(int j=0; j<M; j++)
            if (temp[i][j] == 0){
                temp[i][j] = 1; //마찬가지로 해당칸에 새우고
                makeWall(cnt + 1);
                temp[i][j] = 0; //다시 허문다
            }
}

int main(void){
    cin >> N >> M;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            cin >> lab[i][j];

    for(int i=0; i<N; i++)
        for(int j=0; j<M; j++)
            if (lab[i][j] == 0) { //빈칸 발견 시 연구실 상태를 복사
                for (int k = 0; k < N; k++)
                    for (int l = 0; l < M; l++)
                        temp[k][l] = lab[k][l];
                temp[i][j] = 1; //해당 칸에 벽을 세운다
                makeWall(1); //벽을 세운 상태이므로 cnt = 1
                temp[i][j] = 0; //다시 허문다
            }

    cout << result << endl;
    return 0;

}
// https://yabmoons.tistory.com/48
#include<iostream>
#include<queue>
#define endl "\n"
#define MAX 200
using namespace std;
 
int W, H, K;
int MAP[MAX][MAX];
bool Visit[MAX][MAX][31];
// (x,y) 지점에 능력을 a번 사용해서 왔다.
 
int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };
int hdx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
int hdy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
 
void Solve(){
    cin >> K; // 원숭이 동작수 최솟값
    cin >> W >> H; // 격자판 크기
    for (int i = 0; i < H; i++)
        for (int j = 0; j < W; j++)
            cin >> MAP[i][j];

    // [ (x,y), (이동횟수, 능력사용횟수) ] 
    queue<pair<pair<int, int>, pair<int, int>>> Q;
    Q.push(make_pair(make_pair(0, 0), make_pair(0, 0)));
    Visit[0][0][0] = true;
 
    while (Q.empty() == 0){
        int x = Q.front().first.first;
        int y = Q.front().first.second;
        int Cnt = Q.front().second.first;
        int Ability = Q.front().second.second;
        Q.pop();

        // 끝점 도달하면 출력
        if (x == H - 1 && y == W - 1){
            cout << Cnt << endl;
            return;
        }
        
        // 말처럼 이동할 수 있는 횟수가 남아있다면
        if (Ability < K) {
            for (int i = 0; i < 8; i++) {
                int nx = x + hdx[i];
                int ny = y + hdy[i];
                if (nx >= 0 && ny >= 0 && nx < H && ny < W) { // 탐색 좌표가 지정 범위 벗어나지 않았으면서
                    if (MAP[nx][ny] == 0 && Visit[nx][ny][Ability + 1] == false) { // 해당 자리에 장애물 없고 방문한 적이 없으면
                        Visit[nx][ny][Ability + 1] = true; // 방문한 적 있게 바꿔주고
                        Q.push(make_pair(make_pair(nx, ny), make_pair(Cnt + 1, Ability + 1))); // 탐색하라고 큐에 넣어줌.
                    }
                }
            }
        }
        
        // 원숭이처럼 이동 그 이후는 위와 같음
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                if (MAP[nx][ny] == 0 && Visit[nx][ny][Ability] == false) {
                    Visit[nx][ny][Ability] = true;
                    Q.push(make_pair(make_pair(nx, ny), make_pair(Cnt + 1, Ability)));
                }
            }
        }
    }

    // while문에서 return 되지 않았으면 여기서 -1 출력
    cout << -1 << endl;
}
 
int main(void)
{
 
    Solve();
 
    return 0;
}
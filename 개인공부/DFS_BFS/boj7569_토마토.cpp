#include <iostream>
#include <queue>
using namespace std;

typedef struct {
        int x, y, z;
        int cnt;
} types;
queue<types> bfs;

int M, N, H; //가로 세로 높이
int box[101][101][101];
bool visited[101][101][101];
int dx[6] = {1, -1, 0, 0, 0, 0};
int dy[6] = {0, 0, 1, -1, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};


int main(void) {
    int cnt = 0;
    cin >> M >> N >> H;
    for (int k = 0; k < H; k++)
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                cin >> box[i][j][k];
                if (box[i][j][k] == 1) {
                    bfs.push({i, j, k, 0});
                    visited[i][j][k] = true;
                }
                else if (box[i][j][k] == -1)
                    visited[i][j][k] = true;
                }
        if (bfs.empty()) {
                printf("-1");
                return 0;
        }

        while (!bfs.empty()) {
                auto a = bfs.front();
                bfs.pop();
                cnt = max(cnt, a.cnt);

                for (int i = 0; i < 6; i++) {
                    int nx = a.x + dx[i];
                    int ny = a.y + dy[i];
                    int nz = a.z + dz[i];

                    if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H && !visited[nx][ny][nz]) {
                        bfs.push({nx, ny, nz, a.cnt + 1});
                        visited[nx][ny][nz] = true;
                    }
                }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                for(int k = 0; k < H; k++) 
                    if (!visited[i][j][k]) {
                        printf("-1");
                        return 0;
                    }
        cout << cnt << '\n';
        return 0;
                        
}
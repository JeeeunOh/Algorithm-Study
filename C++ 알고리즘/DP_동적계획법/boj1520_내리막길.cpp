#include <iostream>
using namespace std;
int arr[500][500], dp[500][500];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int R, C;

int go(int x, int y) {
    int &ret = dp[y][x];
    if (ret != -1) return ret;
    if (x == C - 1 && y == R - 1) return ret = 1;

    ret = 0;
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < C && ny < R && arr[ny][nx] < arr[y][x])
            ret += go(nx, ny);
    }
    return ret;
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> R >> C;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            dp[i][j]=-1;
            cin >> arr[i][j];
        }
    }
    cout << go(0, 0);
}
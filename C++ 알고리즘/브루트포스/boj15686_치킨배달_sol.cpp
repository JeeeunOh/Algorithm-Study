#include<iostream>
#include<algorithm>
using namespace std;

struct Dot {
    int x, y;
};
// 치킨, 집,
Dot D[14], P[101], A[14];

int r, N, M;
int ans = 2e9, a, b;

void go(int cur, int idx) {
    if (cur == M) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            int dist = 2e9;
            for (int j = 0; j < cur; j++) {
                dist = min(dist, abs(P[i].x - A[j].x) + abs(P[i].y - A[j].y));
            }
            sum += dist;
        }
        ans = min(ans, sum);
        return;
    }
    for (int i = idx; i < a; i++) {
        A[cur].x = D[i].x;
        A[cur].y = D[i].y;
        go(cur + 1, i + 1);
    }
}
int main() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> r; // 0, 1: 집, 2: 치킨
            if (r == 2) D[a].x = i, D[a++].y = j; // 치킨
            if (r == 1) P[b].x = i, P[b++].y = j; // 집
        }
    }
    go(0, 0); printf("%d", ans);
}
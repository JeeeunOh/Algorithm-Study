#include <stdio.h>
#include <queue>
using namespace std;

/*
4 6
101111
101010
101011
111011
*/

int N, M;
int check[101][101]; // 시작점으로부터의 거리 표시
int visit[101][101]; // 방문표시
char map[101][101]; // 미로
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

void BFS(int x, int y) 
{
	visit[x][y] = 1; // 방문표시

	queue<pair<int, int> > q; // 큐 생성
	q.push(make_pair(x, y)); // 시작점 넣기

	while (!q.empty()) // 큐에 데이터가 없을때까지
	{
		int x = q.front().first;
		int y = q.front().second;

		q.pop(); // 큐 맨 앞 데이터 제거

		for (int i = 0; i < 4; i++) 
		{
			int next_x = x + dx[i];
			int next_y = y + dy[i];

			if (0 <= next_x && next_x < N && 0 <= next_y && next_y < M) // 미로의 범위
			{
				// 길이 존재하고 이전에 방문했던적이 없는 경우
				if (map[next_x][next_y] == '1' && visit[next_x][next_y] == 0)
				{
					check[next_x][next_y] = check[x][y] + 1;
					visit[next_x][next_y] = 1;
					q.push(make_pair(next_x, next_y)); // 큐에 데이터 밀어넣기
				}

			}

		}
	}

}

int main(void) 
{
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++)
	{
		scanf("%s", map[i]);
	}

	BFS(0, 0);
	printf("%d\n", check[N - 1][M - 1] + 1);
}
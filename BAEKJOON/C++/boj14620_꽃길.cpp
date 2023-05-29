#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <string>
#include <algorithm>
#include <cmath>

#include <typeinfo> // sizeof, typeid
using namespace std;

int arr[10][10];
int n, MIN = 600;
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

void dfs(int cx, int cy, int sum, int cnt, int visited[10][10])
{
    for (int i = 0; i < 4; i++)
    {
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        cout << visited[nx][ny] << endl;

        if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] == -1)
            return;
        else
        {
            sum += visited[nx][ny];
            visited[nx][ny] = -1;
        }
    }

    cnt++;
    if (cnt == 3)
    {
        MIN = min(sum, MIN);
        cout << cx << ' ' << cy << ' ' << sum << endl;
        return;
    }

    for (int i = 0; i < 4; i++) // 다음 꽃술찾기
    {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] == -1)
            return;
        else
        {
            int temp = visited[nx][ny];
            visited[nx][ny] = -1;
            dfs(nx, ny, sum, cnt, visited);
            visited[nx][ny] = temp;
        }
    }
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> arr[i][j];
        }
        // cout << typeid(arr[i][0]).name() << endl;
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            dfs(i, j, 0, 0, arr);
            cout << i << ' ' << j << ' ' << endl;
        }
    }

    cout << MIN << endl;
}
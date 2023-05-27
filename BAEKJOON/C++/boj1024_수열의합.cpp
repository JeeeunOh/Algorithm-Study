#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
using namespace std;

// 18 4
// 6 7 8

// 18 2
// 1 2
// 1 2 3

int main()
{
    int N, L;
    cin >> N >> L; // 18 4

    // 0 1 2 3
    int temp = 0;
    for (int i = 0; i < L - 1; i++)
    {
        temp += i;
    }

    for (int i = L - 1; i <= N; i++)
    {

        temp += i;
        if (i >= 100 || temp > N)
            break;

        if ((N - temp) % (i + 1) == 0)
        {
            int a = (N - temp) / (i + 1);
            for (int j = 0; j <= i; j++)
            {
                cout << j + a << ' ';
            }
            return 0;
        }
    }

    cout << -1 << endl;
}
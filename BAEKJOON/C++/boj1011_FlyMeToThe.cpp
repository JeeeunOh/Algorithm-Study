#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <string>
#include <algorithm>
#include <cmath>
using namespace std;

int main()
{
    int n;
    cin >> n;

    while (n--)
    {
        long long a, b;
        cin >> a >> b;
        long long dist = b - a;
        long long temp = 1;

        while (true)
        {
            dist -= temp / 2;
            if (dist <= 0)
                break;
            temp++;
        }

        cout << temp - 1 << endl;
    }
}
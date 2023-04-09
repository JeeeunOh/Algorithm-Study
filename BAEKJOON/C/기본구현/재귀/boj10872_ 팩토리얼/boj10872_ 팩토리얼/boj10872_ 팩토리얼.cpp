#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    int result = 1;
    if (n == 0) {
        cout << 1;
        return 0;
    }
    else {
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
    }
    cout << result;
    return 0;
}
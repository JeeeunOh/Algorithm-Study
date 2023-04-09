#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int T;
    cin >> T;

    while (T--) {
        int N;
        cin >> N;

        vector <int> v(N);

        for (int i = 0; i < N; i++) cin >> v[i];

        sort(v.begin(), v.end());

        int result = 0;
        result = max(result, v[1] - v[0]);
        result = max(result, v[N - 1] - v[N - 2]);

        for (int i = 0; i < N - 2; i++) {
            result = max(result, v[i + 2] - v[i]);
        }
        cout << result << '\n';
    }
}
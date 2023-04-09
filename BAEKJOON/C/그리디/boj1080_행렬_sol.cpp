#include <iostream>
#include <vector>
using namespace std;

void reverseMtx(int row, int col, vector<string> &matrix_a) {
    for (int i = row; i < row + 3; i++) {
        for (int j = col; j < col + 3; j++) {
            if (matrix_a[i][j] == '1') {
                matrix_a[i][j] = '0';
            }
            else {
                matrix_a[i][j] = '1';
            }
        }
    }
}
int isPossible(int n, int m, vector<string> &matrix_a, vector<string> &matrix_b) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (matrix_a[i][j] != matrix_b[i][j]) {
                return false;
            }
        }
    }
    return true;
}

int main() {
    int n, m;
    cin >> n >> m;

    vector<string> matrix_a(n);
    vector<string> matrix_b(n);

    for (int i = 0; i < n; i++) cin >> matrix_a[i]; 
    for (int i = 0; i < n; i++) cin >> matrix_b[i]; 
    
    int ans = 0;
    for (int i = 0; i <= n - 3; i++) {
        for (int j = 0; j <= m - 3; j++) {
            if (matrix_a[i][j] != matrix_b[i][j]) { //(i, j)원소가 서로 다르다면
                reverseMtx(i, j, matrix_a);
                ans++;
            }
        }
    }
    
    if (!isPossible(n, m, matrix_a, matrix_b)) {
        ans = -1;
    }
    cout << ans;
    return 0;
}
#include <iostream>
#include <vector>

using namespace std;

void fillStar(int width, vector<vector<char> > &star, int row, int col) {
    if (width == 1) {
        star[row][col] = '*';
        return;
    }

    fillStar(width - 4, star, row + 2, col + 2);

    for (int i = row; i < row + width; i++)
        star[i][col] = star[row][i] = star[row + width - 1][i] = star[i][col + width - 1] = '*';
}

int main() {
    int n, width;
    cin >> n;
    width = 4 * n - 3; //출력되는 별의 n값에 따른 가로 세로 길이
    vector<vector<char> > star(width, vector<char>(width, ' '));
    fillStar(width, star, 0, 0);
    //출력
    for (int i = 0; i < width; i++) {
        for (int j = 0; j < width; j++)
            cout << star[i][j];
        cout << '\n';
    }
    return 0;
}
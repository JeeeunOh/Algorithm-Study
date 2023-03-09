#include <iostream>
#include <vector>
// 상하좌우, 대각선에 퀸이 있으면 안됨
using namespace std;
int N, ans=0;
int xy[15][15];
int col[15];

int abs(int a, int b) {
	return a - b > 0 ? a - b : b - a;
}

bool promising(int i) {
	int k = 1;
	bool flag = true;
	while (k < i && flag) {
		if (col[k] == col[i] || abs(col[k], col[i]) == i - k)
			flag = false;
		k++; // 1행부터 i=1행까지 반복
	}
	return flag;
}

void queens(int i) {
	if (promising(i)) {
		if (i == N) ans++; // 행은 N-1까지 있으므로 N까지 도달했을때가 끝
		else {
			for (int j = 1; j <= N; j++) {
				if (xy[i][j] == 1) continue;
				else {
					col[i+1] = j; // i,j+1에 퀸을 놓았다고 가정하고
					queens(i + 1); // 다음행을 탐색해보기
				}
			}
		}
	}
}

int solution(int n, int k, vector<int> X, vector<int> Y) {
	N = n;
	for (int i = 0; i < k; i++) {
		xy[X[i] - 1][Y[i]] = 1; // 행은 N-1까지, 열은 N까지
	}
	queens(0);
	return ans;
}
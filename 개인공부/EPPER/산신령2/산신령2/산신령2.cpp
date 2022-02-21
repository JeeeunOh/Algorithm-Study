#include <algorithm>
#include <string>
#include <vector>
using namespace std;

long long solution(int N, vector<vector<long long>> money) {
	for (int i = 1; i < N; i++) {
		for (int j = 0; j <= i; j++) {
			if (j == 0) money[i][0] += money[i - 1][0];
			else if (j == i) money[i][j] += max(money[i-1][j], money[i - 1][j - 1]);
			else money[i][j] += money[i - 1][j];
		}
	}
	long long ans =money[N - 1][0];
	for (int i = 0; i < N; i++) {
		ans = max(money[N - 1][i], ans);
	}
	return ans;
}
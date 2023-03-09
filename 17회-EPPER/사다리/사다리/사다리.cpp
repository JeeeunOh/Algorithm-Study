#include <string>
#include <vector>
using namespace std;

long long solution(int n, vector<int> goal) {
	int ans = 0;

	for (int i = 1; i < n; i++) {
		for (int j = i-1; j >=0; j--) { // j는 i바로 전부터 탐색해서 0번까지 내림차순
			if (goal[j] > goal[i]) ans++; // goal은 오름차순이어야하니, 내림차순이면
			//ans++
		}
	}

	return ans;
}

#include <vector>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> M) {
	vector<int> ans (n,0); // ans은 0부터 시작
	ans[0] = M[0];
	if (n > 1) ans[1] = M[0] + M[1];
	if (n > 2) {
		for (int i = 2; i < n; i++) {
			ans[i] = max({ 
				ans[i - 1], 
				ans[i - 2] + M[i],
				ans[i - 3] + M[i - 2] + M[i - 1]  });
		}
	}
	return ans[n-1];
}
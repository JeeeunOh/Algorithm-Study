#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

long long solution(int n, vector<int> times) {
	long long ans = LLONG_MAX;
	sort(times.begin(), times.end());
	long long start = 1;
	long long end = (long long)n * (long long)times[times.size() - 1];
	long long mid = 0;
	while (start <= end) {
		int temp = 0;
		mid = (start + end) / 2;
		for (int i = 0; i < times.size(); i++) {
			temp += mid / times[i];
		}
		if (temp >= n) {
			ans = min(ans, mid);
			end = mid - 1;
		}
		else start = mid + 1;
	}
	return ans;
}
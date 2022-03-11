#include <iostream>
#include <algorithm>
using namespace std;
int a[30] = { 1,5,11,36 };

int main(void) {
	int T,n,cnt;
	cnt = 5;
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> n;
		if (a[n - 1] == 0)
			for (int t = cnt-1; t < n; t++) {
				a[t] = a[t - 1] + a[t - 2] * 5 + a[t - 3] - a[t - 4];
			}
		cout << a[n - 1] << endl;
		cnt = max(cnt, n);
	}
	return 0;
}
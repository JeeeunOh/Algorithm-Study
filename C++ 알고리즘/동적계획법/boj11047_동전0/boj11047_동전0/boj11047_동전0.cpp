
#include <iostream>
using namespace std;

int main()
{
	int n, k;
	cin >> n >> k;
	int arr[10];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		if (arr[i] > k) {
			i--;
			n--;
		}
	}

	int temp = n - 1;
	int ans = 0;

	while (k != 0) {
		if (arr[temp] <= k) {
			k -= arr[temp];
			ans++;
		}
		else temp--;
	}

	cout << ans << endl;

}
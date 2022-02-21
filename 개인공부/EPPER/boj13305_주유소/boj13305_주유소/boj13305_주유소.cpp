 #include <iostream>
using namespace std;
long long n;
long long len[100000] = { 0, };
long long price[100000] = { 0, };

int solution() {
	long long min = 1000000000;
	int sum = 0;
	for (int i = 0; i < n; i++) {
		if (min > price[i]) { // price[i]가 최소값을 갱신할 때
			min = price[i];
			sum += len[i] * min;
		}
		else { // min이 최솟값을 유지할때
			sum += len[i] * min;
		}
	}
	return sum;
}

int main()
{
	cin >> n;
	for (int i = 0; i < n-1; i++)  cin >> len[i];
	for (int i = 0; i < n ; i++)  cin >> price[i];

	cout << solution();
}
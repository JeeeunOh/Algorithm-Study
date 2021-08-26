#include <iostream>
using namespace std;

int main()
{
	int n, m;
	cin >> n >> m;
	int arr[100] = { 0,};
	int max = 0;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	for(int i=0 ; i< n-2; i++)
		for (int j = 0; j < n - 1; j++) {
			for (int k = 0; k < n; k++) {
				if (i == j || j == k || i == k) continue;
				if (arr[i] + arr[j] + arr[k] > max && arr[i] + arr[j] + arr[k] <= m)
				{
					max = arr[i] + arr[j] + arr[k];
				}
			}
		}
	cout << max;
}
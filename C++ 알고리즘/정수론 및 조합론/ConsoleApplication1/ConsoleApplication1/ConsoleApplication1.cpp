#include <iostream>
#include <algorithm>

using namespace std;
int main()
{
	int tot; // 약수의 총 개수

	cin >> tot;
	int* div = new int[tot]; // 모든 약수

	for (int i = 0; i < tot; i++)
	{
		cin >> div[i];
	}

	sort(div, div + tot);

	cout << div[0] * div[tot - 1];

}
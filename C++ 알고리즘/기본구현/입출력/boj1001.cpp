#include <iostream>
using namespace std;

int main()
{
	int A, B;
	int B1, B2, B3;
	int ans;
	cin >> A >> B;
	B1 = A * (B % 10);
	B2 = A * (B / 10) % 10;
	B3 = A * (B / 100) % 10;
	ans = B1 + B2 * 10 + B3 * 100;
	cout << ans << endl;

	return 0;
}
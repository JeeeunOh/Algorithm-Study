#include <iostream>
using namespace std;

int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	// a는 고정비용, b는 생산비용, c는 측정된 노트북 가격
	// (c-b)*ans > a
	// ans> a/(c-b)

	if (c <= b) {
		cout << "-1" << endl;
		return 0;
	} 
	else {
		int ans = a / (c - b) + 1;
		cout << ans << endl;
	}
}
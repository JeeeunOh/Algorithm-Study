#include <iostream>
using namespace std;

int main()
{
	int N, X;
	int a;
	
	cin >> N >> X;

	for (int i = 0; i < N; i++) {
		cin >> a;
		if (a < X)
			cout << a << " ";
	}


}
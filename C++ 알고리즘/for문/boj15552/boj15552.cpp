#include <iostream>

#include <string>

using namespace std;



int main() {

	int T;

	int a, b;

	cin >> T;



	for (int i = 0; i < T; i++) {

		cin >> a >> b;

		cout <<"Case #" << i+1 << ": " << a << " + " << b << " = " << a + b << endl;

	}

}
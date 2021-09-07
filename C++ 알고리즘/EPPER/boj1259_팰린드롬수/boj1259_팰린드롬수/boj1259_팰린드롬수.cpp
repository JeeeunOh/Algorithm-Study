#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main()
{
	string input;
	while (true) {
		cin >> input;
		int flag = 1; // yes로 시작
		if (input=="0") break;
		for (int i = 0; i < input.size() / 2; i++) { //6이면 0 1 2, 5면 0 1
			if (input[i] != input[input.size() - i - 1]) {
				cout << "no" << endl;
				flag = 0;
				break;
			}
		}
		if (flag == 1) cout << "yes" << endl;
	}
}

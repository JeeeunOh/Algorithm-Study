#include <iostream>
#include <cstring>
#include <stack>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
	int sum = 0;
	int num;
	int N;
	cin >> N;
	stack<int> s;

	for (int i = 0; i < N; i++) {
		cin >> num;
		if (num != 0) s.push(num);
		else s.pop();
	}

	for (int i = 0; !s.empty(); i++) {
		sum += s.top();
		s.pop();
	}
	cout << sum << endl;

}
#include <iostream>
#include <queue>
using namespace std;

int main()
{
	int n;
	cin >> n;
	queue<int> q;

	for (int i = 1; i <= n; i++) {
		q.push(i);
	}
	for (int i = 0; q.size()>1; i++) {
		q.pop(); // 제일 위 카드 하나 버림
		q.push(q.front()); // 제일 밑에 집어넣음
		q.pop(); // 집어넣었으니 제일 위 것은 버림
	}
	cout << q.front();
}

// 1 2 3 4 5 6
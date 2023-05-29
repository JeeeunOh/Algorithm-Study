#include <iostream>
#include <queue>
using namespace std;

int n, num;
priority_queue<int, vector<int>, greater<int>> pq; // 최소힙

int main()
{

    cin >> n;

    // 연산
    for (int i = 0; i < n * n; i++)
    {
        cin >> num;
        pq.push(num);
        if (pq.size() > n)
        { // 저장된 숫자의 개수가 n보다 많으면 가장 작은 값(top 값)을 제거
            pq.pop();
        }
    }

    // 출력
    cout << pq.top();
    return 0;
}
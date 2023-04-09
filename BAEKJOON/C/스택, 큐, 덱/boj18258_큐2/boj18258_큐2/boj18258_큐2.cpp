#include<iostream>
#include<deque>
#include<string>
// 앞 뒤에서 모두 출력 가능하므로 덱
using namespace std;

int N;
string a;
deque<int> arr;

int main() {
    cin.tie(0);
    cin.sync_with_stdio(0);
    cin >> N;
    int temp;
    for (int i = 0; i < N; i++) {
        cin >> a;
        if (a == "push") { // 정수 X를 큐에 넣는 연산이다.
            cin >> temp;
            arr.push_back(temp);
        }
        else if (a == "pop") { // 가장 앞에 있는 정수를 빼고, 그 수를 출력
            if (!arr.empty()) {
                cout << arr.front() << "\n";
                arr.pop_front();
            }  else  cout << -1 << "\n";
        }
        else if (a == "size") { // 큐에 들어있는 정수의 개수를 출력
            cout << arr.size() << "\n";

        }
        else if (a == "empty") { // 큐가 비어있으면 1, 아니면 0을 출력
            if (arr.empty()) cout << 1 << "\n";
            else cout << 0 << "\n";
        }
        else if (a == "front") { // 큐의 가장 앞에 있는 정수를 출력
            if (arr.empty()) cout << -1 << "\n";
            else cout << arr.front() << "\n";
        }
        else if (a == "back") { // 큐의 가장 뒤에 있는 정수를 출력
            if (arr.empty()) cout << -1 << "\n";
            else cout << arr.back() << "\n";
        }
    }
}

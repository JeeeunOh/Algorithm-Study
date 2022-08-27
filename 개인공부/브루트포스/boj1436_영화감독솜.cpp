#include <iostream>
#include <string>
using namespace std;

int main(){
    int n;
    cin >> n;

    int num = 666 - 1;  // 666부터 탐색 시작

    while (true) { // n이 0이 될때까지 -> 숫자를 n개 찾을 때까지
        string cur = to_string(++num);
        if (cur.find("666") != cur.npos) { // cur에 666이 있을 때
            n--;
        }
        if(n==0) break;
    }

    cout << num << '\n';

}
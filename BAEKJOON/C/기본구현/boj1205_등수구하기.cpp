#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n, new_score, p;

    //입력
    cin >> n >> new_score >> p;
    vector<int> ranking(p + 1, 0);
    for (int i = 1; i <= n; i++) {
        cin >> ranking[i];
    }

    int idx = 1;
    int ans = 1;

    //새로운 점수를 어느 위치에 넣을지 탐색
    while (idx <= n) {
        if (new_score > ranking[idx]) {
            break;
        }
        if (new_score < ranking[idx]) {
            ans = idx + 1;
        }
        idx++;
    }
    if (idx == p + 1) { //랭킹 리스트에 들어가지 못하는 경우
        cout << -1 << '\n';
        return 0;
    }
    cout << ans << '\n';
}
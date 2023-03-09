#include <iostream>
#include <vector>

using namespace std;

int main(){
    long long N; // 시험장 개수
    long long B; // 총감독관이 한 시험장에서 감시할 수 있는 응시자의 수
    long long C; // 부 감독관이 감시 ~
    vector<int> v;
    long long cnt = 0;

    cin >> N;
    for (int i = 0; i < N; i++) {
        int n;
        cin >> n;
        v.push_back(n);
    }
    cin >> B >> C;

    for (int i = 0; i < N; i++) {
        v[i] -= B;
        cnt++;
        if (v[i] > 0) {
            if (v[i] % C == 0) cnt += v[i] / C;
            else cnt += v[i] / C + 1;
        }
    }

    cout << cnt;
}


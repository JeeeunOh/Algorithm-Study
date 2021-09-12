#include <iostream>
#include <queue>
#include <vector>
using namespace std;

vector<int> solution(int N, vector<vector<int>> E, int M, vector<int> firstInfected) {
    queue<int> Q; // 감염된 사람의 번호를 큐에 저장할 것이다.
    vector<int> answer(N + 1, -1); // solution 함수에서 리턴할 배열, 사이즈 N+1, -1로 초기화
    vector<int> turn(N + 1, 0); // 감염까지 남은 주변 비감염 사람 수, 사이즈 N+1, 0로 초기화

    // 최조생성자 처리
    for (int t : firstInfected) {
        Q.push(t); // 최조생성자는 감염된 사람이고 주변인에게 영향을 주므로 큐에 넣어주고
        answer[t] = 0; // 0분에 감염되었음을 저장한다.
    }

    // 주변인의 절반 이상이 루머를 믿을 때 본인도 루머를 믿으므로
    // 몇 명이 감염되었을 때 자신이 감염되는지에 대한 정보를 사람 i의 주변인물 수 + 1 / 2의 몫으로 저장해둔다.
    // 사람의 번호가 아닌 입력의 끝을 말하는 0이 adj 배열에 포함되어 있으므로 + 1은 안해도 된다.

    for (int i = 1; i <= N; i++) turn[i] = E[i].size() / 2;

    while (!Q.empty()) { // 큐가 빌 때까지 탐색하는데, 큐가 비었다면 모든 탐색을 마쳤다는 의미이다.
        int current = Q.front(); // 현재, 가장 먼저 감염된 사람의
        Q.pop();

        for (int next : E[current]) { // 주변인물들에게
            if (next == 0) break;
            turn[next] -= 1; // 자신(주변인물)이 감염되기까지 남은 사람 수를 1 빼고
            if (answer[next] == -1 && turn[next] <= 0) { // 만약 아직 감염되지 않았고 주변인의 반 이상이 감염되었다면
                Q.push(next); // 감염되었기에 큐에 자신의 번호를 넣어주고
                answer[next] = answer[current] + 1; // 자신을 감염시킨 마지막 주변인의 감염된 시간 + 1분을 더해 저장한다.
            }
        }
    }

    // 계산의 편의를 위해 배열에 0번 index가 아닌 1번 index부터 정답이 저장되었으므로,
    // 배열의 첫번째 원소를 지우고 반환한다.
    answer.erase(answer.begin());
    return answer;
}

int main() {
    int N;
    cin >> N;
    vector<vector<int>> E(N + 1);

    for (int i = 1; i <= N; i++) {
        while (1) {
            int t;
            cin >> t;
            E[i].push_back(t);
            if (t == 0) break;
        }
    }
    int M;
    cin >> M;
    vector<int> firstInfected(M);
    for (int i = 0; i < M; i++) {
        int t;
        cin >> t;
        firstInfected.push_back(t);
    }

    vector<int> ans = solution(N, E, M, firstInfected);
    for (int i = 0; i < N; i++)
        cout << ans[i] << " ";
    cout << "\n";
}
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

vector<int> solution(int N, vector<vector<int>> E, int M, vector<int> first) {
	// 사람 수, 주변인 번호, 감염인 수, 감염인 정보
	queue<int> Q; // 감염자 저장할 큐
	vector<int> answer(N+1, -1); // 반환할 answer
	vector<int> turn(N+1, 0); //감염에 필요한 주변 감염인 수 저장

	for (int i : first) { // Q에 감염인 정보 차례대로 집어넣기
		Q.push(i);
		answer[i] = 0;
	}
	for (int i = 1; i <= N; i++) {
		turn[i] = E[i].size() / 2;
	}
	while (!Q.empty()) { // Q가 비어있지 않다면,
		int current = Q.front();
		Q.pop();
		for (int next : E[current]) { // current의 주변인들 탐색
			if (next == 0) break;
			turn[next]--;
			if (answer[next] == -1 && turn[next] <= 0) {
				Q.push(next);
				answer[next] = answer[current] + 1;
			}
		}
	}
	answer.erase(answer.begin());
	return answer;
}
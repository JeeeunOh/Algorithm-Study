#include <iostream>
#include <queue>
#include <vector>
using namespace std;

vector<int> solution(int N, vector<vector<int>> E, int M, vector<int> first) {
	// 사람 수 N, 주변인들 번호 E, 최초 유포자 수 M, 유포자 정보 first

	queue<int> Q;
	vector<int> answer(N + 1, -1); // solution함수에서 리턴할 배열
	vector<int> turn(N + 1, 0); // 감염까지 남은 주변 비감염 사람 수

	//최초생성자 처리
	for (int i : first) {
		Q.push(i);
		answer[i] = 0;
	}

	// turn배열 값 넣어주기
	for (int i = 1; i <= N; i++)
		turn[i] = E[i].size() / 2; 

	while (!Q.empty()) {
		int current = Q.front(); // 현재, 가장 먼저 감염된 사람의
		Q.pop();

		for (int next : E[current]) { // 주변사람들에게
			if (next == 0) break;
			turn[next] -= 1;
			if (answer[next] == -1 && turn[next] <= 0) { // 만약 아직 감염되지 않았고 주변인의 반 이상이 감염이라면
				Q.push(next); // 감염자 큐에 자기 넣어주고
				answer[next] = answer[current] + 1;
			}
		}
	}
	answer.erase(answer.begin());
	return answer;
}
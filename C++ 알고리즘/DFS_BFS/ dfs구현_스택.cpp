#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <stdio.h>
#include <queue>

using namespace std;


// stack에 들어가면 방문한거로 판단
// 해당 위치를 true로 해준다.
void dfs(int start, vector<int> graph[], bool check[]) {

	stack<int> s;
	s.push(start);
	check[start] = true;
	printf("%d ", start);

	while (!s.empty()) {

		int current_node = s.top();
		s.pop();
		for (int i = 0; i < graph[current_node].size(); i++) {

			int next_node = graph[current_node][i];

			if (check[next_node] == false) {
				printf("%d ", next_node);
				check[next_node] = true;
				// pop()을 했었기 때문에 현재 current_node도 넣어줘야한다.
				s.push(current_node);
				s.push(next_node);
				break;
			}
		}
	}

}

int main() {


	int n, m, start;
	cin >> n >> m >> start;

	vector<int> graph[n + 1];
	// Visual Studio의 경우
	/* 변수를 통해서 배열을 동적으로 생성할 때
	vector<int> * graph = new vector<int>[n+1];
	*/
	bool check[n + 1];
	fill(check, check + n + 1, false);

	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;

		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	// Sorting은 왜 한거지?
	// 나중에 하나의 정점에서 다음을 탐색할 때 node 값에 순차적으로 접근해야하기 때문
	for (int i = 1; i <= n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	//dfs
	dfs(start, graph, check);
	printf("\n");

	return 0;
}
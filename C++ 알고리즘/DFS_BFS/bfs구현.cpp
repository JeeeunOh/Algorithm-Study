#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

void bfs(int start, vector<int> graph[], bool check[]) {
	queue<int> q;

	q.push(start);
	check[start] = true;

	while (!q.empty()) {
		int tmp = q.front();
		q.pop();
		printf("%d ", tmp);
		for (int i = 0; i < graph[tmp].size(); i++) {

			// 방문하지 않았다면
			if (check[graph[tmp][i]] == false) {
				// 큐에 넣어주고 방문했음을 표시한다.
				q.push(graph[tmp][i]);
				check[graph[tmp][i]] = true;
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

	//bfs
	bfs(start, graph, check);
	printf("\n");

	return 0;
}

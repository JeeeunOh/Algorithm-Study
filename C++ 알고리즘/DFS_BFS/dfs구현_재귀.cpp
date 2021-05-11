// 스택 또는 재귀함수로 구현

#include <iostream>//입출력 헤더파일
#include <stdio.h>
#include <vector> // 동적인 배열
#include <algorithm>// 파티션, 정렬, 이진 탐색, 병합, 셋, 힙 등을 구현해줌

using namespace std;

//dfs에 들어오면 방문한 것으로 판단
//해당 위치에 check true로 해준다.

void dfs(int start, vector<int> graph[], bool check[]){
    check[start] = true;
    printf("%d", start);

    for(int i = 0 ; i<graph[start].size(); i++){
        int next = graph[start][i];
        //방문하지 않았다면
        if(check[next]==false){
            //재귀함수 호출
            dfs(next, graph, check);
        }
    }
}

int main(){
    int n, m, start;
    cin>>n>>m>>start;
    vector<int> graph[n+1];

    bool check[n+1];
    fill(check, check+n+1, false);

    for(int i = 0 ; i < m ; i++){
        int u,v;
        cin>>u>>v;
        graph[u].push_back(v); //graph[u]에 V를 추가한다는 뜻
        graph[v].push_back(u);
    }
    for(int i=1;i<=n ; i++){
        sort(graph[i].begin(), graph[i].end());
    }
    //dfs
	dfs(start, graph, check);
	printf("\n");

	return 0;
}

#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>

#include <stack>
#include <queue>
using namespace std;

// dfs 재귀 구현
void dfs(int start, vector<int> graph[], bool check[]){
    check[start]=true;
    cout << start;

    for(int i=0 ; i<graph[start].size(); i++){
        int next=graph[start][i];
        //벙문하지 않았다면
        if(check[next]==false){
            dfs(next, graph,check);
        }
       
    }
}

// dfs 스택 구현
void dfs(int start, vector<int> graph[], bool check[]){
    stack<int> s;
    s.push(start);
    check[start]=true;
    cout << start;

    while(!s.empthy()){
        int cur=s.top();
        s.pop();
        for(int i=0 ; i<graph[cur].size(); i++){
            int next = graph[cur][i];
            if(check[next]==false){
                cout << next;
                check[next]=true;
                //pop()을 했었기 때문에 현재 cur도 넣어주어야한다.
                s.push(cur);
                s.push(next);
                break;
            }
        }
    }
}

//bfs 구현

void bfs(int start, vector<int> graph[], bool check){
    queue<int> q;

    q.push(start);
    check[start]=true;

    while(!q.empthy()){
        int tmp=q.front();
        q.pop();
        cout << tmp;
        for(int i=0 ; i<graph[tmp.size(); i++){
            if(check[graph[tmp][i]]==false){
                q.push(graph[tmp][i]);
                check[graph[tmp][i]]=true;
            }
        }
    }
}

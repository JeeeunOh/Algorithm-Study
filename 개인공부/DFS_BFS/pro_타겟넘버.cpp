#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

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

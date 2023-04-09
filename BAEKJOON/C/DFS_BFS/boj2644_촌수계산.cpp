#include <iostream>
#include <queue>
#define MAX 101
 
using namespace std;
 
int [MAX] = {0};
vector<int> v[MAX];

int bfs(int start, int end){
    queue<int> q;
    q.push(start);
 
    while(!q.empty()){
        int x = q.front();
        q.pop();
        
        if(x == end) return dist[end];
        
        unsigned long size = v[x].size();
        
        for(int i = 0; i < size; i++){
            int y = v[x][i];
            
            if(!dist[y]){
                q.push(y);
                dist[y] = dist[x] + 1;
            }
        }
    }
    return -1;
}
 
 
int main(int argc, const char * argv[]) {
    int n;
    int start, end;
    int m;
    int x, y;
    
    cin >> n >> start >> end >> m;
    for(int i = 0; i < m; i++){
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }
    
    cout << bfs(start, end) << '\n';
    
    return 0;
}

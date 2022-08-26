#include <iostream>
#include <queue>
using namespace std;
int n;
int dx[4]={-1,1,0,0};
int dy[4]={0,0,-1,1};

void change(vector<string> &norm){
    for(int i=0 ; i<n ;i++){
        for(int j=0 ; j<n ; j++){
            if(norm[i][j]=='R') norm[i][j]='G';
        }
    }
}

int sol(vector<string> &norm, vector<vector<bool>> &visited){
    int res=0;

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
            if(visited[i][j]) continue;
            
            res++;

            queue<pair<int, int>> q;
            q.push({i,j});
            visited[i][j]=true;

            while(!q.empty()){
                auto cur = q.front();
                q.pop();
                int cx = cur.first;
                int cy = cur.second;
                visited[cx][cy]=true;

                for(int i=0 ; i<4 ; i++){
                    int nx = cx+dx[i];
                    int ny = cy+dy[i];

                    if(nx>=0 && nx<n && ny>=0 && ny<n && norm[cx][cy]==norm[nx][ny]){
                        q.push({nx, ny});
                        visited[nx][ny]=true;
                    }
                }
            }
        }
    }
}

int main(){
    cin >> n;
    vector<string> norm(n);
    vector<vector<bool>> visited1(n,vector<bool>(n, false));
    vector<vector<bool>> visited2(n,vector<bool>(n, false));

    for(int i=0 ; i<n ; i++){
        cin >> norm[i];
    }

    // 일반 사람

    cout << sol(norm, visited1) << " " ;
    change(norm);

    for(int i=0 ; i<n ;i++){
        for(int j=0 ; j<n ; j++){
            cout << norm[i][j] << " ";
        }
        cout << '\n';
    }

    cout << sol(norm, visited2) << '\n';
}
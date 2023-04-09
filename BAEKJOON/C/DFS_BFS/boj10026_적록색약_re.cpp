#include <iostream>
#include <queue>
using namespace std;

int dx[4]={-1,1,0,0};
int dy[4]={0,0,-1,1};

int main(){
    int n;
    cin >> n;
    vector<string> norm(n);
    vector<string> abnorm(n);

    for(int i=0 ; i<n ; i++){
        cin >> norm[i];
        cin >> abnorm[i];
    }

    // 일반 사람

    char last='f';
    int res1=0, res2=0;

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
            if(norm[i][j]!='f') last=norm[i][j]; // 기준점 잡기
            else continue;

            res1++;
            queue<pair<int, int>> q;
            q.push({i,j});
            norm[i][j]='f';


            while(!q.empty()){
                auto cur = q.front();
                q.pop();
                int cx = cur.first;
                int cy = cur.second;
                norm[cx][cy]='f';

                for(int i=0 ; i<4 ; i++){
                    int nx = cx+dx[i];
                    int ny = cy+dy[i];

                    if(nx>=0 && nx<n && ny>=0 && ny<n && norm[nx][ny]==last){
                        q.push({nx, ny});
                    }
                }
            }
        }
    }

    last='f';

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){

            if(abnorm[i][j]=='R') abnorm[i][j]='G';
            if(abnorm[i][j]!='f') last=abnorm[i][j]; // 기준점 잡기
            else continue;

            res2++;
            queue<pair<int, int>> q;
            q.push({i,j});
            abnorm[i][j]='f';


            while(!q.empty()){
                auto cur = q.front();
                q.pop();
                int cx = cur.first;
                int cy = cur.second;
                abnorm[cx][cy]='f';

                for(int i=0 ; i<4 ; i++){
                    int nx = cx+dx[i];
                    int ny = cy+dy[i];

                    if(nx>=0 && nx<n && ny>=0 && ny<n && abnorm[nx][ny]==last){
                        q.push({nx, ny});
                    }
                }
            }
        }
    }

    cout << res1 << " " << res2 << '\n';
}
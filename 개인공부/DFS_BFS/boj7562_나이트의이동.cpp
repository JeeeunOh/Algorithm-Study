#include <iostream>
#include <queue>
using namespace std;

int dx[] = {1,2,2,1,-1,-2,-2,-1}; 
int dy[] = {2,1,-1,-2,-2,-1,1,2};

int main(){
    int T;
    cin >> T;

    while(T--){
        int n;
        int x1, y1, x2, y2;
        int check[301][301]={0};
        queue<pair<int,int>> q;

        
        cin >> n;
        cin >> x1 >> y1 >> x2 >> y2;
        check[x1][y1]=1;

        q.push(make_pair(x1, y1));

        while(!q.empty()){
            int x = q.front().first;
            int y = q.front().second;
            q.pop();

            for(int i=0 ; i<8 ; i++){
                int tx=x+dx[i];
                int ty=y+dy[i];

                if(tx>=0 && tx<n && ty>=0 && ty<n && !check[tx][ty]){
                    q.push({tx, ty});
                    check[tx][ty]=check[x][y]+1;
                }
            }
        }
        cout << check[x2][y2]-1 << endl;
    }
}
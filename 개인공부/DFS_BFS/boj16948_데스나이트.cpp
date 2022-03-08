#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

int N;
int r1,c1,r2,c2;
int check[201][201];

int dx[]={-2,-2,0,0,2,2};
int dy[]={-1,1,-2,2,-1,1};

int main(){

    memset(check, -1, sizeof(check));

    cin >> N;
    cin >> r1 >> c1 >> r2 >> c2;

    queue<pair<int, int>> q;
    q.push(make_pair(r1, r2));
    check[r1][r2]=0;
    
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;

        q.pop();

        if(x==r2 && y==c2){
            break;
        }

        for(int i=0 ; i<6; i++){
            int t1=x+dx[i];
            int t2=y+dy[i];

            if(t2<0 || t1<0 || t2>=N || t1>=N) continue;
            if(check[t1][t2]==-1){
                check[t1][t2] = check[x][y] + 1;
                q.push(make_pair(t1, t2));
            }
        }
    }

    cout << check[r2][c2] << endl;
    return 0;
}
#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
using namespace std;

int N,M;
int arr[1000][1000];
int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};
queue<pair<int, int>> q;

void solution(int x, int y, int cnt, bool check[1000][1000]){

    check[x][y]=true;
    q.push(make_pair(x,y));

    while(!q.empty()){
        int tempX = q.front().first;
        int tempY = q.front().second;
        q.pop();

        for(int i=0 ; i<4 ; i++){
            int cntX = tempX+dx[i];
            int cntY = tempY+dy[i];

            if(cntX>=0 && cntY>=0 && cntX<N && cntY<M && check[cntX][cntY]!=true && arr[cntX][cntY]==0){
                check[cntX][cntY]=true;
                q.push(make_pair(cntX, cntY));
                cnt++;
            }
        }
    }
    arr[x][y]=cnt;
}

int main(){
    cin >> N >> M;
    
    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<M ; j++){
            cin >> arr[i][j];
        }
    }

    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<M ; j++){
            bool check[1000][1000];
            if(arr[i][j]!=0) {
                solution(i, j, 0, check);
            }
        }
    }

    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<M ; j++){
            cout << arr[i][j];
        }
        cout << endl;
    }

}
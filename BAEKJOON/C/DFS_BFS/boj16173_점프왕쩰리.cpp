#include <iostream>
#include <queue>
using namespace std;

int dx[]={1,0};
int dy[]={0,1};

queue<pair<int, int>> q;

int main(){
    int N;
    cin >> N;
    int arr[3][3];
    int check[3][3];
    q.push(make_pair(0,0));

    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<N ; j++){
            cin >> arr[i][j];
            check[i][j]=0;
        }
    }

    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        check[x][y]=1;
        
        q.pop();
        int cnt=arr[x][y];

        for(int i=0 ; i<2 ; i++){
            int tempx=x+dx[i]*cnt;
            int tempy=y+dy[i]*cnt;

            if(tempx==N-1 && tempy==N-1){
                cout << "HaruHaru" << endl;
                return 0;
            }
            if(tempx<N || tempy<N && check[tempx][tempy]!=1){
                q.push(make_pair(tempx, tempy));
            }
        }
    }
    cout << "Hing" << endl;
}
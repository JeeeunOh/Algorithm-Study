#include <iostream>
#include <queue>
using namespace std;

queue<pair<pair<int, int>, <int>>> q;
int dx[] = {1,-1,0,0};
int dy[]= {0,0,1,-1};

int main(){
    int n,m;
    int arr[100][100];
    cin >> n >> m;

    for (int i=0 ; i<n ; i++){
        int temp;
        cin >> temp;
        for(int j=m-1 ; j>=0 ; j--){
            arr[i][j]=temp%10;
            temp/=10;
        }
    }

    q.push(make_pair(make_pair(0,0), 0));
    int min=100000;
    bool check[100][100];

    while(!q.empty()){
        int x = q.front().first.first;
        int y = q.front().first.second;
        int cnt=q.front().second;

        check[x][y]=true;
        q.pop();
        
        if(x==n-1 && y==m-1){
            cnt++;
            if(min>cnt) min=cnt;
        }

        for(int i=0 ; i<4;  i++){
            int tx=x+dx[i];
            int ty=y+dy[i];

            if(arr[tx][ty]==1 && check[tx][ty]!=true){
                q.push(make_pair(make_pair(tx,ty), cnt+1));
            }
        }
    }
    cout << min << endl;
}
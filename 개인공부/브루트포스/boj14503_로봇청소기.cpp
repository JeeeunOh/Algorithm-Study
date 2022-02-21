#include <iostream>
using namespace std;

int N,M;
int r,c,d;
int arr[50][50];
int clean[50][50]; // 청소했으면 1로 체크
int tempX,tempY;
int cnt=0, flag=0; // 방향 다 탐색해서 flag가 4이면 작동 멈추기

int main(){
    ios::sync_with_stdio(false);
    cin >> N >> M;
    cin >> r >> c >> d;
    for(int i=0 ; i<N ; i++)
        for(int j=0 ; j<M; j++)
            cin >> arr[i][j];

    //탐색 시작
    while(true){
        // 0 북쪽 1 동쪽 2 남쪽 3 서쪽의 왼쪽 탐색
        if(flag==4) {
            if(d==0){ tempX=r;tempY=c-1; }
            else if(d==1){ tempX=r+1;tempY=c; }
            else if(d==2){ tempX=r;tempY=c+1; }
            else if(d==3){ tempX=r-1;tempY=c; }

            if(arr[tempX][tempY]==0 && arr[tempX][tempY]!=1){
                r=tempX;c=tempY;
                continue;
            } else break;
        }
        if(arr[r][c]==0 && clean[r][c]!=1) {
            cnt++;
            flag = 0;
        } // 청소하지 않았으면 청소하고 방향 탐색 리셋
        // 0 북쪽 1 동쪽 2 남쪽 3 서쪽의 왼쪽 탐색
        if(d==0){ tempX=r-1;tempY=c; }
        else if(d==1){ tempX=r;tempY=c-1; }
        else if(d==2){ tempX=r+1;tempY=c; }
        else if(d==3){ tempX=r;tempY=c+1; }
        if(arr[tempX][tempY]==0 && arr[tempX][tempY]!=1){
            r=tempX;c=tempY;
            continue;
        } else{
            flag++; // 한 방향은 탐색한 것임
            continue;
        }
    }

}

#include <iostream>
using namespace std;

int fx[]={0,0,1,-1},fy[]={1,-1,0,0};
int n,m,
int map[100][100],ck[100][100];
int sx[10000],sy[10000];
int h=0,t=1,cnt, ans;


void f(int x, int y){
    for(int i=0; i<4; i++){ // 현재 위치 기준 상하좌우 탐색
        int tx=x+fx[i],ty=y+fy[i];
        if(tx<0||ty<0||tx>=n||ty>=m) continue; // 정해진 범위 밖이면 패스
        if(map[tx][ty]){ // 치즈가 있는 부분이면
            ck[tx][ty]++;
            if(ck[tx][ty]==2){ // 바깥공기와 두면이상 맞닿아있으면
                cnt--;
                sx[t]=tx;
                sy[t++]=ty;
            }
        }
        else if(!ck[tx][ty])
            ck[tx][ty]=1,f(tx,ty);
    }
}

int main(){
    cin >> n >> m;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> map[i][j];
            cnt+=map[i][j]; // 치즈가 총 몇개 있는지
        }
    }

    while(cnt){ // 남은 치즈 있을 때까지
        ans++; // 시간 카운트
        int tmp=t;
        while(h!=tmp){
            ck[sx[h]][sy[h]]++;
            f(sx[h],sy[h]);
            h++;
        }
    }
    
    cout << ans << endl;
    return 0;
}

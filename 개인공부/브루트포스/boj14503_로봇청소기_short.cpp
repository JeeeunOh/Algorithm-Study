#include <cstdio>
int n,m,x,y,c,cn;
char a[50][50];
char dx[]={-1,0,1,0,-1,0,1},dy[]={0,1,0,-1,0,1,0};
int main(){
    scanf("%d%d%d%d%d\n",&n,&m,&x,&y,&c);
    c+=3;
    for(int i=0,j=0; i<n;i++,j=0)
        while(j<m){a[i][j++]=getchar();getchar();}
    while(1){
        if(a[x][y]=='0'){a[x][y]=1;cn++;}
        int d=-1,nx,ny;
        while(++d<4) {
            int nd=c-d;
            nx=x+dx[nd];ny=y+dy[nd];
            if(a[nx][ny]=='0'){x=nx;y=ny;c=nd%4+3;break;}
        }
        if(d>=4){
            nx=x+dx[c-1];ny=y+dy[c-1];
            if(a[nx][ny]=='1')break;
            x=nx;y=ny;
        }
    }
    printf("%d", cn);
}
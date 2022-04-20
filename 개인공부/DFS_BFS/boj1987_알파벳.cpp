#include <iostream>
#include <string>
using namespace std;

int r,c;
string board[21];
int MAX=0;
int dx[4]={1, -1,0,0};
int dy[4]={0,0,1, -1};

void dfs(int x, int y, int check[26], int cnt){
    cnt++;
    check[board[x][y]-'A']=1; // 해당 알파벳 들여왔다고 표시
    if(cnt>MAX) {
        MAX=cnt;
        // cout << board[x][y] << '\n';
    }

    // cout << "현재 위치 : "<< "( " << x << ", " << y << " )" << '\n';

    for(int i=0; i<4 ; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx<0 || nx>=r || ny<0 || ny>=c) {
            // cout << "좌표 벗어남 : "<< "( " << nx << ", " << ny << " )" << '\n';
            continue; // 좌표가 지정위치 벗어나면 패스
        }
        if(check[board[nx][ny]-'A']==1) {
            // cout << "받은 적 있는 알파벳 : "<< "( " << nx << ", " << ny << " )" << '\n';
            continue; // 받은 적 있는 알파벳
        }
        dfs(nx,ny, check, cnt);
    }
}

int main(){
    cin >> r >> c;

    for(int i=0 ; i<r ; i++){
        string s;
        cin >> s;
        board[i]=s;
    }

    int check[26]={0}; // 알파벳 지나왔는지 확인하기용
    dfs(0,0, check, 0);

    cout << MAX << '\n';
}
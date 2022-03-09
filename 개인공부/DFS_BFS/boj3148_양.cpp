#include <iostream>
#include <string>
#include <queue>
using namespace std;
// . 빈필드 # 울타리 o 양 v 늑대

int dx[]={-1,1,0,0};
int dy[]={0,0,-1,1};

string arr[250][250];
int check[250][250]={0};

void bfs(int x, int y){

}

int main(){
    int R,C;
    cin >> R >> C;

    for(int i=0 ; i<R; i++){
        string input;
        cin >> input;
        for(int j=0 ; j<C; j++){
            arr[i][j]=input[j];
        }
    }

    for(int i=0 ; i<R; i++){
        for(int j=0 ; j<C; j++){
            if(arr[i][j]!="#" && !check[i][j]){ // 울타리 아니고, 방문한 적 없으면
                bfs(i,j);
            }
        }
    }

    int a=0, b=0;

    for(int i=0 ; i<R; i++){
        for(int j=0 ; j<C; j++){
            if(arr[i][j]=="o") a++;
            if(arr[i][j]=="v") b++;
        }
    }



}
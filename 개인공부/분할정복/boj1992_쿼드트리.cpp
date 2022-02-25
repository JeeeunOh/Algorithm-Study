#include <iostream>
using namespace std;

string input[64];

void solution(int x, int y, int size){
    char setNum=input[x][y];

    for(int i=x ; i<x+size; i++){
        for(int j=y; j<y+size; j++){
            // 기준 숫자랑 탐색 숫자가 다르면 for문 break;
            if(setNum!=input[i][j]) {
                cout << "(";
                solution(x,y,size/2);
                solution(x,y+size/2,size/2);
                solution(x+size/2,y,size/2);
                solution(x+size/2,y+size/2,size/2);
                cout << ")";
                return;
            }
        }
    }
    cout << setNum;
}

int main(){
    int n;
    cin >> n;

    for(int i=0 ; i<n ; i++){
        cin >> input[i];
    }
    solution(0,0,n);
}
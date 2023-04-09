#include <iostream>
using namespace std;

long long input[2187][2187];
int count1=0;
int count2=0;
int count3=0;

void solution(int x, int y, int size){
    int setNum=input[x][y];

    for(int i=x ; i<x+size; i++){
        for(int j=y; j<y+size; j++){
            // 기준 숫자랑 탐색 숫자가 다르면 for문 break;
            if(setNum!=input[i][j]) {
                solution(x,y,size/3);
                solution(x+size/3,y,size/3);
                solution(x+size/3*2,y,size/3);

                solution(x,y+size/3,size/3);
                solution(x+size/3,y+size/3,size/3);
                solution(x+size/3*2,y+size/3,size/3);

                solution(x,y+size/3*2,size/3);
                solution(x+size/3,y+size/3*2,size/3);
                solution(x+size/3*2,y+size/3*2,size/3);
                
                return;
            }
        }
    }
    
    if(setNum==-1) count1++;
    if(setNum==0) count2++;
    if(setNum==1) count3++;
}

int main(){
    int n;
    cin >> n;

    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j<n ; j++){
            cin >> input[i][j];
        }
    }

    solution(0,0,n);

    cout << count1 << endl;
    cout << count2 << endl;
    cout << count3 << endl;
}
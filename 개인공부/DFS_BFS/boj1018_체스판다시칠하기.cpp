#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n,m;
int MIN=2500;
vector<string> v(50);

string WB[8] = {
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
};
string BW[8] = {
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
};


// (0, 0) 이 a여야한다고 가정
int sol(int x, int y){
    int res=0, res1=0, res2=0;
    char arr[2]={'W', 'B'};

    char a = 'W';
    if(a=='W'){
        for(int i=x ; i<x+8 ; i++){
            for(int j=y ; j<y+8 ; j++){
                int temp = i+j;
                if(temp%2==0 && v[i][j]=='B'){
                    res1++;
                }
                if(temp%2==1 && v[i][j]=='W'){
                    res1++;
                }
            }
        }
    }

    
    a = 'B';
    if(a=='B'){
         for(int i=x ; i<x+8 ; i++){
            for(int j=y ; j<y+8 ; j++){
                int temp = i+j;
                if(temp%2==0 && v[i][j]=='W'){
                    res2++;
                }
                if(temp%2==1 && v[i][j]=='B'){
                    res2++;
                }
            }
        }
    }

    res = min(res1, res2);

    return res;
}

int main(){
    cin >> n >> m;

    for(int i=0 ; i<n ; i++){
        cin >> v[i];
    }
    
    for(int i=0 ; i<=n-8 ; i++){
        for(int j=0 ; j<=m-8 ; j++){
            MIN = min(MIN, sol(i, j));
        }
    }

    cout << MIN << '\n';
}
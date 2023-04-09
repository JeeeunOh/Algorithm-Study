#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

vector<string> v;
int arr[5][5];
int dy[] = { 0,0,-1,1 };
int dx[] = { -1,1,0,0 };

void sol(int x, int y, string s){
    if(x<0 || y<0 || x>=5 || y>=5) return; // 범위 넘으면 바로 리턴
    s+=to_string(arr[x][y]); // 스트링 추가해주기
    if(s.length()==6) v.push_back(s); // 길이 6이면 벡터에 추가해주기
    else{
        for(int i=0 ; i<4 ; i++){
            sol(x+dx[i], y+dy[i], s);
        }
    }
}

int main(){
    for(int i=0 ; i<5 ; i++){
        for(int j=0 ; j<5 ; j++){
            cin >> arr[i][j];
        }
    }

    for(int i=0 ; i<5 ; i++){
        for(int j=0 ; j<5 ; j++){
             sol(i,j,"");
        }
    }
    
    sort(v.begin(), v.end());
    int count=0;

    for(int i=0 ; i<v.size(); i++){
        if(v[i]!=v[i+1]) {
            count++; 
        }
    }
    cout << count << endl;
}
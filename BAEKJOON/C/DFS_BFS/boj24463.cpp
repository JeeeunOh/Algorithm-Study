#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<char>> arr;
vector<vector<int>> answer;
long long Min = 4100000;
int N, M;

void dfs(int i, int j, vector<vector<int>> temp, long long count){
    temp[i][j]=1;
    count++;
    // 구멍이면 끝내기
    if(i==N-1 || j==M-1 || i==0 || j==0){
        if(count < Min){
            Min=count;
            answer=temp;
        }
        return;
    }
    // 구멍 아니면
    if(temp[i+1][j]!=1 && arr[i+1][j]=='.') dfs(i+1, j, temp, count);
    else if(temp[i-1][j]!=1 && arr[i+1][j]=='.') dfs(i-1, j, temp, count);
    else if(temp[i][j-1]!=1 && arr[i+1][j]=='.') dfs(i, j-1, temp, count);
    else if(temp[i][j+1]!=1 && arr[i+1][j]=='.') dfs(i, j+1, temp, count);
}

int main(){
    cin >> N >> M;
    
    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<M ; j++){
            char a;
            cin >> a;
            arr[i].push_back(a);
        }        
    }

    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<M ; j++){
            vector<vector<int>> temp; // 갔는지 확인하는 배열
            // 가장자리에서 시작
            if(i==N-1 || j==M-1 || i==0 || j==0 && arr[i][j]=='.') dfs(i,j,temp,0);
        }        
    }
    
    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<M ; j++){
            // 미로 구멍일 때
            if(arr[i][j]=='.'){
                // 거쳐가는 길이면 그대로 출력
                if(answer[i][j]==1){
                    cout << '.' ;
                }
                // 거쳐가는 길이 아니면 골뱅이
                else cout << '@';
            } 
            // 미로 구멍이 아닌데
            else cout << '+';
        }
        cout << endl;        
    }

    
}
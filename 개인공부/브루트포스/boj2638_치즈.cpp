#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

vector<vector<int>> v;
int res=0;
int N,M;

int solution(vector<vector<int>> temp){
    int flag=1;
    for(int i=0 ; i<N ; i++){
        vector<int> vv;
        for(int j=0 ; j<M ; j++){ // 치즈가 없는 부분이면
            if(v[i][j]==0) vv.push_back(0);
            else{ // 치즈가 있는 부분이면
                int count=0;
                flag=0;
                if(v[i+1][j]==0) count++;
                if(v[i-1][j]==0) count++;
                if(v[i][j-1]==0) count++;
                if(v[i][j+1]==0) count++;
                
                if(count>=2) vv.push_back(0);  
                else vv.push_back(1);
            }
        }
        temp.push_back(vv);
    }
    // 치즈 녹는 작업 끝나고 치즈 교체
    v=temp;

    return flag;

}

int main(){
    cin >> N >> M;
    for(int i=0 ; i<N ; i++){
        vector<int> vv;
        for(int j=0 ; j<M ; j++){
            int input;
            cin >> input;
            vv.push_back(input);
        }
        v.push_back(vv);
    }

    while(true){
        vector<vector<int>> temp;
        int flag=solution(temp);
        if(flag) break;
        else res++;
    }

    cout << res << endl;
}
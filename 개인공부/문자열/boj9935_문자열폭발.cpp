#include <iostream>
#include <string>
using namespace std;

string input, bomb;
int saveIdx[1000001];

bool solution(){
    bool ans=true; // 터질 것이 없음

    int idx=0; // bomb의 0부터 탐색

    int cur=0;

    for(int i=0 ; i<input.length(); i++){
        if(input[i]==bomb[idx]){ // 문자열 같으면 이어서 탐색
            // 삭제할 문자열 인덱스 저장
            saveIdx[idx]=i;
            idx++;
        } else if (input[i]=='.'){ // 이미 터졌던 문자열이면 패스
            continue;
        } else { // 다른 문자열이면 인덱스 초기화
            idx=0;
            i=cur+1;
            cur=i;
        }

        if(idx==bomb.length()){ // 삭제할 문자열 찾았으면
            ans = false; // 터질 문자열이 있음.
            for(int j=0 ; j<idx; j++){ // 삭제할 인덱스 찾아서 삭제
                input[saveIdx[j]]='.';
            }
            break;
        }
    }

    return ans;
}

int main(){
    
    cin >> input >> bomb;

    while(true){
        bool flag = solution();
        if(flag) break;
    }

    bool flag = true; // 다 터졌다고 가정

    for(int i=0 ; i<input.length(); i++){
        if(input[i]!='.') {
            cout << input[i];
            flag = false;
        }
    }

    if(flag) cout << "FRULA" << '\n';
}
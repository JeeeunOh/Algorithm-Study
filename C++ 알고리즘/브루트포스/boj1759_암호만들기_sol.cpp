#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int l,c; // 암호길이, 문자 수
vector<string> v;
string output[15];
//start : len==l일때, 새로 탐색하기 위해 start+1 뺴고 건들 ㄴ
// temp : 다음 탐색시마다 ++
// len : len==l 일 때 0으로 초기화할 때 뺴고는 탐색시마다 ++
// mo : 현재 탐색값이 모음일때만 ++, 그 외에는 건들 ㄴ

void sol(int len, int temp, int mo, int ja){ // start: 탐색 벡터의 시작, temp : 탐색할 벡터 인덱스, len: 현재 출력배열 길이, mo : 현재까지 모음 수
    if(len==l){
        if( mo!=0 && ja>=2){
            for(int i=0 ; i<l ; i++) cout << output[i] << " "; // 출력하기
            cout << "\n";
        }
        return;
    }
    if(temp==c) return;

    for(int i=temp; i<c ; i++){
        if(v[i]=="a" || v[i]=="e" || v[i]=="i" || v[i]=="o" || v[i]=="u") mo++;
        else ja++;
        output[len] = v[i];
        sol(len+1, temp+1, mo, ja);
    }
}


int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> l >> c;

    for(int i=0 ; i<c ; i++){
        string input;
        cin >> input;
        v.push_back(input);
    }
    sort(v.begin(), v.end()); // 사전순으로 정렬

    //a c i s t w

    sol(0,0,0,0);
}
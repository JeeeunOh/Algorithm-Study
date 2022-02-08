#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int l,c; // 암호길이, 문자 수
vector<string> v;
string output[15];

void sol(int len, int temp, int mo, int ja){ // 출력값길이, 탐색인덱스, 모음, 자음
    if(len==l){ // 출력값 길이가 l이면서
        if( mo!=0 && ja>=2){ // 모음 1개이상 자음 2개이상이면
            for(int i=0 ; i<l ; i++) cout << output[i] << " "; // 출력
            cout << "\n";
        }
        return;
    }
    // 출력값 길이가 l이 아닌데 이미 마지막 문자를 탐색하고 있으면 탐색 멈추기
    if(temp==c) return;

    for(int i=temp; i<c ; i++){
        int moT=mo, jaT=ja;
        if(v[i]=="a" || v[i]=="e" || v[i]=="i" || v[i]=="o" || v[i]=="u") moT++;
        else jaT++;
        output[len] = v[i];
        sol(len+1, i+1, moT, jaT);
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

    //a c i t s w

    sol(0,0,0,0);
}
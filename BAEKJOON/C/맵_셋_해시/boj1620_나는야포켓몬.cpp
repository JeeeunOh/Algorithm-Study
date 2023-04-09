#include <iostream>
#include <map>
#include <string>
using namespace std;

int main(){
    map<int, string> m;
    
    int a,b;
    cin >> a >> b; // 포켓몬 수, 문제의 개수
    for(int i=0 ; i<a ; i++){
        string s;
        cin >> s;
        m[i+1] = s;
    }

    for(int i=0 ; i<b ; i++){
        string s;
        cin >> s;
        int n = stoi(s);
        if(n <=9 && n >=0){ // 키 값으로 접근할 때
            cout << m[n] << '\n';
        } else{ // 데이터 값으로 접근
            for(int j=1 ; j<=a ; j++){
                if(m[j]==s) cout << j << '\n';
            }
        }
    }
}
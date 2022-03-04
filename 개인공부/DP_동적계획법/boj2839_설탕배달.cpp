#include <iostream>
using namespace std;

int main(){
    int N;
    cin >> N;

    int cnt=N/5;

    if(N%5==0){ // 5kg만으로 끝날 때
        cout << cnt << endl;
        return 0;
    }

    for(int i=cnt; i>=0 ; i--){ //3kg 도움까지 받아보자
        int temp=N;
        temp-=5*i; // 5kg짜리 뺌

        if(temp%3==0){ // 3kg의 도움으로 끝날 때
            cout << i+temp/3 << endl;
            return 0;
        }
    }
    // 위에서 결과 안 나옴
    cout << -1 << endl;


}
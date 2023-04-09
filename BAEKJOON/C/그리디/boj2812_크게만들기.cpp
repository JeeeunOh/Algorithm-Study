#include <iostream>
#include <string>
#include <deque>
using namespace std;

int main(){
    int n,k;
    string input;
    cin >> n >> k >> input;

    deque<char> dq;
    int cnt=0;

    for(int i=0 ; i<n ; i++){
        char cur = input[i];
        while(cnt<k && !dq.empty() && dq.back() < cur){
            dq.pop_back();
            cnt++;
        }
        dq.push_back(cur);
    }
    // 덱에 쓸데없는 숫자 남아있을수도 있음.
    // for(int i=0 ; i<dq.size(); i++){
    //     cout << dq[i] ;
    // }
    for(int i=0 ; i<n-k; i++){
        cout << dq[i] ;
    }
    cout << '\n';
}
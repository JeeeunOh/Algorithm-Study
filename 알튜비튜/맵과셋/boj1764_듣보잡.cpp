#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main(){
    int N,M;
    string input;

    cin >> N >> M;

    //듣도 못한 사람 입력 받음
    map<string, int> n;
    for(int i=0 ; i<N ; i++) {
        cin >> input;
        n.insert({input, i});
    }

    // 보도 못한 사람 입력 받고 맵에서 확인
    map<string, int> m;
    for(int i=0 ; i<M ; i++) {
        cin >> input;
        m.insert({input, i});
    }

    int cnt=0;
    vector<string> ans;
    for(const auto & [key, value] : m){
        if(n.find(key)!=n.end()) {
            cnt++;
            ans.push_back(key);
        }
    }

    // 듣보잡 수 출력하고 해당 사람 이름 출력하기

    cout << cnt << endl;
    for(int i=0 ; i<cnt ; i++){
        cout << ans[i] <<endl;
    }

}


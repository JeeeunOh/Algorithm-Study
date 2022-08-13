#include <iostream>
#include <map>
using namespace std;

int main(){
    int n;
    cin >> n;

    map<string, int> front;
    map<int, string> rear;

    for(int i=0 ; i<n ; i++){
        string s;
        cin >> s;
        front.insert({s, i});
    }
    
    for(int i=0 ; i<n ; i++){
        string s;
        cin >> s;
        rear.insert({i, s});
    }

    int res=0;

    for(auto iter : rear){ // 터널 후에 나온 차들 탐색
        int cur = iter.first;
        for(int i=cur+1 ; i<n ; i++){ // 해당 차의 뒤에 나온 차들 다 탐색
            string next = rear[i];
            int frontNext = front[next]; // 뒤에나온차가 터널 전에는 몇 등이었는지
            int frontCur = front[iter.second]; // 자신은 터널 전에 몇 등이었는지
            if(frontNext < frontCur) { // 원래 (자신 앞에 있던 차였으면 == 추월했으면) ++ 해주기
                res++;
                break;
            }
        }
    }

    cout << res << '\n';
}
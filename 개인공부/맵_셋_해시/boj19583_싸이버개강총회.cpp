#include <iostream>
#include <string>
#include <map>
#include <set>
using namespace std;

int main(){
    int res=0;
    string S,E,Q,time,name;
    map<string, int> start;

    cin >> S >> E >> Q;
    while(cin >> time >> name){
        // 개강총회 시작하기 전 출석
        if(time<=S) start[name]=1;

        // 개강총회 끝내고 출석한 사람 중에
        // 시작하기 전에도 출석한 사람이면 res++
        else if(time>=E && time<=Q) {
            if(start[name]==1) {
                res++;
                start[name]=0;
            }
        }
    }

    cout << res << '\n';
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <deque>
using namespace std;

int main() {
    int n,t;
    cin >> t;

    while (t--) {
        string order,str,s = "";
        bool reverse=false, error=false;
        deque<int> dq;

        cin >> order >> n >> str;

        for (int i = 0 ; i<str.length() ; i++) {
            if (isdigit(str[i])) {
                s += str[i];
            } else {
                if (!s.empty()) {
                    dq.push_back(stoi(s));
                    s = "";
                }
            }
        }

        for (auto o : order) {
            if (o == 'R') {
                if (reverse) reverse = false;
                else reverse = true;
            }
            else {
                if (dq.empty()) {
                    cout << "error" << '\n';
                    error = true;
                    break;
                }
                if (reverse) dq.pop_back();
                else dq.pop_front();
            }
        }

        if (!error) cout << '['; 

        if (reverse && !dq.empty()) {
            for (auto o = dq.rbegin(); o != dq.rend(); o++) {
                if (o == dq.rend() - 1)
                    cout << *o;
                else
                cout << *o << ',';
            }
        }
        else if (!reverse&&!dq.empty()){
            for (auto o = dq.begin(); o != dq.end(); o++) {
                if (o == dq.end() - 1)
                    cout << *o;
                else
                cout << *o << ',';
            }
        }
        if(!error) cout <<"]\n";
    }
}
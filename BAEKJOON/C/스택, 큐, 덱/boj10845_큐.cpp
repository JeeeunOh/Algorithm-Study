#include <iostream>
#include <queue>

using namespace std;

int main(){
    queue<int> q;
    int n, num;
    string input;
    cin >> n;
    while(n--){
        cin >> input;
        if(input=="push"){
            cin >> num;
            q.push(num);
        } else if(input=="pop"){
            if(q.empty()) cout << -1 << endl;
            else {
                cout << q.front() << endl;
                q.pop();
            }
        } else if(input=="size") cout << q.size() << endl;
        else if(input=="empty") {
            if (q.empty()) cout << 1 << endl;
            else cout << 0 << endl;
        } else if(input=="front"){
            if (q.empty()) cout << -1 << endl;
            else cout << q.front() << endl;
        } else if(input=="back"){
            if (q.empty()) cout << -1 << endl;
            else cout << q.back() << endl;
        }

    }
}
#include <iostream>
#include <stack>

using namespace std;

int main(){
    int n, num;
    string input;
    cin >> n;
    stack<int> s;
    while(n--){
        cin >> input;
        if(input=="push"){
            cin >> num;
            s.push(num);
        } else if(input=="pop") {
            if(s.empty()) cout << -1 << endl;
            else {
                cout << s.top() << endl;
                s.pop();
            }
        }
        else if(input=="size") cout << s.size() << endl;
        else if(input=="empty"){
            if(s.empty()) cout << 1 << endl;
            else cout << 0 << endl;
        }
        else if(input=="top") {
            if(s.empty()) cout << -1 << endl;
            else cout << s.top() << endl;
        }
    }

}
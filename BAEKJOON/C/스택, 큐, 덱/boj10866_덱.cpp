#include <deque>
#include <iostream>

using namespace std;

deque<int> d;

int main(){

    string input="";
    int num;
    int n; cin >> n;

    while(n--){
        cin >> input;
        if(input=="push_front"){
            cin >> num;
            d.push_front(num);
        } else if(input=="push_back"){
            cin >> num;
            d.push_back(num);
        } else if(input=="pop_front"){
            if(d.empty()) cout << -1 << endl;
            else{
                cout << d.front() << endl;
                d.pop_front();
            }
        } else if(input=="pop_back"){
            if(d.empty()) cout << -1 << endl;
            else{
                cout << d.back() << endl;
                d.pop_back();
            }
        } else if(input=="size") cout << d.size() << endl;
        else if(input=="empty"){
            if(d.empty()) cout << 1 << endl;
            else cout << 0 << endl;
        } else if(input=="front") {
            if(d.empty()) cout << -1 << endl;
            else cout << d.front() << endl;
        }
        else if (input=="back") {
            if(d.empty()) cout << -1 << endl;
            else cout << d.back() << endl;
        }
    }

}

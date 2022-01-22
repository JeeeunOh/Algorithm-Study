#include <iostream>
#include <map>
#include <string>
#include <set>

using namespace std;

int main(){
    int n,m;
    set<string> never_heard, ans;
    string input;

    cin >> n >> m;

    while(n--){
        cin >> input;
        never_heard.insert(input);
    }

    while(m--){
        cin >> input;
        if(never_heard.find(input)!=never_heard.end()) ans.insert(input);
    }

    cout << ans.size() << '\n';
    for(auto iter = ans.begin(); iter!=ans.end(); iter++) cout << *iter << '\n';
}
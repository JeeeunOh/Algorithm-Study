#include <iostream>
#include <string>
using namespace std;

int main()
{
    string s;
    int cnt = 1;
    getline(cin, s);
    if (s.empty()) {
        cout << "0";
        return 0;
    }
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == ' ') cnt++;
    }
    if (s[0] == ' ') cnt--;
    if (s[s.length() - 1] == ' ') cnt--;
    cout << cnt << endl;
}
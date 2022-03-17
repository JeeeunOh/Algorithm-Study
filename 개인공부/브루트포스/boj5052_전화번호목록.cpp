//백준5052 전화번호 목록
 
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;
 
int main() {
    int t;
    cin >> t;
    
    vector<string> phoneVec;
    
    while(t--) {
        int n;
        bool flag = true;
        
        cin >> n;
        
        for (int j = 0; j < n; j++) {
            string phone;
            cin >> phone;
            phoneVec.push_back(phone);
        }
 
        sort(phoneVec.begin(), phoneVec.end());
 
        for (int k = 0; k <= phoneVec.size()-2; k++) {
            int currentLen = phoneVec[k].length();
            int nextLen = phoneVec[k+1].length();
 
            if (currentLen >= nextLen) continue; 
 
            if (phoneVec[k + 1].substr(0, currentLen)== phoneVec[k]) {
                flag = false;
                cout << "NO" << endl;
                break;
            }
        }
 
        if (flag) cout << "YES" << endl; 
 
        phoneVec.clear();
    }
}

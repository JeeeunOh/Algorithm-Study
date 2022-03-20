#include <iostream>
#include <string>
using namespace std;

int main(){
    int t;
    cin >> t;

    while(t--){
        int n;
        string s;
        cin >> n >> s;
        
        for(int i=0 ; i<s.length(); i++){
            int temp=n;
            while(temp--){
                cout << s[i];
            }
        }
        cout << endl;
    }
}
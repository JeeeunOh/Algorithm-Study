#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

bool compare(string a, string b){
    if(a.length()>=b.length()) return a<b;
    else return a>b;
}

int main(){
    int t;
    cin >> t;

    while(t--){
        int num;
        string ans = "YES";
        cin >> num;
        vector<string> v(10001);

        for(int i=0 ; i<num ; i++){
            cin >> v[i];
        }
        
        // 짧은 순서대로 정렬
        sort(v.begin(), v.end(), compare);

        for(int i=0 ; i<num-1; i++){
            int len = v[i].length();
            for(int j=i+1 ; j<num ; j++){
                if(v[i] == v[j].substr(0, len)){
                    ans = "NO";
                    break;
                }
            }
        }

        cout << ans << '\n';

    }

}
#include <iostream>
#include <map>
using namespace std;

int main(){
    int n,t;
    string a,b; // 의상의 이름 , 종류
    cin >> n;

    while(n--){
        cin >> t;
        map<string, int> m;

        while(t--){
            cin >> a >> b;
            //해당 옷의 종류가 있으면 가짓수 추가하고
            m[b]++;
        }
        int cnt=1;
        for(auto iter: m)
            cnt*=(iter.second +1);
        cout << cnt-1 << endl;
    }
}
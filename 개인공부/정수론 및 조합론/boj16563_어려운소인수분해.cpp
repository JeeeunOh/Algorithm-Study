#include <iostream>
#include <vector>
using namespace std;
#define MAX 5000001

int main(){
    // 입출력 속도 향상
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> prime(MAX + 1, 0);
    vector<int> v;
    //0이면 소수, 1이면 소수가 아님

    for(int i=2 ; i<MAX; i++){
        if(prime[i]!=1){
            int mul=2;
            v.push_back(i); // i는 소수이다.
            while(true){
                if(i*mul<MAX) prime[i*mul]=1;
                else break;
                mul++;
            }
        }
    }

    int n;
    cin >> n;
    while(n--){
        int t;
        cin >> t;
        while(t>1){
            for(int i=0 ;i<v.size(); i++){
                if(t%v[i]==0){
                    cout << v[i] << " ";
                    t/=v[i];
                    i--;
                }
                if(t<=1) break;
            }
        }
        cout << '\n';
    }
}
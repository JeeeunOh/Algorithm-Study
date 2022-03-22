#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
// 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
// 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.

vector<string> v;

bool gitar(string a, string b){
    if(a.length()!=b.length()){ // 스트링 길이 다르면
        return a.length()<b.length(); // a가 더 길면 a를 뒤로
    } else { // 스트링 길이 같으면
        int sumA=0, sumB=0;
        for(int i=0 ; i<a.length(); i++){
            if(a[i]-'0'>0 || a[i]-'0'<=9) sumA+=a[i]-'0';
        }
        for(int i=0 ; i<b.length(); i++){
            if(b[i]-'0'>0 || b[i]-'0'<=9) sumB+=b[i]-'0';
        } // 합 구해서

        if(sumA!=sumB){ // 합을 비교해서 작은게 앞으로
            return sumA < sumB;
        } else{ // 합 같으면 사전순으로
            return a<b;
        }
    }

}

int main(){
    int n;
    cin >> n;

    for(int i=0 ; i<n ; i++){
        string s;
        cin >> s;
        v.push_back(s);
    }

    sort(v.begin(), v.end(), gitar);

    for(int i=0 ; i<n ; i++){
        cout << v[i] << '\n';
    }
}
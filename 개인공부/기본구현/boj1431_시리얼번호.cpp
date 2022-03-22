#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<string> v;

bool compare(string a, string b){
    if(a.length()!=b.length()){ // 스트링 길이 다르면
        return a.length()>b.length()? a>b : b>a; // a가 더 길면 a를 뒤로
    } else { // 스트링 길이 같으면
        int sumA=0, sumB=0;
        for(int i=0 ; i<a.length(); i++){
            if(a[i]-'0'>0 || a[i]-'0'<=9) sumA+=a[i]-'0';
        }
        for(int i=0 ; i<b.length(); i++){
            if(b[i]-'0'>0 || b[i]-'0'<=9) sumB+=b[i]-'0';
        }

        if(sumA!=sumB){ // 합을 비교해서 작은게 앞으로
            return sumA>sumB? a>b : b>a;
        } else{ // 합 같으면 사전순으로
            return a>b? a>b : b>a;
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

    sort(v.begin(), v.end(), compare);

    for(int i=0 ; i<n ; i++){
        cout << v[i] << '\n';
    }
}
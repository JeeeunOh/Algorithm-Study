#include<iostream>
#include<algorithm>
#include<string>
using namespace std;


int n,m[26],i,j,p;
string s;

int main(){
    cin >> n;
    for(i=0;i<n;i++){
        cin >> s;
        for(p=1,j=s.length()-1; j+1; j--,p*=10){
            m[s[j]-'A']+=p;
        }
    }

    sort(m,m+26);

    for(p=9,j=0,i=25; m[i]; i--,p--){
        j+=p*m[i];
    }
    cout << j;
}
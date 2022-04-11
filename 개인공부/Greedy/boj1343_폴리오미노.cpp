#include <iostream>
#include <string>
using namespace std;

int main(){
    string s, ans="";
    cin >> s;
    int num=0;
    int arr[55];
    if(s[0]=='X') {
        num=1;
        arr[0]=1;
    }
    else arr[0]=0;

    for(int i=1 ; i<s.length(); i++){
        if(s[i]=='X') arr[i]=++num; // x 받았을 때
        else{ // . 받았을 때
            num=0;
            arr[i]=0;
        }
    }
    for(int i=0 ; i<s.length(); i++){
        if(s[i]=='.') ans+='.';
        else{ // X일 때
            if(s[i+1]=='.'){
                if (arr[i]%2!=0){ // 홀수면 바로 반환
                    cout << -1 << '\n';
                    return 0;
                } else { // 짝수개 있으면
                    int num4 = arr[i]/4;
                    int num2 = arr[i]%4/2;
                    for(int j=0 ; j<num4 ; j++){
                        ans+="AAAA";
                    }
                    for(int j=0 ; j<num2 ; j++){
                        ans+="BB";
                    }
                }
            }
        }
    }

    cout << ans << endl;
}
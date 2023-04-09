#include <iostream>
#include <string>
using namespace std;

string s,bomb,answer = "";

int main() {
    cin >> s >> bomb;

    int bombIdx = bomb.length()-1;

    for(int i = 0; i < s.length(); i++){
        answer += s[i]; // 일단 들어오는 건 다 더하기
        int ansLen = answer.length();

        if(answer[ansLen-1] == bomb[bombIdx]){ // 현재 문자열이 폭탄의 마지막 문자열과 같고
            if(ansLen >= bomb.length()){ // 현재까지 저장된 문자열이 폭탄 문자열보다 길다면

                int cnt = 1;
            
                for(int j = bombIdx-1; j >= 0; j--){ // 거꾸로 돌아가면서 폭탄과 같은 문자열 있을 때마다 cnt++
                    if(answer[ansLen- (bombIdx-j)-1] == bomb[j]) cnt++;
                }

                if(bomb.length() == cnt){ // 폭탄만큼 문자열 지워야한다면
                    for(int b = 0; b < bomb.length(); b++){ // 뒤에서부터 다 지우기
                        answer.pop_back();
                    }
                }
            }
        }
    }
    
    if(answer.length()>0) cout<<answer<<endl; 
    else cout<<"FRULA"<<endl;

	return 0;
}
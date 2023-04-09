#include <iostream>
#include <string>
using namespace std;

int main(){
    string input, output;
    bool tag = false;
    getline(cin, input);

    for(int i=0 ; i<input.length(); i++){
        if(input[i]=='<') { // 태그 시작
            tag=true;
            output+='<';
        } else if(input[i]=='>') { // 태그 끝
            tag=false;
            output+='>';
        } else if(input[i]==' ' || tag){ // 공백이거나 태그 내용일 때
            output+=input[i];
        } else { // 대칭으로 바꿔주기!
            int index;
            for(index=i ; index<input.length(); index++){
                // 어디까지 대칭으로 바꿔줘야하는지 체크하기
                if(input[index]==' ' || input[index]=='<') break;
            }
            // 대칭으로 바꿔주기 작업!
            for(int j=index-1; j>=i ; j--){
                output+=input[j];
            }
            // index 지점까지는 작업 끝냈으므로 작업 포인트 옮겨주기
            i=index-1;
        }
    }
    
    cout << output << '\n';
}
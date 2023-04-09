#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    string a,b;
    string input;
    int num[26]={3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    int last[5000], temp[5000]; // 계산할 숫자, 계산한 숫자 담기
    cin >> a >> b;

    // 계산할 스트링에 a,b 이름 순서대로 집어넣기
    for(int i=0 ; i<a.length() ; i++){
        input+=a[i];
        input+=b[i];
    }

    int size=input.length();

    for(int i=0 ; i<size; i++){
        last[i]=input[i]-'A'; // 알파벳을 숫자로 변환
        last[i]=num[last[i]]; // 숫자 바탕으로 획찾아 저장
    }
    
    while(true){
        size--; // 매 단계 시행시마다 배열 크기 하나씩 줄여줌

        for(int i=0; i<size ; i++){
            temp[i]=(last[i]+last[i+1])%10; // 항시 한자리수로 유지
        }

        copy(temp, temp+size, last); // last 재설정
        
        if(size==2) break;
    }

    cout << temp[0] << temp[1] << '\n';
}
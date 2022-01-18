#include <iostream>
#include <vector>
using namespace std;

int main(){
    string A={'b','p','q','d','i','o','v','w','x'};

    string input="입력";

    while(true){
        cin >> input;
        if(input=="#") break;
        vector<char> output; // input 받을 때마다 output 재설정해줌

        for(int i=input.length()-1 ; i>=0; i--){ // input을 제일 뒤에서부터 탐색해서 output의 처음부터 정함
            int flag=0; // 해당 글씨가 거울로 표현이 가능하지 않는다고 가정
            for(int j=0 ; j<9 ; j++){ // 거울표현이 가능한 배열 A를 처음부터 탐색
                if(input[i]==A[j] && j<=3) { //현재 탐색값이 b,p,q,d 중에 있다면
                    output.push_back(A[3-j]);
                    flag=1; // 거울로 표현가능하다고 표시
                    break;
                } else if(input[i]==A[j] && j>=4) { // 현재 탐색값이 i,o,v,w 중에 있다면
                    output.push_back(A[j]); // 해당 값 그대로 output에 넣기
                    flag=1; // 거울로 표현가능하다고 표시
                    break;
                }
            }
            if(flag==0) { // 현재 input을 여전히 겨울로 탐색할 수 없다면
                cout << "INVALID" <<endl;
                break; // 해당 글자탐색 멈춤
            }
            if(i==0){ // 해당 글자 끝까지 다 탐색한 후에
                for(int k=0 ; k<output.size(); k++) cout << output[k];
                cout << endl;
            }
        }
    }
}

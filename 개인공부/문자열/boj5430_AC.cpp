#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    int t;
    cin >> t;

    while(t--){
        string commend, input;
        int num;

        cin >> commend >> num >> input;

        vector<int> v;

        bool success = true;
        
        // 배열에 숫자 넣는 과정
        for(int i=0 ; i<input.length(); i++){
            if(input[i]-'0'>=1 && input[i]-'0'<=100){
                v.push_back(input[i]-'0');
            }
        }
        // 명령어 실행
        for(int i=0 ; i<commend.length(); i++){
            char cur = commend[i];

            if(cur=='D'){
                if(num<=0){
                    success = false;
                    break;
                }
                for(int i=0 ; i<num; i++){
                    v[i]=v[i+1];
                    // 맨 앞 하나 삭제 -> 한 칸씩 앞으로 당기기
                }
                num--;
            } else if (cur=='R'){
                for(int i=0 ; i<=(num-1)/2 ; i++){
                    cout << i << "  " << v[i] << "  "<< v[num-i] << '\n';
                    int temp = v[i];
                    v[i] = v[num-i];
                    v[num-i] = temp;
                    cout << i << "  " << v[i] << "  "<< v[num-i] << '\n';
                }
                // for(int i=0 ; i<num ; i++){
                //     cout << v[i] << " ";
                // }
                cout << '\n';
            }
        }

        if(success){
            cout << "[" ;
            for(int i=0 ; i<num; i++){
                cout << v[i] ;
                if(i!=num-1){
                    cout << "," ;
                }
            }
            cout << "]" <<'\n';
        } else {
            cout << "error" << '\n';
        }

    }
}
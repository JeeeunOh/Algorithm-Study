#include <iostream>
#include <string>

/*
stoi = string to int
stof = string to float
stol = string to long
stod = string to double
*/

using namespace std;

string str;

int minResult(void){

    int result = 0;
    string temp = ""; // temp는 숫자 모음
    bool minus = false;

    for (int i = 0; i <= str.size(); i++){
        //연산자일 경우
        if (str[i] == '+' || str[i] == '-' || str[i] == '\0') {

            if (minus) result -= stoi(temp); // 앞에 마이너스가 있을경우
            else result += stoi(temp); // 앞이 플러스일 경우 더해줌

            temp = ""; //초기화

            //괄호를 뺄셈 이후에 치면 최소

            if (str[i] == '-') minus = true; // 앞에 마이너스 있으면 마이너스 bol을 true로 만들어줌

            continue;

        }
        //피연산자일 경우
        temp += str[i];
    }
    return result;
}


int main(void){
    cin >> str; // str받고
    cout << minResult() << endl; // 계산함
    return 0;
}
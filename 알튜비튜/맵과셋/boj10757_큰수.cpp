#include <iostream>
#include <stack>

using namespace std;

//A + B 함수, 일의 자릿수부터 더함
stack<int> calcPlus(string &a, string &b) {
    stack<int> st;
    int p1 = a.length() - 1; //a의 일의 자릿수 인덱스
    int p2 = b.length() - 1; //b의 일의 자릿수 인덱스
    bool carry = false; //올림 체크 변수

    while (p1 >= 0 && p2 >= 0) { //자릿수 더하기
        int num = (a[p1--] - '0') + (b[p2--] - '0'); //a와 b의 각 자릿수 값 더하기
        if (carry) //전 자릿수에서 올림되었다면
            num += 1;
        carry = num / 10;  //자릿수 더한 값이 10을 넘으면 올림변수 체크
        st.push(num % 10); //올림값 제외한 값만 스택에 저장
    }
    while (p1 >= 0) { //a에서 남은 숫자 반영
        int num = (a[p1--] - '0'); //a의 해당 자릿수 값
        if (carry) //전 자릿수에서 올림되었다면
            num += 1;
        carry = num / 10;  //값이 10을 넘으면 올림변수 체크
        st.push(num % 10); //올림값 제외한 값만 스택에 저장
    }
    while (p2 >= 0) { //b에서 남은 숫자 반영
        int num = (b[p2--] - '0'); //b의 해당 자릿수 값
        if (carry) //전 자릿수에서 올림되었다면
            num += 1;
        carry = num / 10;  //값이 10을 넘으면 올림변수 체크
        st.push(num % 10); //올림값 제외한 값만 스택에 저장
    }
    if (carry) //마지막 올림 확인
        st.push(1);

    return st;
}

int main() {
    string a, b; //입력 수가 매우 크므로 string 으로 입력
    stack<int> st; //더한 결과값 저장할 스택

    //입력
    cin >> a >> b;

    //연산
    st = calcPlus(a, b);

    //출력
    while (!st.empty()) {
        cout << st.top();
        st.pop();
    }
    cout << '\n';

    return 0;
}
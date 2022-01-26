#include <iostream>
#include <stack>

using namespace std;

//연산자 우선순위 리턴하는 함수
int priority(char ch) {
    switch (ch) {
        case '*': case '/': return 1;
        case '+': case '-': return 2;
        case '(': case ')': return 3;
    }
}

//중위 표기식->후위표기식 함수
string infixToPostfix(string &s) {
    stack<char> st;
    string answer = ""; //후위표기식

    for (int i = 0; i < s.length(); i++) {
        switch (s[i]) {
            case '(': //'('일 경우
                st.push(s[i]);
                break;
            case ')': //')'일 경우
                while (!st.empty() && st.top() != '(') { //스택의 top 값이 '(' 일때까지 답에 연산자 추가
                    answer += st.top();
                    st.pop();
                }
                st.pop(); //'(' 제거
                break;
            case '*': case '/': case '+': case '-': //연산자일 경우
                //현재 연산자의 우선순위와 같거나 더 높다면 스택에서 값을 꺼내 답에 추가
                while (!st.empty() && priority(st.top()) <= priority(s[i])) {
                    answer += st.top();
                    st.pop();
                }
                st.push(s[i]);
                break;
            default: //피연산자라면 답에 무조건 추가
                answer += s[i];
                break;
        }
    }

    //스택에 연산자가 남아있다면 추가
    while (!st.empty()) {
        answer += st.top();
        st.pop();
    }

    return answer;
}

int main() {
    string s; //입력(중위표기식)

    cin >> s;
    cout << infixToPostfix(s) << '\n';

    return 0;
}
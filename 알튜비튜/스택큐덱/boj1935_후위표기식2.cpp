#include <iostream>
#include <vector>
#include <stack>

using namespace std;

double calc(vector<double> num, char op) {
    switch (op) {
        case '+': return num[0] + num[1];
        case '-': return num[0] - num[1];
        case '*': return num[0] * num[1];
        case '/': return num[0] / num[1];
    }
}

double postfix(string expression, vector<double> &operand) {
    stack<double> s;

    for (int i = 0; i < expression.size(); i++) {
        if (isupper(expression[i])) {
            s.push(operand[expression[i] - 'A']);
            continue;
        }
        vector<double> num(2);
        for (int j = 1; j >= 0; j--) { //피연산자 2개 pop 하기 (인덱스 중요!)
            num[j] = s.top(); s.pop();
        }
        s.push(calc(num, expression[i])); //계산하고 그 결과 다시 스택에 넣기
    }
    return s.top();
}

int main() {
    vector<double> operand(26);
    string expression;
    int n;
    // 입력
    cin >> n >> expression;
    for (int i = 0; i < n; i++) cin >> operand[i];
    // 출력
    cout << fixed;
    cout.precision(2);
    cout << postfix(expression, operand);
}
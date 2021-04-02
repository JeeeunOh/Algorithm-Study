#include <stack>
#include <iostream>
#include <string>
using namespace std;

int main() {
	for (int i = 1; 1; i++) { //무한루프 돌리기
		string s; //주어진 문자열
		int cnt = 0; //총 연산횟수
		stack<char> stk; //문자열의 문자를 넣는 스택
		cin >> s;
		if (s[0] == '-') { //-를 만나면
			break; //턀출
		}
		for (unsigned int i = 0; i < s.size(); i++) { //문자열의 모든 문자를 탐색
			if (stk.size() == 0 && s[i] == '}') { //스택이 비어있는 상태에서 }를 만나면
				cnt++; //갯수를 늘리고
				s[i] == '{'; //}를 {로 바꾸고
				stk.push(s[i]); //스택에 넣는다.
			}
			else if (stk.size() != 0 && s[i] == '}') { //스택에 비어있지 않고 }를 만나면
				stk.pop(); //스택에서 팝
			}
			else { //{가 있으면
				stk.push(s[i]); //스택에 넣는다.
			}
		}
		cnt = cnt + stk.size() / 2; //남아있는 스택 크기에 반을 현재 cnt결과에 더한다.
		cout << i << ". " << cnt << '\n';
	}
}
#include <iostream>

using namespace std;

int main() {
	string s;
	int a[27] = { 0 };

	cin >> s; // 문자열 입력 string으로 받음

	for (int i = 0; i < s.length(); i++) { // 스트링 길이만큼 for문
		if (s[i] >= 97) { // 스트링에서 배열로 넘어가서 계산 가능
			s[i] = s[i] - 32; //대문자이면 32 빼줌
		}
		a[s[i] - 65]++; // 그게 아니면 65빼주고 계산
	}

	int max = 0;
	int index;
	int cnt = 0;

	for (int i = 0; i < 26; i++) {
		if (max < a[i]) {
			max = a[i];
			index = i;
		}
	}

	for (int i = 0; i < 26; i++) {
		if (i != index) {
			if (max == a[i]) cnt++;
		}
	}

	if (cnt != 0) {
		cout << "?\n";
	}
	else {
		cout << (char)(index + 65) << "\n";
	}

	return 0;
}
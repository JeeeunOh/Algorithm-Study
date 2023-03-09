#include <string>
#include <vector>
#include <set> // set 이용
using namespace std;

set<string> dfs(int b, bool* visited, set<string> s, vector<string>
	user_id, vector<string> banned_id) {
	if (b == banned_id.size()) {
		string str = "";
		for (int i = 0; i < user_id.size(); i++) {
			if (visited[i]) str += i; // 문자열 조합을 만듭니다.
		}
		s.insert(str); // 중복되지 않게 문자열 조합을 저장합니다.
		return s;
	}
	for (int i = 0; i < user_id.size(); i++) {
		if (visited[i]) continue; // 이미 제재된 아이디 제외합니다.
		if (user_id[i].size() != banned_id[b].size()) continue; // 문자열의 길이가 다르면 제외
		bool temp = true;
		for (int j = 0; j < user_id[i].size(); j++) {
			if ((user_id[i][j] == banned_id[b][j]) || (banned_id[b][j] == '*'))
				continue;
			else { // 한 문자라도 서로 다르거나 ‘*’가 아닐 때
				temp = false;
				break;
			}
		}
		if (temp == true) { // 제재 사용자에 포함되는 아이디일 때
			visited[i] = true; // 문자열 사용했음을 표시합니다.
			s = dfs(b + 1, visited, s, user_id, banned_id);
			visited[i] = false; // 문자열 사용 표시를 해제합니다.
		}
	}
	return s;
}

int solution(vector<string> user_id, vector<string> banned_id) {
	int answer = 0;
	set<string> s; // 문자열 조합을 저장할 집합
	bool visited[8] = { false, }; // 문자열 사용 표시를 저장할 배열
	s = dfs(0, visited, s, user_id, banned_id);
	answer = s.size(); // 문자열 조합의 개수를 저장합니다.
	return answer;
}
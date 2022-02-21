#include <string>
#include <vector>
using namespace std;

vector<string> solution(vector<string> s) {
	vector<string> ans;
	int cnt = 0;
	if (s[0] == "1") ans.push_back("1");
	for (int i = 0; i < s.size()-1; i++) {
		if (s[i] == s[i + 1]) cnt++;
		else {
			ans.push_back("A" + cnt);
			cnt = 0;
		}
	}
	ans.push_back("A" + cnt);
	return ans;
}


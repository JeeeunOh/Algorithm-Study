#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool cmp(pair<int,char> a, pair<int,char> b) {
	return a.first > b.first;
}

int main() {
	int t;
	cin >> t;
	cin.ignore();

	while (t--) {
		string sen;
		getline(cin, sen);
		pair<int, char> alpha[26] = { {0,' '} };

		for (int i = 0; i < sen.length(); i++) {
			if (isspace(sen[i])) continue;
			alpha[sen[i] - 'a'] = { alpha[sen[i] - 'a'].first+1,sen[i] };
		}

		sort(alpha, alpha + 26, cmp);

		if (alpha[0].first != alpha[1].first)
			cout << alpha[0].second<<'\n'; 
		else 
            cout << '?' << '\n'; 
	}
	return 0;
}
#include <vector>
#include <string>
using namespace std;

vector<string> solution(int r, int c, int zr, int zc, vector<string> words) {
	vector<string> answer;
	string temp;
	for (int i = 0; i < r; i++) {
		temp = "";
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < zc; k++) {
				temp += words[i][j];
			}
		}
		for (int j = 0; j < zr; j++) {
			answer.push_back(temp);
		}
	}
	return answer;
}
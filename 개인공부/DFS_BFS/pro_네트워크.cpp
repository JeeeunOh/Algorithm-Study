#include <vector>
using namespace std;
 
bool dfs(vector<vector<int>>& computers, int n) {
    // 두 컴퓨터가 연결되어있지 않으면 그대로 리턴
    if (!computers[n][n]) return false;
    // 연결되어 있다면, 일단 연결 끊고
    computers[n][n] = 0;
    // 연결되어 있는 다른 컴퓨터들과의 관계 dfs 시작
    for (int i = 0; i < computers.size(); i++) {
        if (computers[n][i])    dfs(computers, i);
    }
    return true;
}
 
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
        if (computers[i][i] && dfs(computers, i)) answer++;
    }
    return answer;
}
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
 
vector<vector<string>> answerlist;
 
void dfs(vector<vector<string>>& tickets, vector<pair<int, int>>& useCheck, string from, int count) {
    //리턴조건 티켓을 모두다 사용했다면
    if (count == tickets.size()) {
        //정답후보 생성
        vector<string> answer;
        //기존 내용이 바뀌면 안되기때문에 임시로 하나 생성 후 정렬
        vector<pair<int, int>> temp = useCheck;
        sort(temp.begin(), temp.end());
        //순서대로 정답에추가
        for (auto a : temp)        answer.push_back(tickets[a.second][0]);
        //마지막 행성지는 따로 추가해줌
        answer.push_back(tickets[temp[temp.size() - 1].second][1]);
        //정답리스트에 추가하고 리턴
        answerlist.push_back(answer);
        return;
    }
    for (int i = 0; i < tickets.size(); i++) {
        //사용을 안한티켓이고 행선지가 같을때
        if (useCheck[i].second == -1 && tickets[i][0] == from) {
            //사용했다고 변경하고
            useCheck[i] = { count, i };
            //재귀함
            dfs(tickets, useCheck, tickets[i][1], count + 1);
            //사용을 다했으면 사용했다는 내용 삭제
            useCheck[i] = { 0, -1 };
        }
    }
}
 
vector<string> solution(vector<vector<string>> tickets) {
    //사용여부를 관리할 임시변수 (순서, 인덱스번호)
    vector<pair<int, int>> useCheck(tickets.size(), { 0 , -1 });
    //처음은 ICN에서 출발해야 한다.
    dfs(tickets, useCheck, "ICN", 0);
    //알파벳 순으로 반환해야 하기때문에 정렬
    sort(answerlist.begin(), answerlist.end());
    //제일 앞에있는것이 알파벳 순으로 정렬된 것이다.
    return answerlist[0];
}
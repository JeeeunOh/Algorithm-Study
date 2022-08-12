#include <string>
#include <vector>
#include <map>
using namespace std;
 
vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    map<string, int> music;
    map<string, map<int, int>> musiclist;
    for (int i = 0; i < genres.size(); i++) {
        music[genres[i]] += plays[i];
        musiclist[genres[i]][i] = plays[i];
    }
    
    //장르가 다없어질때까지 반복
    while (music.size() > 0) {
        string genre{};
        int max{0};
        for (auto mu : music){
            if (max < mu.second){
                max = mu.second;
                genre = mu.first;
            }
        }
        for (int i = 0; i < 2; i++){
            int val = 0, ind = -1;
            for (auto ml : musiclist[genre]) {
                if (val < ml.second) {
                    val = ml.second;
                    ind = ml.first;
                }
            }
            if (ind == -1)    break;
            answer.push_back(ind);
            musiclist[genre].erase(ind);
        }
        music.erase(genre);
    }
    return answer;
}
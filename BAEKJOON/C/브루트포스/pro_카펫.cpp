#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int m=1, n=1;
    
    while(true){
        if((m-2)*(brown-2*m)==2*yellow){
            n=(brown-2*m+4)/2;
            break;
        }
        else m++;
    }
    answer.push_back(n);
    answer.push_back(m);
    return answer;
    
    // 가로 m 세로 n 일 때, 
    // 브라운은 m*2 + n*2 - 4 = ?
    // 노랑색은 (m-2)*(n-2)
}
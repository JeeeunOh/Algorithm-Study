#include <string>
#include <vector>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    
    for(int i=0 ; i<phone_book.size(); i++){
        for(int j=0 ; j< phone_book.size(); j++){
            if(i==j) continue;
            string a = phone_book[i];
            string b = phone_book[j];
            int len = a.length();
            int idx=0;
            for(int k=0 ; k<b.length(); k++){
                if(a[idx]==b[k]) idx++;
                else break;
                if(idx==len) return false;
            }
        }
    }
    
    return answer;
}
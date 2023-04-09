#include <iostream>
#include <deque>
using namespace std;

int n,m, dodoScore=0, suScore=0;
deque<int> dodo; // 가장 최근에 넣은카드를 뺄 수 있음.
deque<int> dodoG; // 처음에 넣은 카드부터 뺄 수 있음.
deque<int> su;
deque<int> suG;

void suWin(){
    suScore++;
    while(true){
        if(dodoG.empty()) break;
        su.push_front(dodoG[0]);
        dodoG.pop_front();
    }

    while(true){
        if(suG.empty()) break;
        su.push_front(suG[0]);
        suG.pop_front();
    }

}
void doWin(){
    dodoScore++;
    while(true){
        if(suG.empty()) break;
        dodo.push_front(suG[0]);
        suG.pop_front();
    }
    while(true){
        if(dodoG.empty()) break;
        dodo.push_front(dodoG[0]);
        dodoG.pop_front();
    }

}

int main(){
    cin >> n >> m;

    while(n--){
        int a,b;
        cin >> a >> b;
        dodo.push_front(a);
        su.push_front(b);
    }

    for(int i=0 ; i<m ; i++){
        if(i%2==0){ // 도도차례
            dodoG.push_back(dodo[dodo.size()-1]);
            dodo.pop_back();
        } else { // 수연이 차례
            suG.push_back(su[su.size()-1]);
            su.pop_back();
        }

        if(dodoG[dodoG.size()-1]==5 || suG[suG.size()-1]==5 ) doWin();
        if(!dodoG.empty() && !suG.empty() &&  dodoG[dodoG.size()-1] + suG[suG.size()-1] == 5 ) suWin();
    }

    if(dodoScore > suScore) cout << "do" << '\n';
    else if(dodoScore < suScore) cout << "su" << '\n';
    else if(dodoScore == suScore) cout << "dosu" << '\n';
}
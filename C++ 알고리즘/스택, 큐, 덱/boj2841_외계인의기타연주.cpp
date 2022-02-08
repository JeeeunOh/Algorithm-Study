#include <iostream>
#include <stack>
using namespace std;

// 한 줄에서 누른 가장 높은 프렛의 음이 발생
// if 현재줄 가장 높은 프렛의 음보다 더 높은 음 -> 손 떼지 않고 높은 프렛 누른 다음 팅김
// else 높은 음들 다 떼고 (s.top() 이용) 해당 음 프렛 누른 다음 팅기기

int main(){
    int n,p;
    int cnt=0;
    stack<int> s[7];

    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> p;

    while(n--){
        int a,b;
        cin >> a >> b;

        while(!s[a].empty() && s[a].top() > b){
            // 스택이 비어있지 않으면서, 내고 싶은 음보다 현재 프렛의 음이 높으면
            s[a].pop(); // 제일 위 프렛부터 손을 떼고
            cnt++; // 카운트 세준다.
        } // -> 내고 싶은 음보다 작은 음은 다 빼기

        if(s[a].empty() || s[a].top()!=b){ // 눌린 프렛이 없거나 제일 위 프렛 음이 누르려는 음이랑 같으면
            s[a].push(b); // b 프렛 누르고 팅기기
            cnt++;
        }
    }

    cout << cnt << "\n";
}
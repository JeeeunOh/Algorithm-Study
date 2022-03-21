#include <iostream>
#include <queue>
using namespace std;

int main(){
    queue<int> q;

    int n, idx;
    cin >> n >> idx;

    for(int i=1 ; i<=n ; i++){
        q.push(i);
    }

    int cur=0;

    cout << "<";
    
    int temp=idx;
    while(true){
        int front = q.front();
        q.pop();
        temp--;
        if(temp==0) { // 다음으로 넘기기
            cout << front;
            temp=idx;
            if(q.empty()) break; // 큐 다 탐색했으면 끝내기
            else{
                cout << ", ";
            }
        } else{ 
            q.push(front);
        }
    }

    cout << ">" << "\n";
}
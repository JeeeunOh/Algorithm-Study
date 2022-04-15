#include <iostream>
#include <queue>
using namespace std;

int main(){
    int n,w,L; // 트럭개수, 다리길이, 다리하중
    int car[1001];
    queue<int> bridge;

    cin >> n >> w >> L;

    for(int i=0 ; i<n ; i++) cin >> car[i];

    int time=0;
    int total=0; // 현재 다리에 올라가있는 무게
    int idx=0;

    for(int i=0 ; i<n-1 ; i++) bridge.push(0); // n-1개 만큼의 빈공간 넣기
    
    while(!bridge.empty()){
        // 제일 앞 트럭 무게 total에서 빼고 pop하기
        int front = bridge.front();
        total-=front;
        bridge.pop();

        if(idx<n){ // 아직 넣을 차 남아있으면
            if(total+car[idx]<=L){ // 다리에 차 넣을 수 있으면 넣고
                bridge.push(car[idx]);
                total+=car[idx];
                idx++;
            } else{ // 넣을 수 없으면 허수 넣기
                bridge.push(0); 
            }
        }

        time++;

        cout << time <<", " << idx << " : " << bridge.front() << ", " << bridge.back() << '\n';
    }

    cout << time << '\n';
}
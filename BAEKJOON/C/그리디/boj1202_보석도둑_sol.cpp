#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
const int MAX = 300000;

int N, K;
int bag[MAX];
pair<int, int> jewelry[MAX];
priority_queue<int> pq; //maxHeap 사용

int main(void){
        ios_base::sync_with_stdio(0);
        cin.tie(0); //cin 실행속도 향상
        cin >> N >> K;

        for (int i = 0; i < N; i++) cin >> jewelry[i].first >> jewelry[i].second;
        for (int i = 0; i < K; i++) cin >> bag[i];
    // 1. pair<int, int>형 배열에 보석의 정보를 입력받고 int형 배열에 가방의 정보를 입력받습니다.
    // 2. 보석은 무게를 기준으로 오름차순 정렬을 하고 가방은 최대 무게 허용량을 기준으로 오름차순 정렬을 합니다.
    // 3. 핵심은 한 번 확인한 보석은 다시 확인하지 않는 것입니다.
        // i) 가방의 개수만큼 반복문을 돌립니다.
        // ii) 해당 가방이 허용할 수 있는 보석까지 우선순위 큐에 넣습니다.
        // iii) 우선순위 큐는 maxHeap이기 때문에 넣은 보석들 중 제일 비싼 보석이 root에 있습니다.
        // iv) 따라서, 우선순위 큐의 root에 있는 보석을 가방에 넣어주고 해당 보석을 우선순위 큐에서 pop합니다.
    // 4. 3번을 모든 가방에 대해 반복합니다.


 

        //보석(무게 기준)과 가방 오름차순 정렬
        sort(jewelry, jewelry + N);
        sort(bag, bag + K);

        long long result = 0;
        int idx = 0;

        //무게제한이 낮은 가방부터 최대한 비싼 보석을 넣는 방법
        for (int i = 0; i < K; i++){

                 //i 번째 가방의 무게제한에 충족하는 보석 다 넣음
                 while (idx < N && jewelry[idx].first <= bag[i])
                    pq.push(jewelry[idx++].second);
                    
                 //pq의 루트에는 현재 기준 제일 비싼 보석이 들어있음
                 if (!pq.empty()){
                         result += pq.top();
                         pq.pop();
                 }
        }
        cout << result << "\n";
        return 0;
}